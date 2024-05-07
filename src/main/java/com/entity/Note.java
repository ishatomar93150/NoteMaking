package com.entity;

import java.util.Date;

public class Note
{
	private int nId;

	private String title;
	private String content;
	private Date nDate;
	private int uId;
	
	public Note()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Note(String title, String content, Date nDate, int uId)
	{
		super();
		this.title = title;
		this.content = content;
		this.nDate = nDate;
		this.uId = uId;
	}

	public int getnId()
	{
		return nId;
	}

	public String getTitle()
	{
		return title;
	}

	public String getContent()
	{
		return content;
	}

	public Date getnDate()
	{
		return nDate;
	}

	public int getuId()
	{
		return uId;
	}

	public void setnId(int nId)
	{
		this.nId = nId;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public void setnDate(Date nDate)
	{
		this.nDate = nDate;
	}

	public void setuId(int uId)
	{
		this.uId = uId;
	}
	

}
