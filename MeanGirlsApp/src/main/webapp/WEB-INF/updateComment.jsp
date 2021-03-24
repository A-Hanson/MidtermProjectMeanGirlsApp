<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Comment</title>
</head>
<body>

	<form action="updateComment.do" method="POST">

		<div>
			<input type="hidden" name="id" value="${comment.id}" required />
		</div>

		<div>  
			<input id="content" type="text" name="content"
				value="${comment.content}" placeholder="content" required />
		</div>

		<br>

		<div>
			<button type="submit">Update</button>
		</div>
	</form>


</body>
</html>