<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes</title>
<%
User us = (User) session.getAttribute("userObj");
if (us == null)
{
	session.setAttribute("errorMsg", "Please Login to Add Note");
	response.sendRedirect("login.jsp");
}
else
{
%>
<%@ include file="components/allcss.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<%@include file="components/navbar.jsp"%>
		<div class="container">
			<h1 class="text-center">Add Your Note</h1>
			<div class="row">
				<%
				String succMsg = (String) session.getAttribute("succMsg");
				if (succMsg != null)
				{
				%>

				<div class="alert alert-success" role="alert"><%=succMsg%></div>
				<%
				session.removeAttribute("succMsg");
				}

				String errorMsg = (String) session.getAttribute("errorMsg");
				if (errorMsg != null)
				{
				%>

				<div class="alert alert-danger" role="alert"><%=errorMsg%></div>
				<%
				session.removeAttribute("errorMsg");
				}
				%>
				<div class="col-md-12">
					<form action="AddNote" method="post"><input type="hidden"
						name="u_id" value="<%=us.getId()%>"> <%
 }
 %>
						<div class="form-group">
							<label for="title">Enter Title</label> <input type="text"
								required name="title" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								placeholder="Enter title">
						</div>
						<div class="form-group">
							<label for="content">Enter Content</label> <textarea required
								rows="9" cols="" placeholder="Enter Description"
								class="form-control" name="content"></textarea>
						</div>

						<div class="container text-center">
							<button type="submit" class="btn btn-primary">Add Note</button>
						</div></form>
				</div>
			</div>
		</div>

	</div>
	<br>
	<br>

	<%@include file="components/footer.jsp"%>
</body>
</html>