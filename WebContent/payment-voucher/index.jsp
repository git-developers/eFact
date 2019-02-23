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
		                  	<s:iterator value="listProgram" var="program">
		                  		<option value="<s:property value = "#program.id"/>">
		                  			<s:property value = "#program.name"/>
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
            
				XXXXXXXXXXXXXXXX
              
            </div>
            
            <%-- 
            <div class="box-footer clearfix"></div>
            --%>
          </div>
       	</div>
     </div>
     </section>
     

<%-- <%@include file="../modal/info-dialog.jsp" %> --%>

     
<%@include file="../themes/adminLTE/footer.jsp" %>

