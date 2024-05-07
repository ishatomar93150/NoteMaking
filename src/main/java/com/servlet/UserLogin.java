package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

public class UserLogin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserDao dao = new UserDao(DBConnect.getConn());
		User u = dao.userLogin(email, password);
		HttpSession session = request.getSession(true);
		if( u != null)
		{
			session.setAttribute("userObj", u);
			response.sendRedirect("home.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Invalid Username and Password");
			response.sendRedirect("login.jsp");
		}
	}

}
