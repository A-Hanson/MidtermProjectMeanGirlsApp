<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
</head>
<body>


<h2>Log In</h2>
<form:form action="login.do" modelAttribute="user">
	<%-- Error messages --%>
	<form:input path="userName"/>
	<form:password path="password"/>
	<input type="submit" value="Log In" > 
</form:form>



</body>
</html>