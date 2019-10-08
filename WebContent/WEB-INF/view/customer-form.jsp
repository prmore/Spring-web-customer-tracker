<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Customer</title>

	<link type="text/css"
		rel = "stylesheet"
		href = "${pagecontext.request.contextPath }/resources/css/style.css" />
		
	<link type="text/css"
		rel = "stylesheet"
		href = "${pagecontext.request.contextPath }/resources/css/add-customer-style.css" />
</head>
<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
		
		<!-- need to associate data with current customer id -->
		<form:hidden path="id"/>
		
		<table>
			<tbody>
				<tr>
				<td><label>First name:</label></td>
				<td><form:input path="firstName"/></td>
				</tr>
			</tbody>
			
			<tbody>
				<td><label>Last name:</label></td>
				<td><form:input path="lastName"/></td>
			</tbody>
			
			<tbody>
				<td><label>Email:</label></td>
				<td><form:input path="email"/></td>
			</tbody>
			
			<tbody>
				<td><label></label></td>
				<td><input type="submit" value="Save" class="save" /></td>
			</tbody>
		</table>
		</form:form>
		
		<div style="clear;both;">
		</div>
		
		<p>
			<a href="${pageContext.request.contextPath }/customerCNT/list">Back to list </a>
		</p>
	</div>
	
</body>
</html>