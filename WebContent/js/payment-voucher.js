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
                url: options.contextPath + '/payment-voucher-search',
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
                	
                	console.log("***** search *********");
                	console.dir(JSON.parse(data));
                	
                	data = JSON.parse(data);
                	
                	let dropdown = $('select[name=queryCuota]');
                	dropdown.empty();
                	dropdown.append('<option selected="true" disabled>[ seleccionar ]</option>');
                	dropdown.prop('selectedIndex', 0);
                	
                	$.each(data.listPaymentCuota, function(key, value) {
                		dropdown.append('<option value=' + value.recTipo + '>' + value.campo + '</option>');
                	});
                	
                	$("button.note-credit-process").prop("disabled", false);
					
                },
                error: function(jqXHR, exception) {
                    console.log("error :: ajax :: voucher search");
                }
            });
        };
        
        base.process = function(context) {
        	
        	var row = {};		
        	row.queryContrato = $('input[name="queryContrato"]').val();
        	row.queryTipoDoi = $('select[name="queryTipoDoi"]').val();
        	row.queryNumeroDoi = $('input[name="queryNumeroDoi"]').val();
        	row.queryTitular = $('input[name="queryTitular"]').val();
        	row.queryDireccion = $('input[name="queryDireccion"]').val();
        	row.queryComprobante = $('select[name="queryComprobante"]').val();
        	row.querySerieComprobante = $('input[name="querySerieComprobante"]').val();
        	row.queryFechaEmision = $('input[name="queryFechaEmision"]').val();
        	row.queryFechaVencimiento = $('input[name="queryFechaVencimiento"]').val();
        	row.queryTotal = $('input[name="queryTotal"]').val();
        	row.queryTotalTexto = $('input[name="queryTotalTexto"]').val();
        	row.queryMoneda = $('select[name="queryMoneda"]').val();

        	var detalle = new Array();
			$("table.table-payment-voucher tbody tr").each(function(row, tr) {
				var obj = {};
				obj.gridRecaudo = $(tr).find("td:eq(0)").find('select[name="gridRecaudo"]').val();
				obj.gridConcepto = $(tr).find("td:eq(1)").find('select[name="gridConcepto"]').val();
				obj.gridNoAfecto = $(tr).find("td:eq(2)").find('input[name="gridNoAfecto"]').val();
				obj.gridAfecto = $(tr).find("td:eq(3)").find('input[name="gridAfecto"]').val();
				obj.gridIgv = $(tr).find("td:eq(4)").find('input[name="gridIgv"]').val();
				obj.gridTotal = $(tr).find("td:eq(5)").find('input[name="gridTotal"]').val();
				detalle.push(obj);
			});
			
			row.detalle = detalle;
			
			console.log(" **** process *** ");
			console.dir(row);
			
			
			return false;

            $.ajax({
                url: options.contextPath + '/payment-voucher-process',
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
        
        base.changeRecaudo = function(context, event) {
        	var idRecaudo = $(context).val();
        	var select = $(context).closest("tr").find("select[name=gridConcepto]");
        	
        	select.prop('selectedIndex', 0);
        	select.find("option.grid-concepto").hide();
        	select.find('*[data-id-recaudo="' + idRecaudo + '"]').show();
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
            
            $("form[name='form-payment-voucher']").submit(function(event) {
            	event.preventDefault();
                bp.search(this);
            });
            
            $("button.payment-voucher-process").click(function(event) {          	
                bp.process(this);
            });
            
         	$(document).on('change', 'select[name=gridRecaudo]', function(event) {
                bp.changeRecaudo(this, event);
            });

        });
    };

})(jQuery);



