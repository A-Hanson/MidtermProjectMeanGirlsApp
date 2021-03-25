<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-6">
				<form:form action="login.do" method="POST" modelAttribute="user">
					<form:label path="username">Username:</form:label>
					<form:input path="username" />
					<form:errors path="username" />
					<br />
					<form:label path="password">Password:</form:label>
					<form:input type="password" path="password" />
					<form:errors path="password" />
					<button type="submit" class="btn btn-primary">Log In</button>
				</form:form>
			</div>
			<div class="col-6">
				<img src="resources/images/conference-call.jpg" style="max-width: 100%;" />
			</div>
		</div>

	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
