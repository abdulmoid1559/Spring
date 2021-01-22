<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All customers</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h1 style="color:blue;text-align:center">All Customer of nexus</h1>

<h1 style="color:blue;text-align:center">${msg}</h1>

<c:choose>
<c:when test="${custList ne null }">
<table style="color:maroon;" align="center" class="table table-responsive">
<thead>
	<tr>
	<th> ID</th>
	<th> Name</th>
	<th>Address</th>
	<th>Contact No</th>
	<th>Opertion</th>
	</tr>
	</thead>
<c:forEach items="${custList}" begin="1" var="dto">
	<tr><td>${dto.cid }</td>
	<td>${dto.name}</td>
	<td>${dto.address}</td>
	<td>${dto.contactNo}</td>
	<td><a href="editcust?cid=${dto.cid}"><i class='fas fa-edit' style='font-size:24px'>Edit</i></a>|<a href="deletecust?cid=${dto.cid}" onclick="return confirm('Are you sure to delete${dto.name}')"><i class='fas fa-trash' style='font-size:24px'>Delete</i></a></td></tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
	<h3>customers not found</h3>
</c:otherwise>
</c:choose>
<a href="home">Home</a>
</body>
</html>