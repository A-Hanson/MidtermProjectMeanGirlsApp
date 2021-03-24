<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>${user.firstName}</title>
</head>
<body>


	<c:choose>

		<c:when test="${empty user}">
			<h3>No user Was Found.</h3>
		</c:when>

		<c:otherwise>
			
  <h1>${user.firstName} ${user.lastName}</h1>
   <p>${user.username}</p>


  </c:otherwise>
  </c:choose>


		

</body>
</html>