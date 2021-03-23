<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp" />
<title>Register Student</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<h3>Register New Student:</h3>
		<form action="submitNewStudent.do" method="POST">
			<input type="text" hidden="true" name="userIdString"
				value="${user.id}"> <label for="firstName">First
				Name:</label> <input type="text" name="firstName"> <label
				for="lastName">Last Name:</label> <input type="text" name="lastName">
			<select id="gradeLevel" name="gradeLevel">
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select> <label for="gender">Gender:</label> <input type="text" name="gender">
			<label for="birthday">Birthday: </label> <input type="date"
				name="birthday"> <label for="imageUrl">Image Url:</label> <input
				type="text" name="imageUrl"> <input type="submit"
				value="Submit">
		</form>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>