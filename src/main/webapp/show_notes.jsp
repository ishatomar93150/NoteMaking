
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.NotesDao"%>
<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
User us = (User) session.getAttribute("userObj");
if (us == null)
{
	session.setAttribute("errorMsg", "Please Login ...");
	response.sendRedirect("login.jsp");
}
else
{
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Notes</title>

<%@ include file="components/allcss.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<%
			String succMsg = (String) session.getAttribute("succMsg");
			if (succMsg != null)
			{
			%>

			<div class="alert alert-success col-md-12" role="alert"><%=succMsg%></div>
			<%
			session.removeAttribute("succMsg");
			}

			String errorMsg = (String) session.getAttribute("errorMsg");
			if (errorMsg != null)
			{
			%>

			<div class="alert alert-danger col-md-12" role="alert"><%=errorMsg%></div>
			<%
			session.removeAttribute("errorMsg");
			}
			%>
	
	<div class="container">
		<h1 class="text-center">All Notes:</h1>
		<div class="row">
			
			<div class="col-md-12">
				<%
				NotesDao dao = new NotesDao(DBConnect.getConn());

				List<Note> list = dao.getAllNotes(us.getId());
				if(list.size() == 0)
				{ %>
					<div class="col-md-12">Please Add a Note  <a href="add_notes.jsp">Click Here</a></div> <br> <br>
			<% 	}
				for (Note n : list)
				{
				
				%>

				<div class="card mt-3">
					<img alt="" src="img/note_home.png"
						class="card-img-top mt-2 mx-auto" style="max-width: 100px;">

					<div class="card-body p-4">
						<h5 class="card-title"><%=n.getTitle()%></h5>
						<p><%=n.getContent()%></p>

						<p><b class="text-success">Published By: </b> <b
							class="text-primary"><%=us.getName()%> </b></p>

						<p><b class="text-success">Published Date and Time: </b> <b
							class="text-primary"><%=n.getnDate()%> </b></p>

						<div class="container text-center mt-2">
							<a href="DeleteNote?n_id=<%=n.getnId() %>" class="btn btn-danger">Delete</a>
							 <a href="edit_note.jsp?n_id=<%=n.getnId() %>"	class="btn btn-primary">Edit</a>
						</div>
					</div>
				</div>
				<%
				}
				%>

			</div>
		</div>
	</div>

	<%
	}
	%>

	<%@include file="components/footer.jsp"%>
</body>
</html>















