<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>${userLookUp.firstName}</title>
<jsp:include page="head.jsp" />
</head>
<body>


<jsp:include page="nav.jsp" />

<div class="container">
<c:out value="${loggedInUser }" />
	<c:choose>

		<c:when test="${empty userLookUp}">
			<h3>No user Was Found.</h3>
		</c:when>

		<c:otherwise>
			
  <h1>${userLookUp.firstName} ${userLookUp.lastName}</h1>
   <p>${userLookUp.username}</p>

   <div >
			<form action="updateUser.do" method="GET">
				<input type="hidden" name="id" value="${userLookUp.id}"/> 
				<input type="submit" value="Update" />
			</form>
			<form action="deleteUser.do" method="POST">
				<input type="hidden" name="id" value="${userLookUp.id}"/> 
				<input type="submit" value="Delete" onclick="return confirm('Are you sure? This CANNOT be undone.'); " />
			</form>
</div>
  </c:otherwise>
  </c:choose>
</div>

		
<jsp:include page="foot.jsp" />
</body>
</html>