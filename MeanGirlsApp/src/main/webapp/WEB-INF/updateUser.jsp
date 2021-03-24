<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>update user</title>
<meta charset="utf-8">
</head>
<body>


	<h2>Edit user</h2>
	<br>
	<div>
		<c:choose>
			<c:when test="${user == null}">
				<h3>No User Was Found With Id Number: ${idNum}.</h3>
			</c:when>
			<c:otherwise>
				<h2>Enter User Information Here!</h2>
				<br>
				<form action="updateUser.do" method="POST">
			<table>
				<tr>
					<td><input type="hidden" name="id" value="${user.id}"/></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" value="${user.email}"/></td>
				</tr>
				<tr>
					<td>Username:</td>
					<td><input type="text" name="username" value="${user.username}" /></td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstName"  value="${user.firstName}"/></td>

					<td>Last Name:</td>
					<td><input type="text" name="lastName" value="${user.lastName}"/></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><input type="text" name="gender" value="${user.gender}"/></td>
				</tr>
				<tr>
					<td><input type="hidden" name="role" value="${user.role}"/></td>
				</tr>
			</table>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>