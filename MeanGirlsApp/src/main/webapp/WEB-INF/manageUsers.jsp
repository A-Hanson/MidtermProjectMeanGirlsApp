<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp" />
<title>Users</title>
</head>
<body>
	<jsp:include page="nav.jsp" />

	<div class="container">
		<c:out value="${loggedInUser }" />

		<c:choose>
			<c:when test="${user.role=='admin' }">
				<h1>MANAGE USERS</h1>

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
							<label for="number">User ID #: </label> <input type="number"
								min="1" max="2000" name="id" value="" size="4" id="number"
								required /> <br> <input type="submit" value="Update" />
						</form>
					</div>
					
					<div>
						<span>Delete an User PERMANENTLY</span>
						<form action="deletePermanently.do" method="GET">
							<label for="number">User ID #: </label> <input type="number"
								min="1" max="2000" name="id" value="" size="4" id="number"
								required /> <br> <input type="submit" value="Update" />
						</form>
					</div>
					
					<br> <br> <br>
				</div>
			</c:when>

			<c:otherwise>
				<h2>Only admins are allow to see this page</h2>
			</c:otherwise>
		</c:choose>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>