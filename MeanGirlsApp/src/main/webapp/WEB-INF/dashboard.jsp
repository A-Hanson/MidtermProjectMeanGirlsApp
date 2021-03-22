<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<title>Dashboard</title>
</head>
<body>
<div class="container">
<div>nav bar 
${student.firstName} ${student.lastName}
	<form action="logout.do" method="post"><input type="submit" value="Sign out"></form>
	<form action="logout.do" method="post"><input type="submit" value="Switch Student"></form>
</div>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</body>
</html>