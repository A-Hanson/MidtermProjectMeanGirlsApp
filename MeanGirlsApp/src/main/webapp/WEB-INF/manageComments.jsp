<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Comments</title>
<jsp:include page="head.jsp" />
</head>
<body>

	<jsp:include page="nav.jsp" />

	<div class="container">
		<c:out value="${loggedInUser }" />

		<c:choose>
			<c:when test="${user.role=='admin' }">
				<h1>MANAGE COMMENTS</h1>

				<div>
					<div>
						Look up comments by clique Id #
						<form action="getComment.do" method="GET">
							<input type="number" name="id" value="" id="id" required /> <br>
							<input type="submit" value="Search" />
						</form>
					</div>
					<br> <br> <br>
					<div>
						Look up comments by username
						<form action="getUser.do" method="GET">
							<input type="text" name="username" value="" /> <br> <input
								type="submit" value="Search" />
						</form>
					</div>
					<br> <br> <br>
					<div>
						List All Comments
						<form action="getComment.do" method="GET">
							<input type="submit" value="Search" />
						</form>
					</div>
					<br> <br> <br>
					<div>
						List Burn Book Comments
						<form action="getUser.do" method="GET">
							<input type="submit" value="Search" />
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