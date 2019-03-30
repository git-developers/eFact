(function($) {
    "use strict";

    // Global Variables
    var MAX_HEIGHT = 100;

    $.PaymentVoucher = function(el, options) {

        // Global Private Variables
        var MAX_WIDTH = 200;
        var base = this;
        var apiContent = null;

        base.$el = $(el);
        base.el = el;
        base.$el.data('PaymentVoucher', base);

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
        
        base.addRow = function(context) {
        	var clone = $("table.table-payment-voucher-clone tbody").find('tr').clone();        	
        	$("table.table-payment-voucher tbody").append(clone);
        };
        
        base.removeRow = function(context) {
        	$(context).closest('tr').remove();
        };
        
        base.changeRecaudo = function(context) {
        	var idRecaudo = $(context).val();
        	
        	console.log("idRecaudo :::: " + idRecaudo);
        	
        	$(context).closest("select").find("option[data-id-recaudo='" + idRecaudo + "']").prop('selected', true);
        	
        	
        };

        // Private Functions
        function debug(e) {
          console.log(e);
        }

        base.init();
    };

    $.fn.PaymentVoucher = function(options){

        return this.each(function(){

            var bp = new $.PaymentVoucher(this, options);

            $("table.table-payment-voucher span.add-row").click(function( event ) {          	
                bp.addRow(this);
            });
            
         	$(document).on('click', 'button.remove-row', function(event) {
                bp.removeRow(this);
            });
            
         	$(document).on('change', 'select[name=gridRecaudo]', function(event) {
                bp.changeRecaudo(this);
            });
         	
 
            /*
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
			*/

        });
    };

})(jQuery);



