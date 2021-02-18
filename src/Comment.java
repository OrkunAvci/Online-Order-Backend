package onlineOrder;

import java.util.ArrayList;
import java.util.Date;

public class Comment
{
	private String comment;
	private int rate;
	private boolean posivite;
	private String username;
	private Date date;
	
	public Comment(String comment, int rate, boolean pos, String user)
	{
		this.comment= comment;
		this.rate= rate %6;
		this.posivite= pos;
		username= user;
		date= new Date();
	}
	
	public void setRate(int fix)
	{
		rate= fix %6;
	}
	
	public void setComment(String fix)
	{
		if (fix.length()<256)
			comment= fix;
	}
	
	public String getUsername()
	{
		return username;
	}

	public Date getDate()
	{
		return date;
	}

	public String getComment()
	{
		return comment;
	}

	public int getRate()
	{
		return rate;
	}

	public boolean isPosivite()
	{
		return posivite;
	}
	
}
