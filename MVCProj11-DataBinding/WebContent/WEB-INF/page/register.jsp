<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<frm:form modelAttribute="emp">
	<table border='1' align='center'>
	<tr><td>Employee ID</td>
		<td><frm:input path="eid"/></td>
	</tr>
	<tr><td>Employee Name</td>
		<td><frm:input path="ename" /></td>
	</tr>
	<tr><td>Employee address</td>
		<td><frm:input path="address" /></td>
	</tr>
	<tr><td>Dept </td>
		<td><frm:input path="dept" /></td>
	</tr>
	<tr><td>Salary</td>
		<td><frm:input path="salary" /></td>
	</tr>
	<tr><td>Job</td>
		<td><frm:input path="job" /></td>
	</tr>
	<tr><td><input type="submit" value="Register"></td></tr>
	</table>
	</frm:form>
	<h1><a href="link?name=Moid&add=Amt">getData</a></h1>
</body>
</html>