(function($) {
    "use strict";

    // Global Variables
    var MAX_HEIGHT = 100;

    $.formExchangeRate = function(el, options) {

        // Global Private Variables
        var MAX_WIDTH = 200;
        var base = this;
        var apiContent = null;

        base.$el = $(el);
        base.el = el;
        base.$el.data('formExchangeRate', base);

        base.init = function(){
            var totalButtons = 0;
            
            console.log("test :: ajax :: Ok!");
            
        };

     
        
        base.process = function(context) {        	
        	
        	var valueCompra = parseFloat($('input[name="queryCompra"]').val());
        	var valueVenta  = parseFloat($('input[name="queryVenta"]').val());
        	        	        	
        	var row = {};			
        	row ['fecha']  = $('input[name="queryFrom"]').val();		
        	//row ['compra'] = $('input[name="queryCompra"]').val();
        	//row ['venta']  = $('input[name="queryVenta"]').val();
        	row ['compra'] = valueCompra.toFixed(3);        	
        	row ['venta']  = valueVenta.toFixed(3);
        	row ['userCreacion'] = 'EFACT';
		    //row ['moneda'] = $('select[name="querySerie"]').val();        	

      		
        	console.log("ROWS ::: " + JSON.stringify(row));

            $.ajax({
                url: options.contextPath + '/exchange-rate-process',
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
            		$("button.exchange-rate-process").prop("disabled", true);
            		

            		//console.log("info-box-text :: "+ $('span.info-box-text').html());
            		
            		
            		if($('span.info-box-text').html() === 'Proceso terminado' ){
            			
            			//prepend
            			//append
            			//$('#exchangeRate-table > tbody').append('<tr>'
            			
            			
            			//+'<td class="text-right">'+row ['compra'].toFixed(3)+'</td>'
        				//+'<td class="text-right">'+row ['venta'].toFixed(3)+'</td>'            			
            			
            			$('#exchangeRate-table').prepend('<tr>'
                				+'<td><span class="badge bg-light-blue">0</span></td>'
                				+'<td class="text-center">'+row ['fecha']+'</td>'
                				+'<td>Dólares</td>'
                				+'<td class="text-right">'+row ['compra']+'</td>'
                				+'<td class="text-right">'+row ['venta'] +'</td>'
                				+'<td class="text-center">'+row ['fecha']+' 00:00'+'</td>'
                				+'<td>'+row ['userCreacion']+'</td> </tr>');            			            	
            			
            		}
            		
            		            		
                },
                error: function(jqXHR, exception) {
                    console.log("error :: ajax :: exchange-rate process");
                }
            });
        };
        
        
        
        
        base.news = function(context) {
          
            $('input[name="queryCompra"]').val(0.00);
            $('input[name="queryVenta"]').val(0.00);
            $("button.exchange-rate-process").prop("disabled", false);
            
        	console.log("News ::: Ok" );
        	
        };
        

        /*
        
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
        */

        // Private Functions
        function debug(e) {
          console.log(e);
        }

        base.init();
    };

    
    $.fn.formExchangeRate = function(options){

        return this.each(function(){

            var bp = new $.formExchangeRate(this, options);

            /*
            $("form[name='form-exchange-rate']").submit(function( event ) {
            	event.preventDefault();
                bp.process(this);
            });
            */

            $(".exchange-rate-process").click(function( event ) {          	
                bp.process(this);
            });
            
            
            $(".exchange-rate-new").click(function( event ) {          	
                bp.news(this);
            });
            
            
            
            /*
            $("#select-voucher").change(function(event) {
            	bp.voucher(this);
        	});
 

 
         	$(document).on('change', '#note-credit-type', function(event) {
                bp.credittype(this);
            });
 
        	$(document).on('change', 'input:checkbox.row-checkbox', function(event) {
                bp.rowCheckbox(this);
            });
        	*/
        	
            $(document).ready(function(){
            	
            	//bp.voucher(this);
            	
            });
            
            
            /*
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



