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

public class UserRegister extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User u = new User(name, email, password);
		UserDao dao = new UserDao(DBConnect.getConn());
		
		HttpSession session = request.getSession();
		if(dao.userRegister(u))
		{
			session.setAttribute("succMsg", "Registration Successfull");
			response.sendRedirect("register.jsp");
		}
		else 
		{
			session.setAttribute("errorMsg", "Registration Successfull");
			response.sendRedirect("register.jsp");
		}
	}

}
