<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-md navbar-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="home.do">MEAN GIRLS</a>

		<button type="button" class="navbar-toggler" data-toggle="collapse"
			data-target="navbar">
			<span class="navbar-toggler-icon"></span>
		</button>

		<c:choose>

			<%-- USER LOGGED IN: --%>

			<c:when test="${user.role=='user' }">
				<div class="collapse navbar-collapse" id="navbar">
					<ul class="nav navbar-nav">
						<li style="color:yellow;">DEBUG: USER LOGGED IN</li>
						<li class="nav-item"><a class="nav-link active"
							href="XXXXXXXXXXXXXXXXTODO">Dashboard</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="XXXXXXXXXXXXXXXXTODO">Burn Book</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="XXXXXXXXXXXXXXXXTODO">Cafeteria</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="XXXXXXXXXXXXXXXXTODO">Log Out</a></li>
					</ul>
				</div>
			</c:when>


			<%-- ADMIN LOGGED IN: --%>

			<c:when test="${user.role=='admin' }">
				<div class="collapse navbar-collapse" id="navbar">
					<ul class="nav navbar-nav">
						<li style="color:yellow;">DEBUG: ADMIN LOGGED IN</li>
						<li class="nav-item"><a class="nav-link active"
							href="XXXXXXXXXXXXXXXXTODO">Admin Dashboard</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="XXXXXXXXXXXXXXXXTODO">Log Out</a></li>
					</ul>
				</div>
			</c:when>


			<%-- NO ONE LOGGED IN: --%>

			<c:otherwise>
				<div class="collapse navbar-collapse" id="navbar">
					<ul class="nav navbar-nav">
						<li style="color:yellow;">DEBUG: NO ONE LOGGED IN</li>
						<li class="nav-item"><a class="nav-link active"
							href="login.do">Log In</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="register.do">Register</a></li>
					</ul>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</nav>
