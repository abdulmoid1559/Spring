<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:red;text-align:center">Nexus Software Solution </h1>
<h3 style="text-align:center"><a href="allcustomer">get all customer</a></h3>
<a href="register" style="text-align:center">Register Customer</a>
<c:if test="${msg ne null }">
<marquee ><h3 style="color:fuchsia;">${msg}</h3></marquee>
</c:if>
</body>
</html>