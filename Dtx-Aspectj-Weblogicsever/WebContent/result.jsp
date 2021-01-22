<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:blue;text-align:center">Result Page</h1>
<b style="color:green;text-align:center"><%
out.println(request.getAttribute("result"));
%></b>
</body>
</html>