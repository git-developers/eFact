<%@ taglib prefix="s" uri="/struts-tags" %>
 
<%@include file="../../modal/success.jsp" %>

<table class="table table-condensed">
     <thead>
		<tr>
			<th style="width: 15px">#</th>
		   <th><i class="fa fa-fw fa-align-justify"></i> Numero de comprobante</th>
		 </tr>
    </thead>
    <tbody>
		<s:iterator value="listPaymentFormProcess" var="object" status="status">
			<tr>
				<td>
					<span class="badge bg-olive margin">
						<s:property value="%{#status.index + 1}"/>
					</span>
				</td>
				<td>
					<s:property value = "#object.numeroComprobante"/>
				</td>
			</tr>
		</s:iterator>
   </tbody>
</table>