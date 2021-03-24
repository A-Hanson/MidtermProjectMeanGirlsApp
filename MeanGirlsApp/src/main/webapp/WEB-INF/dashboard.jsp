<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp" />
<title>Dashboard</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<c:out value="${loggedInUser }" />
		<c:choose>

			<c:when test="${user.role=='user' }">
				<!-- h5 style="color: #b71c1c;">DEBUG: This displays when USER is
					logged in</h5-->
				<c:if test="${empty student }">
					<div class="row">
						<div class="col">
							<h5>Please choose a character:</h5>
						</div>
					</div>
					<hr />
					<c:forEach var="student" items="${userStudents }">
						<div class="row align-items-center">
							<div class="col d-flex justify-content-center">
								<c:if test="${ not empty student.imageUrl}">
									<img style="max-width: 100px" class="img-thumbnail"
										src="${student.imageUrl}" />
								</c:if>
							</div>
							<div class="col">
								Name: ${student.firstName }&nbsp;${student.lastName } <br />
								Birthday: ${student.birthdayDate}
							</div>
							<div class="col">
								Total Fetch:
								<h5 style="color: #b71c1c;">xx</h5>
							</div>
							<div class="col d-flex justify-content-center">
								<form action="dashboard.do" method="GET">
									<input type="text" hidden="true" name="studentId"
										value="${student.id}">
									<button type="submit" class="btn-primary">Choose
										Student</button>
								</form>
							</div>
						</div>
						<hr />
					</c:forEach>
				</c:if>
				<c:if test="${not empty student}">
					<form action="changeStudent.do" method="GET">
						<input type="submit" value="Change Student">
					</form>
					<div class="row">
						<div class="col">${student.firstName }${student.lastName }</div>
						<div class="col">Birthday: ${student.birthdayDate}</div>
						<div class="col">Total Fetch: ${totalFetch}</div>
					</div>
					<div class="row">
						<div class="col">${student.gender }</div>
						<div class="col">Grade: ${student.gradeLevel}</div>
						<div class="col">Enrolled on: ${student.createdDate}</div>
					</div>
					<div class="row container">
						<div class="col">Cliques in</div>

						<c:forEach var="clique" items="${studentCliques}">
							<div class="row">${clique.name}</div>
						</c:forEach>
					</div>
					<div class="row container">
						<div class="col">Badges</div>
						<c:forEach var="badge" items="${studentBadges}">
							<div class="row">${badge.name}</div>
						</c:forEach>
					</div>
				</c:if>
			</c:when>

			<c:when test="${user.role=='admin' }">
				<h2>Logged in as ADMIN</h2>
				<div class="container">
					<h4>Flagged Comments</h4>
				</div>
				<div class="container">
					<h4><a href="allComments.do">All Comments</a></h4>
				</div>
			</c:when>

			<c:otherwise>
				<h2>Please log in to see your dashboard!</h2>
			</c:otherwise>
		</c:choose>

	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>