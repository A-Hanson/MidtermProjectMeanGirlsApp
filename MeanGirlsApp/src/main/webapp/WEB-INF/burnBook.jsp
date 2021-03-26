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
						<div class="card-deck m-1">
							<!-- CARD -->
							<div class="card" style="width: 18rem;">

								<!-- PROFILE PIC -->
								<img src="${studentBurnPage.imageUrl}" class="card-img-top"
									alt="student's profile pic">

								<!-- CARD BODY -->
								<div class="card-body">
									<div class="row">
										<h5 class="card-title">${studentBurnPage.firstName}</h5>
									</div>
									<c:forEach var="comment"
										items="${studentBurnPage.burnBookCommentsAboutMe}">
										<c:if test="${comment.enabled}">
											<div class="row">${comment.content}</div>
											<form action="reportBurnComment.do" method="POST">
												<div class="row">
													<input type="text" hidden="true" name="commentId"
														value="${comment.id}">
													<button class="btn btn-secondary btn-sm" type="submit">Report</button>
												</div>
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
								<!-- close card footer -->

							</div>
							<!-- close card -->
						</div>
						<!-- close card deck -->
					</c:forEach>
				</div>
			</c:when>
			<%--------------------%>


			<%-- ADMIN LOGGED IN: --%>
			<c:when test="${user.role=='admin' }">

				<!-- <h3 style="color: #b71c1c;">DEBUG: This displays when ADMIN is
					logged in</h3> -->

			</c:when>
			<%----------------------%>


			<%-- NO ONE LOGGED IN: --%>
			<c:otherwise>

				<h3 style="color: #ee4498; text-align: center;" >Only admins are allow to see this page</h3>
				   <center><img src="resources/images/gohere.png" alt="" height="700" width="900"> </center>

			</c:otherwise>
			<%-----------------------%>

		</c:choose>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
