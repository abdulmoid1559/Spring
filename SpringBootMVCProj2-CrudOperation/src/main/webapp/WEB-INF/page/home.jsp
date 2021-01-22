<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome To Nexus </title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body style="text-align:center">
<h1 style="color:Blue;text-align:center">Nexus Software Solution</h1>

<form:form align="center" action="login" modelAttribute="user"  style="text-align:center" class="form-horizontal form-center">
	<table align="center">
	<tr><td><label>Username</label></td>
	<td><form:input path="username" /></td></tr>
	<tr><td><label>Password</label></td>
	<td><form:password path="password"/>
	</td></tr>
	<tr><td colspan="2"><input type="submit" value="login">
	</table>
</form:form>

<h3>New User?<a href="uregister">Register</a></h3>
<c:if  test="${ msg ne null}">
<h1 style="color:blue;text-align:center">${msg}</h1>
</c:if>

	<h1>${msg}</h1>
</body>
</html>