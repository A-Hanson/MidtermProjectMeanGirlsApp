<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp" />
<title>Register Student</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<form action="submitNewStudent.do" method="POST">
			<div class="row">
				<div class="col-6">
					<h3>Create Student:</h3>
					<input type="text" hidden="true" name="userIdString"
						value="${user.id}">

					<div class="form-group">
						<label for="firstName">First Name:</label> <input type="text"
							class="form-control" name="firstName">
					</div>

					<div class="form-group">
						<label for="lastName">Last Name:</label> <input type="text"
							class="form-control" name="lastName">
					</div>

					<div class="form-group">
						<label for="gradeLevel">Grade: </label><select id="gradeLevel"
							name="gradeLevel" class="form-control">
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select>
					</div>
					<div class="form-group">
						<label for="gender">Gender:</label> <input type="text"
							class="form-control" name="gender">
					</div>
					<div class="form-group">
						<label for="birthday">Birthday: </label> <input type="date"
							class="form-control" name="birthday">
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>

				</div>
				<div class="col-6">
					<div class="row">
						<h3>Profile Pic:</h3>
					</div>
					<div class="row">
						<div class="form-check">
							<input class="form-check-input" type="radio" name="imageUrl"
								value="resources/images/cady.jpg" checked> <label
								class="form-check-label" for="imageUrl"> <img
								style="max-width: 100px" class="img-thumbnail"
								src="resources/images/cady.jpg" />
							</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="imageUrl"
								value="resources/images/regina.jpg"> <label
								class="form-check-label" for="imageUrl"> <img
								style="max-width: 100px" class="img-thumbnail"
								src="resources/images/regina.jpg" />
							</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="imageUrl"
								value="resources/images/gretchen-wieners.jpg"> <label
								class="form-check-label" for="imageUrl"> <img
								style="max-width: 100px" class="img-thumbnail"
								src="resources/images/gretchen-wieners.jpg" />
							</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="imageUrl"
								value="resources/images/karen-smith.jpg"> <label
								class="form-check-label" for="imageUrl"> <img
								style="max-width: 100px" class="img-thumbnail"
								src="resources/images/karen-smith.jpg" />
							</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="imageUrl"
								value="resources/images/janis-ian.jpg"> <label
								class="form-check-label" for="imageUrl"> <img
								style="max-width: 100px" class="img-thumbnail"
								src="resources/images/janis-ian.jpg" />
							</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="imageUrl"
								value="resources/images/the-dude.jpg"> <label
								class="form-check-label" for="imageUrl"> <img
								style="max-width: 100px" class="img-thumbnail"
								src="resources/images/the-dude.jpg" />
							</label>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>