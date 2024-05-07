package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.NotesDao;
import com.db.DBConnect;


public class EditNote extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
	   int nId = Integer.parseInt(req.getParameter("n_id"));
	   String title = req.getParameter("title");
	   String content = req.getParameter("content");
	   HttpSession session = req.getSession();
	   NotesDao dao = new NotesDao(DBConnect.getConn());
	   if(dao.updateNote(nId, title, content))
	   {
			session.setAttribute("succMsg", "Note Updated Successfully");
			resp.sendRedirect("show_notes.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Failed to Update Note");
			resp.sendRedirect("edit_note.jsp");
		}
		
	}


}
