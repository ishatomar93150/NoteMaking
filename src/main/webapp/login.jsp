<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@ include file="components/allcss.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<div class="container-fluid div-color-login">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center text-white bg-custom">
					<i class="fa fa-user-plus fa-3x" aria-hidden="true"> </i>
					<h4>Login Page</h4>
					
					</div>
								<%
						 String succMsg =  (String) session.getAttribute("succMsg");
						if( succMsg != null)
						{
						%>

						<div class="alert alert-success" role="alert"><%= succMsg %></div>
							<%
							session.removeAttribute("succMsg");
						}
						
						 String errorMsg =  (String) session.getAttribute("errorMsg");
							if( errorMsg != null)
							{
							%>

							<div class="alert alert-danger" role="alert"><%= errorMsg %></div>
								<%
								session.removeAttribute("errorMsg");
							}
							
							%>
					<div class="card-body">
					
						<form action="UserLogin" method="post">
							
							<div class="form-group">
								<label for="email">Email address</label> <input required
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email" name="email">
								
							</div>
							<div class="form-group">
								<label for="password">Password</label> <input required
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Password" name="password">
							</div>
							
							<button type="submit" class="btn btn-primary badge-pill btn-block" >Login</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

<%@include file="components/footer.jsp"%>

</body>
</html>