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
<div class="login">

	<jsp:include page="nav.jsp" />
	<br>
<br>
<br>
<br>
<br>
<br>
          <div class="centerLogin text-center">
			<div >
			<br>
			<br>
			<h3>Log In</h3>
			<p>Get in loser, we're going shopping!</p>
			<br>
			<br>
				<form:form action="login.do" method="POST" modelAttribute="user">
					<form:label path="username">Username:</form:label>
					<form:input path="username" />
					<form:errors path="username" />
					<br />
					<br />
					<form:label path="password">Password:</form:label>
					<form:input type="password" path="password" />
					<form:errors path="password" />
					<br>
					<br>
					<br>
					<button type="submit" class="btn btn-primary">  Let's Go!  </button>
				</form:form>
				<br>
				<br>
				<br>
				<br>
			</div>
			<!-- <div class="col-6">
				<img src="resources/images/conference-call.jpg" style="max-width: 100%;" />
			 -->

		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
	<jsp:include page="foot.jsp" />
	</div>
</body>
</html>
