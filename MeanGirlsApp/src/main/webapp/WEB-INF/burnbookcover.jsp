<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>burn book cover</title>
<jsp:include page="head.jsp" />
</head>
<body id="burnbook">

	<form action="openburnbook.do" method="GET">
		<button class="btn btn-secondary m-1">Open Burn Book</button>
		<input type="hidden" name="commentId" value="${comment.id}" />
	</form>
<jsp:include page="foot.jsp" />
</body>
</html>