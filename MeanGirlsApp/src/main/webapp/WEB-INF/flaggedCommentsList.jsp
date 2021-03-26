<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flagged Comments</title>
<jsp:include page="head.jsp" />

</head>
<body>

	<jsp:include page="nav.jsp" />

	<div>
		<c:out value="${loggedInUser }" />

		<c:choose>
			<c:when test="${user.role=='admin' }">

				<c:choose>

					<c:when test="${empty comments}">
						<h3>No comments were found.</h3>
					</c:when>

					<c:otherwise>


						<h3 style="color: darkmagenta">Flagged Comments</h3>
						<table>
							<thead>
								<tr>
									<th>ID</th>
									<th>Content</th>
								</tr>

							</thead>

							<tbody>

							<c:forEach var="com" items="${comments}">

								<tr>
									<td>${com.id}</td>
									<td>${com.content}</td>
									<td><form action="deleteFlaggedComments.do" method="POST">
										<button style="" class="btn btn-primary">Delete</button>
										<input type="hidden" name="commentId" value="${com.id}" />
									</form></td>
								</tr>
						
							</c:forEach>
							</tbody>
						</table>
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