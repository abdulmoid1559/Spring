<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color:green;text-align:center">All Contries Available in Locale</h1>
	
		<table border=1 style="background:cyan;text-align:center">
		<c:forEach var="l" items="${list }">
			<tr><td>${l}</td></tr>
		</c:forEach>
		</table>
	
<!-- 		<h3>No countries found</h3> -->
	<a href="logout">Logout</a>
</body>
</html>