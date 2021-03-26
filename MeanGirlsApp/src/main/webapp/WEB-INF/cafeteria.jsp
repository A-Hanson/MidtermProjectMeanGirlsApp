<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cafeteria</title>
<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<c:choose>
			<%-- USER LOGGED IN --%>
			<c:when test="${user.role=='user' }">

				<%-- 				<c:if test="${not null myObject.myAttribute}">
   <!-- Now I can access safely to "myAttribute" -->
</C:if>
		 --%>

				<hr />
				<div class="table">
					<c:forEach var="comment" items="${cafeteriaComments}">
						<div class="row">
							<div class="col">
								<!--<fmt:parseDate value="${comment.createdDate }"
								var="parsedCreatedDate" pattern="dd/MM/yy hh:mm" /> -->
								Time Created: ${comment.createdDate} <br /> Posted By:
								${comment.student.firstName }&nbsp;${comment.student.lastName }
								<br /> Comment Fetch Level: ${comment.totalFetch }
							</div>
							<div class="col-6">${comment.content}</div>
							<div class="col d-flex justify-content-center">
								<form action="vote.do" method="POST">
									<button class="btn btn-primary m-1">So FETCH!!!</button>
									<input type="hidden" name="commentId" value="${comment.id}" />
									<input type="hidden" name="studentId" value="${student.id}" />
									<input type="hidden" name="cliqueId" value="${clique.id}" /> <input
										type="hidden" name="vote" value="true" />
								</form>
								<form action="vote.do" method="POST">
									<button class="btn btn-primary m-1">Not EVEN...</button>
									<input type="hidden" name="commentId" value="${comment.id}" />
									<input type="hidden" name="studentId" value="${student.id}" />
									<input type="hidden" name="cliqueId" value="${clique.id}" /> <input
										type="hidden" name="vote" value="false" />
								</form>

							</div>

							<form action="reportComment.do" method="POST">
								<input type="text" hidden="true" name="commentId"
									value="${comment.id}">
								<button class="btn btn-secondary m-1">report</button>
							</form>

							<c:if test="${comment.student.id == student.id}">
								<div class="col d-flex justify-content-center">
									<form action="updateComment.do" method="GET">
										<button class="btn btn-secondary m-1">Edit</button>
										<input type="hidden" name="commentId" value="${comment.id}" />
									</form>
									<form action="deleteComment.do" method="POST">
										<button class="btn btn-secondary m-1">Delete</button>
										<input type="hidden" name="commentId" value="${comment.id}" />
										<input type="hidden" name="cliqueId" value="${clique.id}" />
									</form>
								</div>
							</c:if>
						</div>
						<hr />
					</c:forEach>
					<form action="addCafeteriaComment.do" method="POST">
						<div class="form-group m-1">
							<input type="hidden" name="studentId" value="${student.id}" />
							<h4>Post a Comment:</h4>
							<div class="row mt-2 mb-2">
								<div class="col-6">
									<textarea rows="8" cols="20" class="form-control"
										name="content" placeholder="content" required>${comment.content }</textarea>
								</div>
							</div>
							<button class="btn btn-primary" type="submit">Submit
								Comment</button>
						</div>
					</form>


					<form action="plasticsform.do" method="GET">

						<h4>&nbsp;</h4>
						<button class="btn btn-primary" type="submit">Visit the
							Plastics</button>
					</form>
				</div>

			</c:when>
			<%--------------------%>


			<%-- ADMIN LOGGED IN: --%>
			<c:when test="${user.role=='admin' }">


				<div class="table">
					<c:forEach var="comment" items="${cafeteriaComments}">
						<div class="row">
							<div class="col-7">${comment.content}</div>
							<div class="col-1">
								<form action="deleteComment.do" method="POST">
									<button style="">Delete</button>
									<input type="hidden" name="commentId" value="${comment.id}" />
									<input type="hidden" name="cliqueId" value="${clique.id}" />
								</form>
							</div>
						</div>
						<br />
					</c:forEach>
				</div>
				<form action="plasticsform.do" method="GET">

					<h4>&nbsp;</h4>
					<button class="btn btn-primary" type="submit">Visit the
						Plastics</button>
				</form>

			</c:when>
			<%----------------------%>


			<%-- NO ONE LOGGED IN: --%>
			<c:otherwise>

				<h3 style="color: #ee4498; text-align: center;" >Log into your account to see this page.</h3>
				   <center><img src="resources/images/gohere.png" alt="" height="700" width="900"> </center>

			</c:otherwise>
			<%-----------------------%>

		</c:choose>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
