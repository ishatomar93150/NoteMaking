package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDao
{
	private Connection conn;

	public UserDao(Connection conn)
	{
		super();
		this.conn = conn;
	}
	
	public boolean userRegister(User u)
	{
		try
		{
			String sql = "insert into user(name, email, password) values(?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getName());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getPassword());
			int i = pstmt.executeUpdate();
			if(i == 1)
				return true;
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}
	
	public User userLogin(String email, String password)
	{
		User u = null;
		try
		{
			String sql = "select * from user where email = ? and password = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return u;
	}

}















