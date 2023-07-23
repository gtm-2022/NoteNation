<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<%@include file="all_component/all_css.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid div-color">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user fa-3x" aria-hidden="true"></i>
						<h4>Login page</h4>
					</div>



					<%
					String invalidMsg = (String) session.getAttribute("login-failed");
					if (invalidMsg != null) {
					%>

					<div class="alert alert-danger" role="alert"><%=invalidMsg%></div>
					<%
					session.removeAttribute("login-failed");
					}
					%>

					<%
					String withoutLogin = (String) session.getAttribute("Login-error");
					if (withoutLogin != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=withoutLogin%></div>
					<%
					session.removeAttribute("Login-error");
					}
					%>
					
					<%
					String lgMsg=(String)session.getAttribute("logoutMsg");
					if(lgMsg!=null){%>
						<div class="alert alert-danger" role="alert"><%=lgMsg%></div>
					<%
					session.removeAttribute("logoutMsg");
					}
					%>
					<div class="card-body">
						<form action="loginServlet" method="post">


							<div class="mb-3">
								<label>Enter Email </label> <input type="email"
									class="form-control" id="exampleInputEmail"
									arial-describedby="emailHelp" name="umail">
							</div>
							<div class="mb-3">

								<label for="exampleInputPassword1" class="form-label">Enter
									Password</label> <input type="password" class="form-control"
									id="exampleInputPassword1" name="upassword">
							</div>

							<button type="submit" class="btn btn-primary badge-pill w-100">Login</button>
						</form>
					</div>




				</div>

			</div>

		</div>
	</div>
	<%@include file="all_component/footer.jsp" %>
</body>
</html>