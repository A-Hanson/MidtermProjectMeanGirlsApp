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
				<h2>Logged in as USER</h2>
				<c:if test="${empty student }">
				<div class="row">
					<div class="col">
						<h3>Who are you playing as today?</h3>
					</div>
				</div>
				<c:forEach var="student" items="${userStudents }">
					<div class="row">
						<div class="col">${student.firstName } ${student.lastName }</div>
						<div class="col">${student.birthdayDate}</div>
						<div class="col">${student.imageUrl}</div>
						<div class="col"><form action="dashboard.do" method="GET">
						<input type="text" hidden="true" name="studentId" value="${student.id}">
						<input type="submit" value="Choose Student">
						</form></div>
					</div>
				</c:forEach>
				</c:if>
				<c:if test="${not empty student}">
					<div class="row">
						<div class="col">${student.firstName } ${student.lastName }</div>
						<div class="col">Birthday: ${student.birthdayDate}</div>
						<div class="col">${totalFetch}</div>
					</div>
					<div class="row">
						<div class="col">${student.gender }</div>
						<div class="col">Grade: ${student.gradeLevel}</div>
						<div class="col">Enrolled on: ${student.createdDate}</div>
					</div>
					<div class="row container"> 
					<div class="col">Cliques in</div>
						
						<c:forEach var="clique" items="${studentCliques}">
						  <div class="row">
							${clique.name}
						  </div>
						</c:forEach>
					</div>
					<div class="row container"> 
					<div class="col">Badges</div>
						<c:forEach var="badge" items="${studentBadges}">
						  <div class="row">
							${badge.name}
						  </div>
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
				<h4>All Comments</h4>
				</div>
			</c:when>

			<c:otherwise>
				<h2>NOT LOGGED IN</h2>
			</c:otherwise>
		</c:choose>

	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>