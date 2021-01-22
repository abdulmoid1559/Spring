<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:maroon;text-align:center"></h1>
<c:choose>
	<c:when test="${list ne null}">
		<c:forEach items="${list}" var="filename">
			<h2 style="text-align:center"><a href="download?name=${filename}">${filename} &nbps; Download</h2>
		</c:forEach>
	</c:when>

</c:choose>
</body>
</html>