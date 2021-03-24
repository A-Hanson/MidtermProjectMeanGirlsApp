<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Comment</title>
<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="nav.jsp" />
	<c:choose>
		<%-- USER LOGGED IN --%>
		<c:when test="${user.role=='user' }">

			<form action="updateComment.do" method="POST">
				<div class="container">

					<!-- DEBUG:      <h5 style="color: #b71c1c;">DEBUG: This displays when USER is
					logged in</h5> -->


					<div class="row">
						<div class="col-6">
							<input type="hidden" name="id" value="${comment.id}" required />
							<input type="hidden" name="cliqueId" value="${comment.clique.id}" />

							<h4>
								<label for="update comment">Edit your comment:</label>
							</h4>
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<textarea rows="8" cols="20" class="form-control" name="content"
								placeholder="content" required>${comment.content }</textarea>
						</div>
					</div>

					<div class="row pt-3">
						<div class="col-6">
							<button class="btn-primary" type="submit">Update</button>
						</div>
					</div>
				</div>
			</form>
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
	<jsp:include page="foot.jsp" />
</body>
</html>
