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

            		if($('span.info-box-text').html() === 'Proceso terminado' ){        			
            			
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
        };

        // Private Functions
        function debug(e) {
          console.log(e);
        }

        base.init();
    };

    
    $.fn.formExchangeRate = function(options){

        return this.each(function(){

            var bp = new $.formExchangeRate(this, options);

            $(".exchange-rate-process").click(function( event ) {          	
                bp.process(this);
            });
            
            
            $(".exchange-rate-new").click(function( event ) {          	
                bp.news(this);
            });

        });
    };

})(jQuery);



