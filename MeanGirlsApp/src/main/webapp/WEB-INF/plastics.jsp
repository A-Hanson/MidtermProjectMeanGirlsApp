<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Plastics</title>
<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<c:choose>
			<%-- USER LOGGED IN --%>
			<c:when test="${user.role=='user' }">
				<c:choose>
					<c:when test="${student.totalFetch < clique.minimumFetchLevel }">
						<div class="container justify-content-center">
							<div class="row justify-content-center">
								<h4>
									Fetch level isn't high enough to visit this clique <br /> <small
										class="text-muted">It's the rules.</small>
								</h4>
							</div>
							<div class="row justify-content-center">
								<iframe src="https://giphy.com/embed/xT9KVuimKtly3zoJ0Y"
									width="480" height="270" frameBorder="0" class="giphy-embed"
									allowFullScreen></iframe>
								<p>
									<a
										href="https://giphy.com/gifs/filmeditor-mean-girls-movie-xT9KVuimKtly3zoJ0Y"></a>
								</p>
							</div>
							<script type="text/javascript" async
								src="https://tenor.com/embed.js"></script>
						</div>
					</c:when>
					<c:when test="${student.totalFetch >= clique.minimumFetchLevel }">
						<c:if test="${!partOfClique }">
							<div class="container">
				
								<div class="row justify-content-center">
									<iframe src="https://giphy.com/embed/3otPopJuagoFrYMWgo"
										width="480" height="270" frameBorder="0" class="giphy-embed"
										allowFullScreen></iframe>
									<p>
										<a
											href="https://giphy.com/gifs/filmeditor-mean-girls-movie-3otPopJuagoFrYMWgo"></a>
									</p>
								</div>
								<div class="row justify-content-center">
									<form action="addStudentToClique.do" method="POST">
										<h4>&nbsp;</h4>
										<button class="btn btn-primary" type="submit">Join
											the Plastics!</button>
										<input type="hidden" name="cliqueId" value="${clique.id}" />
									</form>
								</div>
							</div>
						</c:if>
						<div class="table">
							<c:forEach var="comment" items="${plasticsComments}">
								<div class="row">
									<div class="col">
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
											<input type="hidden" name="cliqueId" value="${clique.id}" />
											<input type="hidden" name="vote" value="true" />
										</form>
										<form action="vote.do" method="POST">
											<button class="btn btn-primary m-1">Not EVEN...</button>
											<input type="hidden" name="commentId" value="${comment.id}" />
											<input type="hidden" name="studentId" value="${student.id}" />
											<input type="hidden" name="cliqueId" value="${clique.id}" />
											<input type="hidden" name="vote" value="false" />
										</form>

										<form action="reportComment.do" method="POST">
											<input type="text" hidden="true" name="commentId"
												value="${comment.id}"> <input type="submit"
												value="report">
										</form>

									</div>

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
						</div>
						<c:if test="${partOfClique }">
							<form action="addPlasticsComment.do" method="POST">
								<div class="form-group m-1">
									<input type="hidden" name="studentId" value="${student.id}" />
									<input type="hidden" name="cliqueId" value="${clique.id}" />
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
						</c:if>
					</c:when>

				</c:choose>
			</c:when>
			<%--------------------%>


			<%-- ADMIN LOGGED IN: --%>
			<c:when test="${user.role=='admin' }">

				<div class="table">
					<c:forEach var="comment" items="${plasticsComments}">
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

			</c:when>
			<%----------------------%>


			<%-- NO ONE LOGGED IN: --%>
			<c:otherwise>

				<h3 style="color: #b71c1c;">DEBUG: This displays when NO ONE is
					logged in</h3>
				<iframe src="https://giphy.com/embed/sw7KSBKL3yme4" width="480"
					height="470" frameBorder="0" class="giphy-embed" allowFullScreen></iframe>
				<p>
					<a
						href="https://giphy.com/gifs/mean-girls-mormon-lds-sw7KSBKL3yme4"></a>
				</p>

			</c:otherwise>
			<%-----------------------%>

		</c:choose>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>