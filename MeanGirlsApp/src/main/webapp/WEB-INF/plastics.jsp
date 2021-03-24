<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<title>Plastics</title>
</head>
<body>
<jsp:include page="nav.jsp" />
	<div class="container">
		<c:choose>
			<%-- USER LOGGED IN --%>
			<c:when test="${user.role=='user' }">

				<h3 style="color:#b71c1c;">DEBUG: This displays when USER
					is logged in</h3>
				<c:if test="${studentFetch < clique.minimumFetchLevel }">
				<div class="tenor-gif-embed" data-postid="12328861" data-share-method="host" data-width="100%" data-aspect-ratio="1.7777777777777777"><a href="https://tenor.com/view/back-to-school-you-cant-sit-with-us-first-day-of-school-high-school-gif-12328861">Back To School You Cant Sit With Us GIF</a> from <a href="https://tenor.com/search/backtoschool-gifs">Backtoschool GIFs</a></div><script type="text/javascript" async src="https://tenor.com/embed.js"></script>
				</c:if>	

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
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</body>
</html>