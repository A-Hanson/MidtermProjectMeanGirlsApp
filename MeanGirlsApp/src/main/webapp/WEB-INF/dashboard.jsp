<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>

<div>nav bar 
${student.firstName} ${student.lastName}
	<form action="logout.do" method="post"><input type="submit" value="Sign out"></form>
	<form action="logout.do" method="post"><input type="submit" value="Switch Student"></form>
</div>


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

</body>
</html>