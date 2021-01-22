<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 class="">Login page </h1>
	<sp:form modelAttribute="user">
	<table>
	<tr><td>Username::</td>
	<td><sp:input path="username"/>
	</td></tr>
	<table>
	<tr><td>Password::</td>
	<td><sp:password path="password"/>
	</td></tr>
	<table>
	<tr>
	<td><input type="submit" value="Login">
	</td></tr>
	</table>
	</sp:form>
	

		<h1>Login Status is:${status}</h1>

</body>
</html>