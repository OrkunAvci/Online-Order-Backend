package onlineOrder;
import java.util.ArrayList;

public class Menu
{
	private String companyName;
	private String name;
	private int ID;
	private ArrayList<Food> contains;
	private double cost;
	
	public Menu(String companyName, ArrayList<Food> list, double cost, int ID)
	{
		this.ID= ID;
		this.cost= cost;
		this.companyName= companyName;
		contains= new ArrayList<Food>();
		if (contains !=null && list !=null)
		{
			contains.addAll(list);
			name= (contains.get(0)).getName()+ " Menu";
		}
	}
	
	public double getCost()
	{
		double x= cost;
		for (Food a: contains)
		{
			x+= a.getCost();
		}
		return x;
	}
	
	public String getContains()
	{
		String x="";
		for (Food a: contains)
		{
			x+= a.getName()+ " ["+ a.getSize()+ "]\n";
		}
		return x;
	}
	
	public void changeMenuSize(Size newSize)
	{
		for (Food x: contains)
		{
			if (x instanceof Extra)
			{
				((Extra)x).setSize(newSize);
			}
			else if (x instanceof Drink)
			{
				((Drink)x).setSize(newSize);
			}
			else
			{
				x.setSize(newSize);
			}
		}
	}
	
	public String getCompanyName()
	{
		return companyName;
	}
	
	public void changeMainFood(Food main)
	{
		if (contains.isEmpty())
			contains.remove(0);
		contains.add(0, main);
	}
	
	public Food getMainFood()
	{
		return contains.get(0);
	}
	
	public Food getDrink()
	{
		return contains.get(1);
	}
	
	public void setDrink(Drink drink)
	{
		if (contains.size()>1)
			contains.remove(1);
		contains.add(1, drink);
	}
	
	public ArrayList<Food> getAllFood()
	{
		return contains;
	}
	
	public void addFood(Food addon)
	{
		contains.add(addon);
	}
	
	public void setCost(double cost)
	{
		this.cost= cost;
	}
	
	public void setID(int ID)
	{
		this.ID= ID;
	}
		
	public int getID()
	{
		return ID;
	}

	public String getName()
	{
		return name;
	}
	
}
