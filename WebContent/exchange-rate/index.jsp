<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../themes/adminLTE/header.jsp" %>

    <section class="content-header">
      <h1>
        <i class="fa fa-dollar"></i> Tipo de cambio
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
            <form role="form" name="form-exchange-rate">
              <div class="box-body">
              
                <div class="row">
                       		
	        		
					<div class="col-md-2">
					    <div class="form-group">
					      <label for="exampleInputEmail1">Fecha de cambio</label>
					        <div class="input-group">
					         <!--   <div class="input-group-addon">
					            <i class="fa fa-calendar"></i>
					          </div>-->
					          <input type="date" class="form-control" name="queryFrom" value="<s:property value="currentDate"/>">
					        </div>
					    </div>
					</div>
	        		
	        		
    			    <div class="col-md-2">
		                <div class="form-group">
		                  <label for="">Compra</label>
				          <input type="number" class="form-control" name="queryCompra" value=".00" >
		                </div>
	        		</div>
	        		
	        		<div class="col-md-2">
		                <div class="form-group">
		                  <label for="">Venta</label>
		                  <input type="number" class="form-control" name="queryVenta" value=".00">
		                </div>
	        		</div>
	        		
	        		
	        		<div class="col-md-2">
		                <div class="form-group pull-right">
		                  <label for="">&nbsp;</label>
							<div class="input-group">
			                  <button type="button" class="btn btn-default exchange-rate-process">Guardar</button>
			                </div>
		                </div>
	        		</div>

	        		<div class="col-md-2">
		                <div class="form-group pull-right">
		                  <label for="">&nbsp;</label>
							<div class="input-group">
							
			                  <!--  <button type="button" class="btn btn-default note-credit-process" disabled="disabled">Nuevo</button> -->
			                  <!-- Botón nuevo debe resetear cabecera y habilitar botón guardar-->
			                  
			                  <button type="button" class="btn btn-default exchange-rate-new" >Nuevo</button>
			                  
			                  <!--  <button type="button" class="btn btn-default exchange-rate-new" disabled="disabled">Nuevo</button>-->
			                  
			                </div>
		                </div>
	        		</div>

        		</div>

              </div>

				<%--
              <div class="box-footer text-right">
              </div>
               --%>
            </form>
          </div>
          </div>
          </div>
    
		<!-- MAIN DIV 
		 <div id="main-box-body" class="row">
		
		</div>
		MAIN DIV -->
		

    
      <div class="row">
        <div class="col-md-12">
		<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">
              	Historial
			</h3>
             	<small class="search-count label bg-green">0</small>
            </div>
            <div class="box-body">
            
	              <table id="exchangeRate-table" class="table table-bordered table-striped">
		              <thead>
						<tr>
						   <th style="width: 15px">#</th>
						   <!--  <th style="width: 15px"><input type="checkbox" id="check-all"></th> -->
						   <th class="text-center">Fecha</th>
						   <th class="text-center">Moneda</th>
						   <th class="text-center">Compra</th>
						   <th class="text-center">Venta </th>
						   <th class="text-center">Fecha Reg.</th>
						   <th class="text-center">Usuario Reg.</th>
						 </tr>
		              </thead>
			            <tbody>
			            
			            <!--  
				            <tr>
							   	<td colspan="14" align="center">
					   				No hay datos que mostrar.
					   			</td>					   								   			
				   			</tr>
				   		-->	
				   			
		                  	<s:iterator value="listExchangeRate" var="tcambio" status="status">
				            <tr> 
				            	<td> 
				            	
									<span class="badge bg-light-blue">
										<s:property value="%{#status.index + 1}"/>
									</span>
																				            	
		                  			<input type="hidden" name="erId" value=<s:property value = "#tcambio.id"/>>		   		                  			 	                  			
		                  			              			
		                  		</td>
				            	<td class="text-center"> 
		                  			<s:property value = "#tcambio.fecha"/>		                  			
		                  		</td>	
				            	<td> 
		                  			<s:property value = "#tcambio.moneda"/>	               			
		                  		</td>	
				            	<td  class="text-right">
		                  			<s:property value = "#tcambio.compra"/>		                  			
		                  		</td>	
				            	<td  class="text-right">
		                  			<s:property value = "#tcambio.venta"/>		                  			
		                  		</td>	
				            	<td class="text-center"> 
		                  			<s:property value = "#tcambio.fecCreacion"/>		                  			
		                  		</td>	
				            	<td> 
		                  			<s:property value = "#tcambio.userCreacion"/>		                  			
		                  		</td>	
		                  			
				   			</tr>
	                 		</s:iterator>		
	                 		
				   			
			          	</tbody>
	              </table>
              
            </div>
            
            <%-- 
            <div class="box-footer clearfix">

            </div>
            --%>
          </div>
       	</div>
     </div>		
     
     
     </section>
     
<%@include file="../modal/process-dialog.jsp" %>
     
<%@include file="../themes/adminLTE/footer.jsp" %>



        