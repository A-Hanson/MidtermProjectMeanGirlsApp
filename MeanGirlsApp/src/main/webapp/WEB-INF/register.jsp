<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp" />
<title>Register, Girl!!</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<h3>Please enter your information:</h3>

		<form action="register.do" method="POST">
			<table>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>Username:</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<%--TODO: mask password field when user types password--%>
					<td>Password:</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastName" /></td>
				</tr>
				<tr>
					<td>Birthday:</td>
					<td>Month:<input type="number" name="birthdayMonth" /></td>
					<td>Day:<input type="number" name="birthdayDay" /></td>
					<td>Year:<input type="number" name="birthdayYear" /></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><input type="text" name="gender" /></td>
				</tr>
			</table>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>