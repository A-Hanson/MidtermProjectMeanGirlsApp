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
		<form action="register.do" method="POST">
			<div class="row">
				<div class="col-6">
					<h3>Please enter your information:</h3>

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
						</tr>
						<tr>
							<td>Month:</td>
							<td><input type="number" name="birthdayMonth" /></td>
						</tr>
						<tr>
							<td>Day:</td>
							<td><input type="number" name="birthdayDay" /></td>
						</tr>
						<tr>
							<td>Year:</td>
							<td><input type="number" name="birthdayYear" /></td>
						</tr>
						<tr>
							<td>Gender:</td>
							<td><input type="text" name="gender" /></td>
						</tr>
						<tr>
							<td><button type="submit" class="btn btn-primary">Submit</button></td>
						</tr>
					</table>
				</div>
				<div class="col-6">
					<img src="resources/images/incredulous.jpg"
						style="max-width: 100%;" />
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>