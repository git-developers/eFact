<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="form-registro">
   	<div class="col-md-6">
      	<div class="form-group">
          <label for="">Programa</label>
          <input 
         		type="text" 
         		class="form-control"
         		value="<s:property value="listTrData.programa"/>" 
         		readonly="readonly">
        </div>
     </div>

   	<div class="col-md-2">
      	<div class="form-group">
          <label for="">Grupo</label>
          <input 
         		type="text" 
         		class="form-control"
         		value="<s:property value="listTrData.grupo"/>" 
         		readonly="readonly">
        </div>
     </div>     
     
   	<div class="col-md-2">
      	<div class="form-group">
          <label for="">Cupo</label>
          <input 
         		type="text" 
         		class="form-control"
         		value="<s:property value="listTrData.cupo"/>" 
         		readonly="readonly">
        </div>
     </div>

   	<div class="col-md-6">
      	<div class="form-group">
          <label for="">Asociado</label>
          <input 
         		type="text" 
         		class="form-control"
         		value="<s:property value="listTrData.asociado"/>" 
         		readonly="readonly">
        </div>
     </div>

   	<div class="col-md-2">
      	<div class="form-group">
          <label for="">Contrato</label>
          <input 
         		type="text" 
         		class="form-control"
         		value="<s:property value="listTrData.contrato"/>" 
         		readonly="readonly">
        </div>
     </div>


   	<div class="col-md-2">
      	<div class="form-group">
          <label for="">N° Cuota</label>
          <input 
         		type="text" 
         		class="form-control"
         		value="<s:property value="listTrData.cuota"/>" 
         		readonly="readonly">
        </div>
     </div>     

</div> 
          
          
<div class="tabbable"> <!-- Only required for left/right tabs -->
      <ul class="nav nav-tabs">
      <li class="active"><a href="#tab1" data-toggle="tab" style="color: #555;">Detalle de pagos</a></li>
      <li><a href="#tab2" data-toggle="tab" style="color: #555;">Abono</a></li>
      </ul>
      <div class="tab-content">
	      <div class="tab-pane active" id="tab1">
			
			<table class="table table-condensed">
			     <thead>
					<tr>
					   <th style="width: 15px">#</th>
					   <th><i class="fa fa-fw fa-cube"></i> Recaudo</th>
					   <th><i class="fa fa-fw fa-list-ul"></i> Monto Programado</th>
					   <th><i class="fa fa-fw fa-dot-circle-o"></i> Monto Pagado</th>
					 </tr>
			    </thead>
			    <tbody>
					<s:if test="listTrData.empty">
					    <tr>
							<td colspan="4" align="center">
								El proceso no retorno datos.
							</td>
						</tr>
					</s:if>
					<s:else>
						
						<s:iterator value="listTrData.listVoucherTrDataDetail" var="object" status="status">
							<tr>
								<td>
									<span class="badge bg-aqua-active margin">
										<s:property value="%{#status.index + 1}"/>
									</span>
								</td>
								<td class="text-left">
									<button type="button" class="btn bg-purple btn-flat btn-xs">
										<s:property value = "#object.recaudo"/>
									</button>
								</td>
								<td class="text-right">
									<s:property value = "#object.montoProgramado"/>
								</td>
								<td class="text-right">
									<s:property value = "#object.montoPagado"/>
								</td>
							</tr>
						 </s:iterator>
					</s:else>
			   </tbody>
			</table>

	      </div>
	      <div class="tab-pane" id="tab2">
	      
	      				
				<div class="form-abono">
				   	<div class="col-md-6">
				      	<div class="form-group">
				          <label for="">Banco</label>
				          <input 
				         		type="text" 
				         		class="form-control"
				         		value="<s:property value="listTrData.banco"/>" 
				         		readonly="readonly">
				        </div>
				     </div>
				
				   	<div class="col-md-4">
				      	<div class="form-group">
				          <label for="">Cuenta-Bancaria</label>
				          <input 
				         		type="text" 
				         		class="form-control"
				         		value="<s:property value="listTrData.cuentaBancaria"/>" 
				         		readonly="readonly">
				        </div>
				     </div>     
				     
				   	<div class="col-md-6">
				      	<div class="form-group">
				          <label for="">Fecha-Deposito</label>
				          <input 
				         		type="text" 
				         		class="form-control"
				         		value="<s:property value="listTrData.fecDeposito"/>" 
				         		readonly="readonly">
				        </div>
				     </div>
				
				   	<div class="col-md-4">
				      	<div class="form-group">
				          <label for="">Moneda</label>
				          <input 
				         		type="text" 
				         		class="form-control"
				         		value="<s:property value="listTrData.moneda"/>" 
				         		readonly="readonly">
				        </div>
				     </div>
				
				   	<div class="col-md-6">
				      	<div class="form-group">
				          <label for="">Monto</label>
				          
				          <input 
				         		type="text" 
				         		class="form-control"
				         		value="<s:property value="listTrData.monto"/>" 
				         		readonly="readonly" class="text-right">
				        </div>
				     </div>
				
				
				   	<div class="col-md-4">
				      	<div class="form-group">
				          <label for="">Saldo</label>
				          <input 
				         		type="text" 
				         		class="form-control"
				         		value="<s:property value="listTrData.saldo"/>" 
				         		readonly="readonly" class="text-right">
				        </div>
				     </div>     
				
				</div> 
	      	
	      	
	      	
	      </div>
	  </div>
</div>        
        
          