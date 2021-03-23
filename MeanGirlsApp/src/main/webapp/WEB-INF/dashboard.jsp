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
		<div>
			nav bar ${student.firstName} ${student.lastName}
			<form action="logout.do" method="post">
				<input type="submit" value="Sign out">
			</form>
			<form action="logout.do" method="post">
				<input type="submit" value="Switch Student">
			</form>
		</div>
		<c:out value="${loggedInUser }" />
		<c:choose>

			<c:when test="${user.role=='user' }">
				<h2>Logged in as USER</h2>
			</c:when>

			<c:when test="${user.role=='admin' }">
				<h2>Logged in as ADMIN</h2>
			</c:when>

			<c:otherwise>
				<h2>NOT LOGGED IN</h2>
			</c:otherwise>
		</c:choose>

		<%-- <div>
	my cliques -
	<c:forEach var="clique" items="${student.cliques}">
		${clique.name}
	</c:forEach>
</div> --%>

		<%-- <div>
	my fetch -
	<c:forEach var="clique" items="${student.cliques}">
		${clique.name}
	</c:forEach>
</div> --%>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>