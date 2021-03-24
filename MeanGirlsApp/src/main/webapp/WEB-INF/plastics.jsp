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

				<h3 style="color:#b71c1c;">DEBUG: This displays when USER
					is logged in</h3>
				<c:choose>
					<c:when test="${studentFetch < clique.minimumFetchLevel }">
					<div class="container tenor-gif-embed" data-postid="12328861" data-share-method="host" data-width="100%" data-aspect-ratio="1.7777777777777777"><a href="https://tenor.com/view/back-to-school-you-cant-sit-with-us-first-day-of-school-high-school-gif-12328861">Back To School You Cant Sit With Us GIF</a> from <a href="https://tenor.com/search/backtoschool-gifs">Backtoschool GIFs</a></div><script type="text/javascript" async src="https://tenor.com/embed.js"></script>
					</c:when>	
					<c:when test="${studentFetch >= clique.minimumFetchLevel }">
					<div class="table">
					<c:forEach var="comment" items="${plasticsComments}">
						<div class="row">
							<div class="col-6">${comment.content}</div>
							<div class="col-2">
								<form action="vote.do" method="POST">
									<button>That's So Fetch!!</button>
									<input type="hidden" name="commentId" value="${comment.id}" />
									<input type="hidden" name="studentId" value="${student.id}" />
									<input type="hidden" name="cliqueId" value="${clique.id}" />
									<input type="hidden" name="vote" value="true" />
								</form>
							</div>
							<div class="col-2">
								<form action="vote.do" method="POST">
									<button style="">Not EVEN...</button>
									<input type="hidden" name="commentId" value="${comment.id}" />
									<input type="hidden" name="studentId" value="${student.id}" />
									<input type="hidden" name="cliqueId" value="${clique.id}" />
									<input type="hidden" name="vote" value="false" />
								</form>
							</div>
							<c:if test="${comment.student.id == student.id}">
								<div class="col-1">
									<form action="updateComment.do" method="GET">
										<button style="">Update</button>
										<input type="hidden" name="commentId" value="${comment.id}" />
										<input type="hidden" name="cliqueId" value="${clique.id}" />
									</form>
								</div>
							</c:if>
							<c:if test="${comment.student.id == student.id}">
								<div class="col-1">
									<form action="deleteComment.do" method="POST">
										<button style="">Delete</button>
										<input type="hidden" name="commentId" value="${comment.id}" />
										<input type="hidden" name="cliqueId" value="${clique.id}" />
									</form>
								</div>
							</c:if>
						</div>
						<br />
					</c:forEach>
				</div>
				<form action="addPlasticsComment.do" method="POST">
					<input type="hidden" name="studentId" value="${student.id}" />
					<input type="hidden" name="cliqueId" value="${clique.id}" />
					Comment: <input type="text" name="content" />
					<button type="submit">Submit Comment</button>
				</form>
					
					</c:when>

				</c:choose>	
			</c:when>
			<%--------------------%>


			<%-- ADMIN LOGGED IN: --%>
			<c:when test="${user.role=='admin' }">

				<h3 style="color:#b71c1c;">DEBUG: This displays when ADMIN
					is logged in</h3>

			</c:when>
			<%----------------------%>


			<%-- NO ONE LOGGED IN: --%>
			<c:otherwise>

				<h3 style="color:#b71c1c;">DEBUG: This displays when NO
					ONE is logged in</h3>

			</c:otherwise>
			<%-----------------------%>

		</c:choose>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>