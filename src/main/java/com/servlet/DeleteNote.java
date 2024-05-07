package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.NotesDao;
import com.db.DBConnect;

public class DeleteNote extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int nId = Integer.parseInt(req.getParameter("n_id"));
		NotesDao dao = new NotesDao(DBConnect.getConn());
		HttpSession session = req.getSession();
		if(dao.deleteNote(nId))
		{
			session.setAttribute("succMsg", "Note Deleted Successfully");
			resp.sendRedirect("show_notes.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Failed to Delete Note");
			resp.sendRedirect("show_note.jsp");
		}
	}
	
}
