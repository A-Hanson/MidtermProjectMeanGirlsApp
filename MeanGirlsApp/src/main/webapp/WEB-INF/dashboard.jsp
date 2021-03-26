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
								${badge.name} <img style="max-width: 100px" class="img-thumbnail" src="${badge.imageUrl }" />
								<br />
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




			<%-- LOGGED IN AS ADMIN --%>
			<c:when test="${user.role=='admin' }">
				<div class="container">
					<h3>Admin Dashboard</h3>
					<hr />
					<h4>Name: ${user.firstName }&nbsp;${user.lastName }</h4>
					<h5>Username: ${user.username}</h5>
					<hr />
					<h5>
						<a class="nav-link active justify-content-left"
							href="manageUsers.do">Manage Users</a>
					</h5>
					<h5>
						<a class="nav-link active" href="manageComments.do">Manage
							Comments</a>
					</h5>
					<h5>
						<a class="nav-link active" href="goToCafeteria.do">Go to
							Cafeteria</a>
					</h5>
					<h5>
						<a class="nav-link active" href="logout.do">Log Out</a>
					</h5>
				</div>
			</c:when>

			<c:otherwise>
			<br>
			<br>
			<br>
			<br>
				<h3 style="color: #ee4498; text-align: center;" >Please log in to see your dashboard.</h3>
				   <center><img src="resources/images/gohere.png" alt="" height="700" width="900"> </center>

				
			</c:otherwise>
		</c:choose>

	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>