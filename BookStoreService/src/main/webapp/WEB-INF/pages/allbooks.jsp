<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<c:choose>
<c:when test="${list ne null }">
<table style="color:maroon;" align="center" class="table table-responsive">
<thead>
	<tr>
	<th> </th>
	<th> Name</th>
	<th>Author</th>
	<th>Price</th>
	<th>Status</th>
	</tr>
	</thead>
<c:forEach items="${listDTO}" begin="1" var="dto">
	<tr><td><img src="/static/image/${dto.imageName}"></td>
	<td>${dto.bookName}</td>
	<td>${dto.authorName}</td>
	<td>${dto.price}</td>
	<td>${dto.avbStatus}</td>
	<td><a href="editcust?bid=${dto.bid}"><i class="fas fa-shopping-cart">add to cart</i></a></td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
	<h3>books not found</h3>
</c:otherwise>
</c:choose>
<a href="home">Home</a>


</body>
</html>