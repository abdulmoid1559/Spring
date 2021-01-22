<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User </title>
</head>
<body>
<h1 style="color:maroon;text-align:center">Register User</h1>
<form:form modelAttribute="user" >
	<table style="color:blue:text-align:center"><tr>
	<td>Name:</td>
	<td><form:input path="name"/><td></tr>
	<tr>
	<td>Address:</td>
	<td><form:input path="address"/><td></tr>
	<tr>
	<td>Contact No:</td>
	<td><form:input path="contactNo"/><td></tr>
	<td>Username:</td>
	<td><form:input path="username"/><td></tr>
	<td>Password:</td>
	<td><form:password path="password"/><td></tr>
	<tr><td><input type="submit" value="Submit"></td>
	<td><input type="reset" value="Reset">
</table>
</form:form>
</body>
</html>