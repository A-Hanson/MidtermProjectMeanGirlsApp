<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:choose>

	<%-- USER LOGGED IN: --%>
	

	<c:when test="${user.role=='user' and not empty student }">
		<nav class="navbar navbar-expand-md navbar-dark fixed-top">
			<div class="container">
				<a class="navbar-brand" href="home.do"><img src="resources/images/mean.png" style="max-width: 150px"></a>

				<button type="button" class="navbar-toggler" data-toggle="collapse"
					data-target="#navbar">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbar">
					<ul class="nav navbar-nav">
						<!--  li style="color: yellow;">DEBUG: USER LOGGED IN</li -->
						<li class="nav-item"><a class="nav-link active"
							href="dashboard.do">Dashboard</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="goToBurnBook.do">Burn Book</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="goToCafeteria.do">Cafeteria</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="logout.do">Log Out</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</c:when>



	<%-- USER LOGGED IN & STUDENT EMPTY: --%>
	<c:when test="${(user.role=='user') and  (empty student)}">

		<nav class="navbar navbar-expand-md navbar-dark fixed-top">
			<div class="container">
				<a class="navbar-brand" href="home.do"><img src="resources/images/mean.png" style="max-width: 150px"></a>

				<button type="button" class="navbar-toggler" data-toggle="collapse"
					data-target="#navbar">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbar">
					<ul class="nav navbar-nav">
						<!--  <li style="color: yellow;">DEBUG: USER LOGGED IN</li>  -->
						<li class="nav-item"><a class="nav-link active"
							href="logout.do">Log Out</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</c:when>


	<%-- ADMIN LOGGED IN: --%>

	<c:when test="${user.role=='admin' }">

		<nav class="navbar navbar-expand-lg navbar-dark fixed-top"
			id="admin-navbar">
			<div class="container">
				<a class="navbar-brand" href="home.do"><img src="resources/images/mean3.png" style="max-width: 150px"></a>

				<button type="button" class="navbar-toggler" data-toggle="collapse"
					data-target="#admin-navbar-toggle">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div id="admin-navbar-toggle" class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							href="dashboard.do">Admin Dashboard</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="manageUsers.do">Manage Users</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="manageComments.do">Manage Comments</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="goToCafeteria.do">Cafeteria</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="logout.do">Log Out</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</c:when>


	<%-- NO ONE LOGGED IN: --%>

	<c:otherwise>
		<nav class="navbar navbar-expand-md navbar-dark fixed-top">
			<div class="container">
				<a class="navbar-brand" href="home.do"><img src="resources/images/mean.png" style="max-width: 150px"></a>

				<button type="button" class="navbar-toggler" data-toggle="collapse"
					data-target="#navbar">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbar">
					<ul class="nav navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							href="login.do">Log In</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="register.do">Register</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</c:otherwise>
</c:choose>
