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

				<%--IF USER HAS NOT YET SELECTED A STUDENT: --%>
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
							<div class="col">Total Fetch:&nbsp;${student.totalFetch }</div>
							<div class="col d-flex justify-content-center">
								<form action="dashboard.do" method="GET">
									<input type="text" hidden="true" name="studentId"
										value="${student.id}">
									<button type="submit" class="btn btn-primary">Choose
										Student</button>
								</form>
							</div>
						</div>
						<hr />
					</c:forEach>
					<div class="col d-flex justify-content-center">
						<form action="makeNewStudent.do" method="GET">
							<input type="text" hidden="true" name="userIdString"
								value="${user.id}">
							<button type="submit" class="btn btn-primary">Enroll New
								Student</button>
						</form>
					</div>
				</c:if>



				<%-- ONCE USER HAS SELECTED A STUDENT: --%>
				<c:if test="${not empty student}">
					<div class="row align-items-left">
						<div class="col">
							<h5>Playing as:</h5>
						</div>
					</div>
					<div class="row align-items-left">
						<div class="col-2 align-items-left">
							<c:if test="${ not empty student.imageUrl}">
								<img style="max-width: 100px" class="img-thumbnail"
									src="${student.imageUrl}" />
							</c:if>
						</div>
						<div class="col-6 align-items-left">
							<h2 style="color: darkmagenta;">${student.firstName }&nbsp;${student.lastName }</h2>
							<h5 style="color: darkmagenta;">Total
								Fetch:&nbsp;${student.totalFetch }</h5>
						</div>
						<div class="col-4 align-items-left">
							<h5>About:</h5>
							Birthday: ${student.birthdayDate} <br /> Gender:
							${student.gender } <br />Grade: ${student.gradeLevel} <br />Enrolled
							on: ${student.createdDate}
						</div>
					</div>
					<hr />
					<div class="row align-items-left">
						<div class="col-8 align-items-left">
							<h5>Clique Membership:</h5>
							<c:forEach var="clique" items="${studentCliques}">
								${clique.name}<br />
							</c:forEach>
						</div>
						<div class="col-4 align-items-left">
							<h5>Badges:</h5>
							<c:forEach var="badge" items="${studentBadges}">
								${badge.name} <img src="${badge.imageUrl }"/><br />
							</c:forEach>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col align-items-center">
							<form action="changeStudent.do" method="GET">
								<button type="submit" class="btn btn-primary">Change
									Student</button>
							</form>
						</div>
					</div>
				</c:if>
			</c:when>

			<c:when test="${user.role=='admin' }">

				<div class="row align-items-left">
					<div class="col">
						<h2>My profile</h2>
						<h3>&nbsp;</h3>
					</div>
				</div>
				<div class="row align-items-left">
					<div class="col-2 align-items-left"></div>
					<div class="col-6 align-items-left">
						<h2 style="color: darkmagenta;">${user.firstName }&nbsp;${user.lastName }</h2>
						<h5 style="color: darkmagenta;">Username:</h5>
						<em style="color: #b71c1c;">${user.username}</em>

					</div>
					<div class="col-4 align-items-left">
						<h5>About:</h5>
						Birthday: ${user.birthdayDate} <br /> Gender: ${user.gender } <br />
					</div>
				</div>
				<hr />
				<hr />

			</c:when>

			<c:otherwise>
				<h2>Please log in to see your dashboard!</h2>
			</c:otherwise>
		</c:choose>

	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>