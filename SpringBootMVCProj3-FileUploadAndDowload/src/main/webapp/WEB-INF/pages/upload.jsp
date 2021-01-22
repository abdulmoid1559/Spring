<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:olive;tex-align:center">Register Employee</h1>
	<form:form modelAttribute="empolyee"  enctype="multipart/form-data"  method="post">
<table align="center"  style="text-align:center;color:fuchsia;" ><tr><td>
<tr><td>
<label>Resume::</label></td>
<td>
<input type="file" name="cv"></td></tr>

<tr><td><input type="submit" value="upload"></td></tr>
</table>
</form:form>
<span>
<h3 style="color:blue;text-align:center">${msg}</h3>
</span>

<h3><a href="downloadlist">resume</a></h3>
</body>
</html>