<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 style="color:pink;text-align:center">Information of Students</h1>
	<c:forEach var="nam"  items="${name}">
	<h2 style="color:green;text-align:center">${nam }</h2>
	</c:forEach>
	<c:forEach var="phone"  items="${phoneNo}">
	<h2 style="color:green;text-align:center">${phone }</h2>
	</c:forEach>
	<c:forEach var="crs"  items="${course}">
	<h2 style="color:green;text-align:center">${crs }</h2>
	</c:forEach>
</body>
</html>