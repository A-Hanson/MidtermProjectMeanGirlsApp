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
<div class="admin">
	<jsp:include page="nav.jsp" />
<br>
<br>
<br>
	<div class="center text-center">
		<c:out value="${loggedInUser }" />

		<c:choose>
			<c:when test="${user.role=='admin' }"><br>
			<br>
				<h1 style="color: darkmagenta">MANAGE COMMENTS</h1>

				<div>
					<div>
						Look up comments by clique Id #
						<form action="getCliqueComments.do" method="GET">
							<input type="number" name="id" value="" id="id" required /> <br>
							<input type="submit" value="Search" class="btn btn-primary" />
						</form>
					</div>
					<br> <br> <br>
					<div>
						Look up comments by username
						<form action="getCommentByUser.do" method="GET">
							<input type="text" name="username" value="" /> <br> <input
								type="submit" value="Search" class="btn btn-primary"/>
						</form>
					</div>
					<br> <br> <br>
					<div>
						List All Comments
						<form action="getComment.do" method="GET">
							<input type="submit" value="Search" class="btn btn-primary"/>
						</form>
					</div>
					<br> <br> <br>
					<div>
						List Burn Book Comments
						<form action="getBurnComments.do" method="GET">
							<input type="submit" value="Search" class="btn btn-primary"/>
						</form>
					</div>
					<br> <br> <br>
					<div>
						List Flagged Comments
						<form action="getFlaggedComments.do" method="GET">
							<input type="submit" value="Search" class="btn btn-primary" />
						</form>
					</div>
					<br> <br> <br>
				</div>
			</c:when>

			<c:otherwise>
				<h3 style="color: #ee4498; text-align: center;" >Only admins are allow to see this page</h3>
				   <center><img src="resources/images/gohere.png" alt="" height="700" width="900"> </center>
			</c:otherwise>
		</c:choose>
	</div>
		<br>
<br>
<br>
	<jsp:include page="foot.jsp" />

</div>
</body>
</html>