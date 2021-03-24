<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users</title>
</head>
<body>


	<h1 >MANAGE USERS</h1>

	<div>
		<div>
			Look up user by Id #
			<form action="getUser.do" method="GET">
				<input type="number" name="id" value="" id="id" required /> <br>
				<input type="submit" value="Search" />
			</form>
		</div>
		<br> <br> <br>
		<div>
			Look up user by username
			<form action="getUser.do" method="GET">
				<input type="text" name="username" value="" /> <br> <input
					type="submit" value="Search" />
			</form>
		</div>
		<br> <br> <br>
		<div>
			List All Users
			<form action="getUser.do" method="GET">
				<input type="submit" value="Search" />
			</form>
		</div>
		<br> <br> <br>
		<div>
			<span>Update an User</span>
			<form action="updateUser.do" method="GET">
				<label for="number">User ID #: </label> <input type="number" min="1"
					max="2000" name="id" value="" size="4" id="number" required /> <br>
				<input type="submit" value="Update" />
			</form>
		</div>
		<br> <br> <br>
	</div>


</body>
</html>