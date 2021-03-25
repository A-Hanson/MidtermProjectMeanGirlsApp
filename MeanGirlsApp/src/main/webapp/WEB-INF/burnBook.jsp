<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Burn Book</title>
<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<c:choose>
			<%-- USER LOGGED IN --%>


			<c:when test="${user.role=='user' }">
				<!--
			TEST -- ${addBurnCommentStudentID}
			TEST -- ${student}

				  <h3 style="color: #b71c1c;">DEBUG: This displays when USER is
					logged in</h3>   -->
				<h2>Burn Book</h2>
				<hr />
				<div class="row">
					<c:forEach var="studentBurnPage" items="${students}">



						<div class="card-deck">
							<!-- CARD -->
							<div class="card m-3" style="width: 18rem;">

								<!-- PROFILE PIC -->
								<img src="${studentBurnPage.imageUrl}" class="card-img-top"
									alt="student's profile pic">

								<!-- CARD BODY -->
								<div class="card-body">
									<h5 class="card-title">${studentBurnPage.firstName}</h5>
									<c:forEach var="comment"
										items="${studentBurnPage.burnBookCommentsAboutMe}">
										<c:if test="${comment.enabled}">
											<div class="row">${comment.content}</div>
											<form action="reportBurnComment.do" method="POST">
												<input type="text" hidden="true" name="commentId"
													value="${comment.id}"> <input type="submit"
													value="report">
											</form>
										</c:if>
									</c:forEach>
									<!-- debug: ${studentBurnPage.id}  -->
								</div>
								
								<!-- CARD FOOTER -->
								<div class="card-footer">
									<form action="addBurnComment.do" method="GET">
										<input type="text" hidden="true" name="userIdString"
											value="${studentBurnPage.id}">
										<button type="submit" class="btn btn-primary">Add
											Burn Entry</button>

									</form>
								</div> <!-- close card footer -->


								<c:if test="${addBurnCommentStudentID == studentBurnPage.id}">
									<div>
										<form action="SubmitBurnComment.do" method="POST">
											<input type="text" hidden="true"
												name="postingStudentIdString" value="${student.id}">
											<input type="text" hidden="true"
												name="subjectStudentIdString" value="${studentBurnPage.id}">
											<input type="text" name="content" value="test"> <input
												type="submit" value="Post">
										</form>
									</div>
								</c:if>



							</div>
						</div>
				</div>
				</c:forEach>
	</div>
	</c:when>
	<%--------------------%>


	<%-- ADMIN LOGGED IN: --%>
	<c:when test="${user.role=='admin' }">

		<h3 style="color: #b71c1c;">DEBUG: This displays when ADMIN is
			logged in</h3>

	</c:when>
	<%----------------------%>


	<%-- NO ONE LOGGED IN: --%>
	<c:otherwise>

		<h3 style="color: #b71c1c;">DEBUG: This displays when NO ONE is
			logged in</h3>

	</c:otherwise>
	<%-----------------------%>

	</c:choose>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
