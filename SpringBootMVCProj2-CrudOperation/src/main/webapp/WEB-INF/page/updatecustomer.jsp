<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Customer</title>
<style type="text/css">
.error{
color:red;
}
</style>
</head>
<body>
<form:form modelAttribute="customer" >
	<table style="color:blue:text-align:center">
	<tr>
	<td>Customer Id:</td>
	<td><form:input path="cid" readonly="true"/><td></tr>
	<tr>
	<td>Name:</td>
	<td><form:input path="name" value="${cust.name}"/> <form:errors cssClass="error" path="name"/></td></tr>
	<tr>
	<td>Address:</td>
	<td><form:input path="address"/><form:errors cssClass="error" path="address"/><td></tr>
	<tr>
	<td>Contact No:</td>
	<td><form:input path="contactNo"/><form:errors cssClass="error" path="contactNo"/><td></tr>
	<tr><td><input type="submit" value="Submit"></td>
	<td><input type="reset" value="Reset">
</table></form:form>

</body>
</html>