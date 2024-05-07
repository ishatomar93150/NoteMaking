<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>

<%@ include file="components/allcss.jsp"%>
</head>
<body>
<div class="container-fluid p-0 ">
	<%@include file="components/navbar.jsp"%>
<div class="card py-5" >
<div class="card-body text-center">
<img alt="" src="img/note_home.png" class="img-fluid mx-auto" style="max-width: 300px">
<h1>START TAKING YOUR NOTES</h1>
<a href="add_notes.jsp" class="btn btn-outline-primary">Start here</a>
</div>
</div>
</div>
	

	<%@include file="components/footer.jsp"%>
</body>
</html>