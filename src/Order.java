package onlineOrder;
import java.util.ArrayList;
import java.util.Date;

public class Order 
{
	private Date date;
	private double cost;
	private boolean payment;
	private ArrayList<Menu> menus;
	private ArrayList<Food> extras;
	private boolean delivered;
	
	public Order()
	{
		menus= new ArrayList<Menu>();
		date= new Date();
		extras= new ArrayList<Food>();
		payment= false;
		delivered= false;
	}
	
	public boolean saveOrder()
	{
		DBLayer db= new DBLayer();
		Menu tm= new Menu("", extras,-1, -1);
		menus.add(tm);
		int index= 0;
		while ( menus.get(index)!=tm && db.addMenu(menus.get(index)) )
		{
			index++;
		}
		if ( menus.get(index)==tm )
		{
			db.addMenu(tm);
			return true;
		}
		return false;
}
	
	public int deliver()
	{
		if (payment ==false)
		{
			if (makePayment())
			{
				delivered= true;
			}
			else
			{
				return 1; // "Order has not been delivered due to payment problems, please contact with customer."
			}
		}
		else
		{
			delivered= true;
		}
		return 0; // "Order has been delivered."
	}
	
	public void changeDrink(Menu req, Drink newDrink)
	{
		if (menus.contains(req))
		{
			( menus.get( menus.indexOf(req)) ).setDrink(newDrink);;
		}
	}
	
	public void onSale(String x)
	{
		if (x.compareTo("abcde")==0)
			cost*=0.9;
	}
		
	public double getCost(String str)
	{
		double x= 0;
		for (Menu a: menus)
		{
			x+= a.getCost();
		}
		for (Food a: extras)
		{
			if (a instanceof Extra)
			{
				((Extra)a).getCost();
			}
			else if (a instanceof Drink)
			{
				x+= ((Drink)a).getCost();
			}
			else
			{
				x+= a.getCost();
			}
		}
		cost=x;
		if (str!=null)
			onSale(str);
		return cost;
	}
	
	public void setMenuSize(Menu req, Size newSize)
	{
		if (menus.contains(req))
		{
			( menus.get( menus.indexOf(req )) ).changeMenuSize(newSize);
		}
	}
	
	public String toString()
	{
		String a;
		if	(payment)	{	 a = "Order date and time  " + date + " payment recieved.";	}
		else			{	 a = "Order date and time " + date + " payment not recieved.";	}
		a+= "\nOrder includes:\n";
		for (Menu x: menus)
		{
			a+= x.getContains();
		}
		for (Food x: extras)
		{
			a+= x.getName()+ "\n";
		}
		return a;	
	}
	
	public Date getDate()
	{
		return date;
	}

	public boolean makePayment()
	{
		if (payment ==false)
		{
			payment = true;
			// saveOrder
			return true;
		}
		return false;
	}
	
	public String insertMenu(Menu ordered)
	{
		if (payment==false)
		{
			menus.add(ordered);
			return "Check";
		}
		else
			return "You have already paid for your meal, no changes can be done right now.";
	}
	
	public void removeMenu(Menu clr)
	{
		menus.remove(clr);
	}
	
	public String addFood(Food addon)
	{
		if (payment==false)
		{
			extras.add(addon);
			return "Check";
		}
		else
			return "You have already paid for your meal, no changes can be done right now.";
	}
	
	public void removeExtra(Food clr)
	{
		extras.remove(clr);
	}
}
