package onlineOrder;

public class Product
{
	private String name;
	private double cost;
	private int ID;
	private int cat;

	public Product(int ID, double cost, String name, int cat)
	{
		this.ID= ID;
		this.name = name;
		this.cost = cost;
		this.cat= cat;
	}
	
	public Food cast()
	{
		Food x= new Food(name, cost, ID);
		if 		(cat ==0)	{	x=	new Drink(name, cost, ID);	}
		else if (cat ==1)	{	x=	new Extra(name, cost, ID);	}
		return x;
	}

	public String getName()
	{
		return name;
	}

	public double getCost()
	{
		return cost;
	}

	public int getID()
	{
		return ID;
	}

	public int getType()
	{
		return cat;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setCost(double cost)
	{
		this.cost = cost;
	}

	public void setID(int ID)
	{
		this.ID = ID;
	}

	public void setCategory(int category)
	{
		this.cat = category;
	}

}
