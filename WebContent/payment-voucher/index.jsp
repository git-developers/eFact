<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../themes/adminLTE/header.jsp" %>

    <section class="content-header">
      <h1>
        <i class="fa fa-fw fa-file-text-o"></i> Comprobantes Manual
        <small>grid</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
      </ol>
    </section>
    
    <section class="content">
    
        <div class="row">
        <div class="col-md-12">
		<div class="box box-solid">
			<%-- 
            <div class="box-header with-border">
              <h3 class="box-title">Quick Example</h3>
            </div>
            --%>
            <form role="form" name="form-voucher">
              <div class="box-body">
              
                <div class="row">
                
					<div class="col-md-2">
					    <div class="form-group">
					      <label for="">Contrato</label>
					        <div class="input-group">
					          <div class="input-group-addon">
					            <i class="fa fa-qrcode"></i>
					          </div>
					          <input type="number" class="form-control" name="queryContrato">
					        </div>
					    </div>
					</div>
                
	        		<div class="col-md-2">
		                <div class="form-group">
		                  <label for="">Tipo Doi</label>
		                  <select class="form-control" id="tipoDoi" name="queryTipoDoi" required="required">
		                  	<s:iterator value="paymentHeader.listPaymentTipoDoi" var="obj">
		                  		<option value="<s:property value = "#obj.idTipoDoi"/>">
		                  			<s:property value = "#obj.nombreCorto"/>
	                  			</option>
	                  		</s:iterator>
		                  </select>
		                </div>
	        		</div>

					<div class="col-md-2">
					    <div class="form-group">
					      <label for="">Numero DOI</label>
					        <div class="input-group">
					          <div class="input-group-addon">
					            <i class="fa fa-qrcode"></i>
					          </div>
					          <input type="number" class="form-control" name="queryContrato">
					        </div>
					    </div>
					</div>
					
	        		<div class="col-md-2">
		                <div class="form-group pull-right">
		                  <label for="">&nbsp;</label>
							<div class="input-group">
			                  <button type="button" class="btn btn-default payment-voucher-search">Buscar</button>
			                </div>
		                </div>
	        		</div>

	        		<div class="col-md-2">
		                <div class="form-group pull-right">
		                  <label for="">&nbsp;</label>
							<div class="input-group">
			                  <button type="button" class="btn btn-default payment-voucher-process" >Procesar</button>
			                </div>
		                </div>
	        		</div>

        		</div>

              </div>

				<%-- 
              <div class="box-footer text-right">
                <button type="submit" class="btn btn-sm btn-primary ">Filtro</button>
                <button type="button" class="btn btn-sm btn-success ">Por defecto</button>
              </div>
              --%>
              
            </form>
          </div>
          </div>
          </div>
    
    
    
      <div class="row">
        <div class="col-md-12">
		<div class="box box-primary">
            <div class="box-header with-border">
	              <h3 class="box-title">
	              	Detalle
				  </h3>
            </div>
            <div class="box-body">
            
            	<!-- FIRST ROW -->
                <div class="row">
                
					<div class="col-md-6">
					    <div class="form-group">
					      <label for="">Asociado</label>
					        <div class="input-group">
					          <div class="input-group-addon">
					            <i class="fa fa-qrcode"></i>
					          </div>
					          <input type="text" class="form-control" name="queryAsociado">
					        </div>
					    </div>
					</div>
					
					<div class="col-md-2">
					    <div class="form-group">
					      <label for="">Comprobante</label>
		                  <select class="form-control" name="queryComprobante" required="required">
		                  	<s:iterator value="paymentHeader.listPaymentTipoComprobante" var="obj">
		                  		<option value="<s:property value = "#obj.cscTipo"/>">
		                  			<s:property value = "#obj.cscTipoNombre"/>
	                  			</option>
	                  		</s:iterator>
		                  </select>
					    </div>
					</div>
					
					<div class="col-md-2">
					    <div class="form-group">
					      <label for="">Serie</label>
					        <div class="input-group">
					          <div class="input-group-addon">
					            <i class="fa fa-qrcode"></i>
					          </div>
					          <input type="number" class="form-control" name="querySerie">
					        </div>
					    </div>
					</div>
					
					<div class="col-md-2">
					    <div class="form-group">
					      <label for="">Numero</label>
					        <div class="input-group">
					          <div class="input-group-addon">
					            <i class="fa fa-qrcode"></i>
					          </div>
					          <input type="number" class="form-control" name="queryNumero">
					        </div>
					    </div>
					</div>
					
				</div>
				<!-- FIRST ROW -->
				
				
            	<!-- SECOND ROW -->
                <div class="row">
                
					<div class="col-md-3">
					    <div class="form-group">
					      <label for="">Cuota</label>
					        <div class="input-group">
					          <div class="input-group-addon">
					            <i class="fa fa-qrcode"></i>
					          </div>
					          <input type="text" class="form-control" name="queryCuota">
					        </div>
					    </div>
					</div>
					
					<div class="col-md-3">
					    <div class="form-group">
					      <label for="">Fecha de emisi&oacute;n</label>
					        <div class="input-group">
					          <div class="input-group-addon">
					            <i class="fa fa-calendar"></i>
					          </div>
					          <input type="date" class="form-control" name="queryFechaEmision">
					        </div>
					    </div>
					</div>
					
					<div class="col-md-3">
					    <div class="form-group">
					      <label for="">Fecha de vencimiento</label>
					        <div class="input-group">
					          <div class="input-group-addon">
					            <i class="fa fa-calendar"></i>
					          </div>
					          <input type="date" class="form-control" name="queryFechaVencimiento">
					        </div>
					    </div>
					</div>
					
					<div class="col-md-2">
					    <div class="form-group">
					      <label for="">Moneda</label>
		                  <select class="form-control" name="queryMoneda" required="required">
		                  	<s:iterator value="paymentHeader.listPaymentTipoMoneda" var="obj">
		                  		<option value="<s:property value = "#obj.idMoneda"/>">
		                  			<s:property value = "#obj.nombreCorto"/>
	                  			</option>
	                  		</s:iterator>
		                  </select>
					    </div>
					</div>
					
				</div>
				<!-- SECOND ROW -->
				
				
            	<!-- THIRD ROW -->
                <div class="row">
                
					<div class="col-md-4">
					    <div class="form-group">
					      <label for="">Total</label>
					        <div class="input-group">
					          <div class="input-group-addon">
					            <i class="fa fa-money"></i>
					          </div>
					          <input type="text" class="form-control" name="queryTotal">
					        </div>
					    </div>
					</div>
					
					<div class="col-md-8">
					    <div class="form-group">
					      <label for="">Total texto</label>
					        <div class="input-group">
					          <div class="input-group-addon">
					            <i class="fa fa-money"></i>
					          </div>
					          <input type="text" class="form-control" name="queryTotal">
					        </div>
					    </div>
					</div>
					
				</div>
				<!-- THIRD ROW -->
				
				
            	<!-- FOURTH ROW -->
                <div class="row">
                
                <div class="col-md-12">
					<table class="table table-bordered table-payment-voucher">
						<thead class="bg-light-blue-active">
			                <tr>
			                  <th>Recaudo</th>
			                  <th>Concepto</th>
			                  <th>No afecto</th>
			                  <th>Afecto</th>
			                  <th>IGV</th>
			                  <th><i class="fa fa-money"></i> Total</th>
			                  <th>
			                  		<span class="badge bg-green add-row x-hand">
			                  			<i class="fa fa-fw fa-plus"></i> agregar
		                  			</span>
	                  		  </th>
			                </tr>
						</thead>
		                <tbody></tbody>
					  <tfoot>
					  </tfoot>
	              </table>
                </div>
                
                </div>
                <!-- FOURTH ROW -->
              
            </div>
            
            
            <div class="box-footer clearfix">
            	&nbsp;
            </div>
            
          </div>
       	</div>
     </div>
     
     
  
	<table class="table table-bordered table-payment-voucher-clone" style="display: none;">
	   <tbody>
	     <tr>
	       <td>
		        <select class="form-control" name="gridRecaudo" required="required">
		        	<s:iterator value="paymentHeader.listPaymentRecaudo" var="obj">
		        		<option value="<s:property value = "#obj.idRecaudo"/>">
		        			<s:property value = "#obj.descripcion"/>
		       			</option>
		       		</s:iterator>
		        </select>
	        </td>
	       <td>
		        <select class="form-control" name="gridConcepto" required="required">
		        	<s:iterator value="paymentHeader.listPaymentConcepto" var="obj">
		        		<option value="<s:property value = "#obj.idConcepto"/>" data-id-recaudo="<s:property value = "#obj.idRecaudo"/>">
		        			<s:property value = "#obj.descripcion"/>
		       			</option>
		       		</s:iterator>
		        </select>
	        </td>
	         <td>
	         	<input type="text" class="form-control" name="gridNoAfecto">
	         </td>
	         <td>
	         	<input type="text" class="form-control" name="gridAfecto">
	         </td>
	         <td>
	         	<input type="text" class="form-control" name="gridIgv">
	         </td>
	         <td>
	         	<input type="text" class="form-control" name="gridTotal">
	         </td>
	         <td>
	          <button type="button" class="btn btn-danger btn-xs remove-row">
	          	<i class="fa fa-trash"></i>
	          </button>
	         </td>
	       </tr>
	   </tbody>
	</table>
     

</section>
     

<%-- <%@include file="../modal/info-dialog.jsp" %> --%>

     
<%@include file="../themes/adminLTE/footer.jsp" %>

