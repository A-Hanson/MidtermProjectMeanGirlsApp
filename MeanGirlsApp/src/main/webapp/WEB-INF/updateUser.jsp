<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>update user</title>
<meta charset="utf-8">
<jsp:include page="head.jsp" />

</head>
<body>

	<jsp:include page="nav.jsp" />

	<div class="container">
		<c:out value="${loggedInUser }" />
		<h2>Edit user</h2>
		<br>
		<div>
			<c:choose>
				<c:when test="${user.role=='admin' }">

					<h3 style="color: #b71c1c;">DEBUG: This displays when ADMIN is
						logged in</h3>
					<c:choose>
						<c:when test="${userLookUp == null}">
							<h3>No User Was Found With Id Number: ${idNum}.</h3>
						</c:when>
						<c:otherwise>
							<h2>Enter User Information Here!</h2>
							<br>
							<form action="updateUser.do" method="POST">
								<table>
									<tr>
										<td><input type="hidden" name="id"
											value="${userLookUp.id}" /></td>
									</tr>
									<tr>
										<td>Email:</td>
										<td><input type="text" name="email"
											value="${userLookUp.email}" /></td>
									</tr>
									<tr>
										<td>Username:</td>
										<td><input type="text" name="username"
											value="${userLookUp.username}" /></td>
									</tr>
									<tr>
										<td>First Name:</td>
										<td><input type="text" name="firstName"
											value="${userLookUp.firstName}" /></td>

										<td>Last Name:</td>
										<td><input type="text" name="lastName"
											value="${userLookUp.lastName}" /></td>
									</tr>
									<tr>
										<td>Gender:</td>
										<td><input type="text" name="gender"
											value="${userLookUp.gender}" /></td>
									</tr>
									<tr>
										<td><input type="hidden" name="role"
											value="${userLookUp.role}" /></td>
									</tr>
								</table>
								<button type="submit" class="btn btn-primary">Submit</button>
							</form>
						</c:otherwise>
					</c:choose>
				</c:when>

				<c:otherwise>
                 <h2>Only admins are allow to see this page</h2>
				</c:otherwise>

			</c:choose>
		</div>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>