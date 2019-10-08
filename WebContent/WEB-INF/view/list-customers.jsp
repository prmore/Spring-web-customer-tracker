<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Customer list</title>
	
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
	
	<div id="wrapper">
		<div id="header">
			<h1>CRM - Customer Relationship Manager</h1>
		</div>
	</div>

	<div id="container">
		<div id="content">
			
			<input type="button" value = "Add customer" 
				onclick = "window.location.href='showFormForAdd'; return false;"
				class = "add-button"/>
			
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>First Name</th>
					<th>Action</th>
				</tr>
			
				
			
				<!-- get customers and display -->
				<c:forEach var="tempCust" items="${customers}">
				
					<!-- Contrcuct update link with customer id -->
					<c:url var="updateLink" value="/customerCNT/showFormForUpdate">
						<c:param name="custID" value="${tempCust.id }"></c:param>
					</c:url>
					
					<c:url var="deleteLink" value="/customerCNT/delete">
						<c:param name="custID" value="${tempCust.id}"></c:param>
					</c:url>
				
					<tr>
						<td>${tempCust.firstName}</td>
						<td>${tempCust.lastName}</td>
						<td>${tempCust.email}</td>
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink }" onclick="if(!(confirm('Are you sure you want to delete a customer?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			
		</div>
	</div>

</body>
</html>