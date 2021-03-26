<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mean Girls</title>
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

				<h3 style="color: #ee4498; text-align: center;" >Log into your account to see this page.</h3>
				   <center><img src="resources/images/gohere.png" alt="" height="700" width="900"> </center>

			</c:otherwise>
			<%-----------------------%>

		</c:choose>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
