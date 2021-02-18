package onlineOrder;

import java.util.ArrayList;

public class DB_Menu
{
	int ID;
	String list;
	String username;
	
	public DB_Menu()
	{
		// Empty.
	}
	
	public void encapsulate(Menu x)
	{
		ID= x.getID();
		list= "";
		ArrayList<Food> f= x.getAllFood();
		for (Food a: f)
		{
			list+= a.getID()+ " ";
		}
	}
	
	public Menu decapsulate()
	{
		int start= 0, end= 1;
		DBLayer db= new DBLayer();
		Menu x= new Menu("", null, 0, 0);
		Product lyr= new Product(0, 0.0, "", 0);
		while ( end <list.length() )
		{
			while (list.charAt(end) !=' ' && end <list.length() ) 	{	end++;	}
			lyr= new Product(0, 0.0, "x", 0);	// db.getProduct( Integer.parseInt( list.substring(start, end) ) );
			x.addFood( lyr.cast() );
			start= ++end;
		}
		x.setCost(x.getCost());
		x.setID(ID);
		return x;
	}
		
	public void setID(int ID) 			{	this.ID = ID;}

	public void setList(String list) 	{	this.list = list;	}

	public void setUser(String user) 	{	username = user;	}

	public String getUser()	{	return username;	}
	
	public int getID()		{	return ID;	}
	
	public String getList()	{	return list;	}
	
}
