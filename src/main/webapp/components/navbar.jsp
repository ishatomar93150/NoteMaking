<%@page import="com.entity.*"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-custom navbar-custom">
	<a class="navbar-brand" href="index.jsp"><i class="fa fa-book"
		aria-hidden="true"></i>ENotes</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
	data-target="#navbarSupportedContent"
	aria-controls="navbarSupportedContent" aria-expanded="false"
	aria-label="Toggle navigation"><span
		class="navbar-toggler-icon"></span></button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="home.jsp"><i
					class="fa fa-home" aria-hidden="true"></i>Home <span
					class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link" href="add_notes.jsp"><i
					class="fa fa-plus-circle" aria-hidden="true"></i>Add Note</a></li>

			<li class="nav-item"><a class="nav-link " href="show_notes.jsp"><i
					class="fa fa-address-book" aria-hidden="true"></i>Show Notes</a></li>
		</ul>

		<%
		User u = (User) session.getAttribute("userObj");
		if (u != null)
		{
		%>
		<a class="btn btn-light my-2 my-sm-0 mr-2 " href="#"
			data-toggle="modal" data-target="#exampleModal"><i
			class="fa fa-user" aria-hidden="true"></i><%=u.getName()%></a> <a
			class="btn btn-light my-2 my-sm-0" href="UserLogout"><i
			class="fa fa-sign-out" aria-hidden="true"></i> Log out</a>
			
			 <!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"><span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container text-center">
						<i class="fa fa-user fa-3x" aria-hidden="true"></i>
						<table class="table">
							<tbody>
								<tr>
									<th>User Id: </th>
									<td><%= u.getId() %></td>
							</tr>
								<tr>
									<th>Full Name</th>
									<td><%= u.getName() %></td>
							</tr>
								<tr>
									<th>Email id:</th>
									<td><%= u.getEmail() %></td>
							</tr>
						</tbody>
						</table>
						
						<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					</div>


				</div>
				
			</div>
		</div>
	</div>
		<%
		}
		else
		{
		%>
		<a class="btn btn-light my-2 my-sm-0 mr-2 " href="login.jsp"><i
			class="fa fa-user" aria-hidden="true"></i>Login</a> <a
			class="btn btn-light my-2 my-sm-0" href="register.jsp"><i
			class="fa fa-user-plus" aria-hidden="true"></i>Register</a>
		<%
		}
		%>
	</div>
	
	
</nav>





