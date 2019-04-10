<%@ taglib prefix="s" uri="/struts-tags" %>
 
<s:if test="%{paymentProcess.exito}">
	<%@include file="../../modal/success.jsp" %>
</s:if>
<s:else>
	<%@include file="../../modal/error.jsp" %>
</s:else>


<table class="table table-condensed">
     <thead>
		<tr>
		   <th><i class="fa fa-fw fa-align-justify"></i> Resultado</th>
		 </tr>
    </thead>
    <tbody>
		<tr>
			<td>
				<s:if test="%{paymentProcess.exito}">
					<s:property value = "paymentProcess.numeroComprobante"/>
				</s:if>
				<s:else>
					<s:property value = "paymentProcess.mensaje"/>
				</s:else>
			</td>
		</tr>
   </tbody>
</table>