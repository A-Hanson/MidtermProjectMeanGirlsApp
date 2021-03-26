<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>${userLookUp.firstName}</title>
<jsp:include page="head.jsp" />
</head>
<body>

	<jsp:include page="nav.jsp" />

	<div class="container">
		<c:out value="${loggedInUser }" />

		<c:choose>
			<c:when test="${user.role=='admin' }">

				<c:choose>

					<c:when test="${empty userLookUp}">
						<h3 >No user Was Found.</h3>
					</c:when>

					<c:otherwise>

						<h1 style="color: darkmagenta">${userLookUp.firstName}${userLookUp.lastName}</h1>
						<p>${userLookUp.username}</p>

						<div>
							<form action="updateUser.do" method="GET">
								<input type="hidden" name="id" value="${userLookUp.id}" /> <input
									type="submit" value="Update" class="btn btn-primary"/>
							</form>
							<form action="deleteUser.do" method="POST">
								<input type="hidden" name="id" value="${userLookUp.id}" /> <input
									type="submit" value="Delete"
									onclick="return confirm('Are you sure? This CANNOT be undone.'); " class="btn btn-primary"/>
							</form>
						</div>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<h3 style="color: #ee4498; text-align: center;" >Only admins are allow to see this page</h3>
				   <center><img src="resources/images/gohere.png" alt="" height="700" width="900"> </center>
			</c:otherwise>

		</c:choose>
	</div>


	<jsp:include page="foot.jsp" />
</body>
</html>