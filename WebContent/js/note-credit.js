(function($) {
    "use strict";

    // Global Variables
    var MAX_HEIGHT = 100;

    $.formNoteCredit = function(el, options) {

        // Global Private Variables
        var MAX_WIDTH = 200;
        var base = this;
        var apiContent = null;

        base.$el = $(el);
        base.el = el;
        base.$el.data('formNoteCredit', base);

        base.init = function(){
            var totalButtons = 0;
        };

        base.search = function(context) {
            $.ajax({
                url: options.contextPath + '/note-credit-search',
                type: 'POST',
                dataType: 'html',
                data: {
                	fields: $(context).serialize()
                },
                beforeSend: function(jqXHR, settings) {
                	$('#modal-process').find('.modal-body').html('<p><i class="fa fa-2x fa-refresh fa-spin"></i><span style="font-size: 16px; margin-left: 5px">Procesando...</span></p>');
                	$("div#main-box-body").html('<div class="text-center"> <i class="fa fa-3x fa-refresh fa-spin"></i> </div>');
                },
                success: function(data, textStatus, jqXHR) {
                	
                	$("div#main-box-body").html(data); 
                	$("button.note-credit-process").prop("disabled", false);

					tipoNotaCredito();
					
                },
                error: function(jqXHR, exception) {
                    console.log("error :: ajax :: voucher search");
                }
            });
        };
        
        base.process = function(context) {
        	
        	var row = {};			
        	row ['queryVoucher'] = $('select[name="queryVoucher"]').val();
		    row ['querySerie'] = $('select[name="querySerie"]').val();			
        	row ['id'] = $('input[name="id"]').val();
        	row ['bd'] = $('input[name="bd"]').val();
        	row ['fechaEmision'] = $('input[name="fechaEmision"]').val();
        	row ['fechaVencimiento'] = $('input[name="fechaVencimiento"]').val();
        	row ['queryTotal'] = $('input[name="queryTotal"]').val();
        	row ['queryMoneyIntoWords'] = $('input[name="queryMoneyIntoWords"]').val();
        	row ['queryNoteCreditType'] = $('select[name="queryNoteCreditType"]').val();

        	var position=0;        	
			
			
			$(".row-checkbox").each(function()
			{
				position=position+1;
				if($(this).prop('checked')){
 					
					if( position == 1 ){
						row ['noAfecto_1'] = $('input[name="noAfecto-1"]').val();
						row ['afecto_1'] = $('input[name="afecto-1"]').val(); 
					}
					
					if( position == 2 ){
						row ['noAfecto_2'] = $('input[name="noAfecto-2"]').val();
						row ['afecto_2'] = $('input[name="afecto-2"]').val();
					}

					if( position == 3 ){
						row ['noAfecto_3'] = $('input[name="noAfecto-3"]').val();
						row ['afecto_3'] = $('input[name="afecto-3"]').val();
					}

					if( position == 4 ){
						row ['noAfecto_4'] = $('input[name="noAfecto-4"]').val();
						row ['afecto_4'] = $('input[name="afecto-4"]').val();
					}

					if( position == 5 ){
						row ['noAfecto_5'] = $('input[name="noAfecto-5"]').val();
						row ['afecto_5'] = $('input[name="afecto-5"]').val();
					}

					if( position == 6 ){
						row ['noAfecto_6'] = $('input[name="noAfecto-6"]').val();
						row ['afecto_6'] = $('input[name="afecto-6"]').val();
					}

					if( position == 7 ){
						row ['noAfecto_7'] = $('input[name="noAfecto-7"]').val();
						row ['afecto_7'] = $('input[name="afecto-7"]').val();
					}

					if( position == 8 ){
						row ['noAfecto_8'] = $('input[name="noAfecto-8"]').val();
						row ['afecto_8'] = $('input[name="afecto-8"]').val();
					}					
					
				}	
			});						

            $.ajax({
                url: options.contextPath + '/note-credit-process',
                type: 'POST',
                dataType: 'html',
                data: {
                	fields: JSON.stringify(row)
                },
                beforeSend: function(jqXHR, settings) {
                	$('#modal-process').find('.modal-body').html('<p><i class="fa fa-2x fa-refresh fa-spin"></i><span style="font-size: 16px; margin-left: 5px">Procesando...</span></p>');
                	$('#modal-process').modal('show');
                },
                success: function(data, textStatus, jqXHR) {	
            		$('#modal-process').modal('show');
            		$('#modal-process').find('.modal-body').html(data);
            		$("div#main-box-body :input").prop("disabled", true);
            		$("button.note-credit-process").prop("disabled", true);
                },
                error: function(jqXHR, exception) {
                    console.log("error :: ajax :: voucher search");
                }
            });
        };

        base.fechaEmisionChange = function(context) {
        	var fechaEmision = $(context).val(); 
        	$('input[name="fechaVencimiento"]').val(fechaEmision);
        };

        base.fechaVencimientoChange = function(context) {
        	var fechaVencimiento = $(context).val(); 
        	var fechaEmision = $('input[name="fechaEmision"]').val();
        	
        	if(new Date(fechaVencimiento) < new Date(fechaEmision))
        	{
        		$('input[name="fechaVencimiento"]').val(fechaEmision);
        		alert("La fecha de vencimiento no puede ser menor a la fecha de emision.");
        	}
        };
        
        base.rowCheckbox = function(context) {
        	
        	var position = $(context).data('position');
        	
        	if (!context.checked) {
        		asignaValoresIniciales(position); 											
        	}
        	
        	$(context).closest('tr').find('input[type=number]').prop('disabled', true);
            sumRowSubTotal(position);
            sumTotalFooter();
        };
        
        base.voucher = function(context) {
            var id = $('#select-voucher').val();  
            $('#select-series').prop('selectedIndex',0);
            $('.select-series').hide();
            $('.voucher-' + id).show();
        };
		
        base.credittype = function(context) {
			tipoNotaCredito();
        };		
        		
        base.rowNoAfecto = function(context) {
        	
            var value = $(context).val();
            var position = $(context).data('position');
            
            sumRowSubTotal(position);
            sumTotalFooter();
        };
        
        base.rowAfecto = function(context) {
        	
            var value = validInt( $(context).val() );
            var igv = validInt( $('input[name=igv]').val() );
            var position = $(context).data('position');
            var newIgv = parseFloat(value) * 0.18;	

            $('.td-igv-' + position).html(newIgv.toFixed(2));
            
            sumRowSubTotal(position);
            sumTotalFooter();
        };
		
		function tipoNotaCredito(){
            var id = $('#note-credit-type').val();  
			
			if( id == '6'){
				$(".row-checkbox").prop( "checked", true );
				$(".row-checkbox").prop('disabled', true);
				sumTotalFooter();								
			} else {
				$(".row-checkbox").removeAttr("disabled");
			}			
		}
		
        function asignaValoresIniciales(position) {
  
        	var tableReg = document.getElementById('tablaComprobanteOrigen');
        	var tableNotaCredito = document.getElementById('tablaComprobanteNotaCredito');
        	var noAfecto = 0;
        	var afecto = 0;
        	var igv = 0;
        	var stotal = 0;        	
        	        	
        	noAfecto = tableReg.rows[position].getElementsByTagName('td')[2].innerHTML;
        	afecto   = tableReg.rows[position].getElementsByTagName('td')[3].innerHTML;
        	igv      = tableReg.rows[position].getElementsByTagName('td')[4].innerHTML;
        	stotal   = tableReg.rows[position].getElementsByTagName('td')[5].innerHTML;
        	    	        	
        	$('input[name=noAfecto-' + position + ']').val((parseFloat(noAfecto)).toFixed(2));
        	$('input[name=afecto-' + position + ']').val((parseFloat(afecto)).toFixed(2));        	
        	$('.td-igv-' + position ).html((parseFloat(igv)).toFixed(2));
        	$('.sub-total-' + position ).html((parseFloat(stotal)).toFixed(2));		
        }        
        
        function sumRowSubTotal(position) {
        	
        	console.log("::: sumRowSubTotal ::: " );
        	console.log("position ::: " + position);
        	console.log("noAfecto position ::: " + $('input[name=noAfecto-' + position + ']').val());
        	console.log("afecto position ::: " + $('input[name=afecto-' + position + ']').val() );
        	console.log("td-igv ::: " + $('.td-igv-' + position).html());
        	
        	
        	
            var noAfecto = validInt( $('input[name=noAfecto-' + position + ']').val() );
            var afecto = validInt( $('input[name=afecto-' + position + ']').val() );
            var igv = validInt( $('.td-igv-' + position).html() );

            var newSubTotal = parseFloat(noAfecto) + parseFloat(afecto) + parseFloat(igv);
            $('.sub-total-' + position).html(newSubTotal.toFixed(2));
        }
        
        function sumTotalFooter() {
			
			console.log("sumTotalFooter");
        	
        	var noAfecto = 0;
        	var afecto = 0;
        	var igv = 0;
        	var total = 0;
			var position = 0;

			$(".row-checkbox").each(function()
			{
				position=position+1;
				if($(this).prop('checked')){ 					
    				noAfecto += parseFloat(validInt( $('input[name=noAfecto-' + position + ']').val() ));
    				afecto += parseFloat(validInt( $('input[name=afecto-' + position + ']').val() ));
    				igv += parseFloat(validInt( $('.td-igv-' + position).html() ));
    				total += parseFloat(validInt( $('.sub-total-' + position).html() ));
				}	
			});			

    		$('.no-afecto-footer-sum').html(noAfecto.toFixed(2));
    		$('.afecto-footer-sum').html(afecto.toFixed(2));
    		$('.igv-footer-sum').html(igv.toFixed(2));
        	$('.total-footer-sum').html(total.toFixed(2));
        	$("input[name='queryTotal']").val(total.toFixed(2)).change();
        }
        
        function validInt(number) {
            if (typeof number == 'undefined' || isNaN(number) || number == ""){
                return 0;
            }

            return number;
        }
        
        function resetRowToZero(position) {
            $('input[name=noAfecto-' + position + ']').val(0);
            $('input[name=afecto-' + position + ']').val(0);
            $('.td-igv-' + position).html(0);
            $('.sub-total-' + position).html(0);
        }

        // Private Functions
        function debug(e) {
          console.log(e);
        }

        base.init();
    };

    $.fn.formNoteCredit = function(options){

        return this.each(function(){

            var bp = new $.formNoteCredit(this, options);

            $("form[name='form-note-credit']").submit(function( event ) {
            	event.preventDefault();
                bp.search(this);
            });
            
            $(".note-credit-process").click(function( event ) {          	
                bp.process(this);
            });
            
            $("#select-voucher").change(function(event) {
            	bp.voucher(this);
        	});

         	$(document).on('change', '#note-credit-type', function(event) {
                bp.credittype(this);
            });
 
        	$(document).on('change', 'input:checkbox.row-checkbox', function(event) {
                bp.rowCheckbox(this);
            });
        	
            $(document).ready(function(){
            	bp.voucher(this);				
            });
            
        	$(document).on('keyup', '.row-afecto', function(event) {
                bp.rowAfecto(this);
            });
        	
        	$(document).on('keyup', '.row-no-afecto', function(event) {
                bp.rowNoAfecto(this);
            });
        	
        	$(document).on('change', 'input[name="fechaEmision"]', function(event) {
                bp.fechaEmisionChange(this);
            });
    		
        	$(document).on('change', 'input[name="fechaVencimiento"]', function(event) {
                bp.fechaVencimientoChange(this);
            });

        });
    };

})(jQuery);



