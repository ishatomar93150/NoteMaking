package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.NotesDao;
import com.db.DBConnect;


public class AddNote extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		int uId = Integer.parseInt(req.getParameter("u_id"));
		NotesDao dao = new NotesDao(DBConnect.getConn());
		HttpSession session = req.getSession();
		if(dao.addNote(title, content, uId))
		{
			session.setAttribute("succMsg", "Note Added Successfully");
			resp.sendRedirect("show_notes.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Failed to Add Note");
			resp.sendRedirect("add_notes.jsp");
		}
	}
	

}
