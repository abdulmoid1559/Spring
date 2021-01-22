<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Customer </title>
<style type="text/css">
.error{
color:red;
font-style: italic;
font-family: monospace;
}
</style>
</head>
<body>
	<h1 style="text-align:center;color:navy;"> Customer Registration </h1>
	<div style="text-align:center" class="">
<form:form modelAttribute="customer" >
	<table style="color:blue:text-align:center" align="center"><tr>
	<td>Name:</td>
	<td><form:input path="name"/></td><td><form:errors cssClass="error" path="name"></form:errors></td>
	</tr>
	<tr>
	<td>Address:</td>
	<td><form:input path="address"/></td>
	<td><form:errors cssClass="error" path="address"></form:errors></td>
	</tr>
	<tr>
	<td>Contact No:</td>
	<td><form:input path="contactNo"/><td>
	<td><form:errors cssClass="error" path="contactNo"></form:errors></td>
	</tr>
	<tr><td><input type="submit" value="Submit"></td>
	<td><input type="reset" value="Reset"></td></tr>
</table>
</form:form>
</div>
</body>
</html>