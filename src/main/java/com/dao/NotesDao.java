package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Note;

public class NotesDao
{
	private Connection conn;

	public NotesDao(Connection conn)
	{
		super();
		this.conn = conn;
	}
	
	public boolean addNote(String title, String content, int uId)
	{
		try
		{
			String sql = "insert into notes(title, content, u_id) values(?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, uId);
			int i = pstmt.executeUpdate();
			if(i == 1)
			{
				return true;
			} 
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public List<Note> getAllNotes(int uId)
	{
		List<Note> list = new ArrayList<Note>();
		Note n = null;
		try
		{
			String sql = "select  * from notes where u_id = ? order by n_id desc";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				n = new Note();
				n.setnId(rs.getInt("n_id"));
				n.setTitle(rs.getString("title"));
				n.setContent(rs.getString("content"));
				n.setnDate(rs.getTimestamp("date"));
				list.add(n);
				
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Note getNoteBynId(int nId)
	{
		Note n = null;
		try
		{
			String sql = "select * from notes where n_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				n = new Note();
				n.setTitle(rs.getString("title"));
				n.setContent(rs.getString("content"));
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return n;
		
	}
	
	public boolean updateNote(int nId, String title, String content)
	{
		try
		{
			String sql = "update notes set title = ? , content = ? where n_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, nId);
			int i = pstmt.executeUpdate();
			if( i == 1)
			{
				return true;
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean deleteNote(int nId)
	{
		try
		{
			String sql = "delete from notes  where n_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nId);
			int i = pstmt.executeUpdate();
			if( i == 1)
			{
				return true;
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	
	
	

}
