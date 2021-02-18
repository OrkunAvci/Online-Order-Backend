package onlineOrder;

public class Drink extends Food
{
	private double multiplier= 0.5;
	
	public Drink(String name, double cost, int ID)
	{
		super(name, cost, ID);
	}
	
	public void setMultiplier(double x)
	{
		multiplier= x;
	}
	
	public double getMultiplier()
	{
		return multiplier;
	}
	
	public double getCost()
	{
		double newCost= this.cost;
		if		(size ==Size.Small)		{	newCost+= 1* multiplier;}
		else if (size ==Size.Medium)	{	newCost+=2* multiplier;	}
		else if (size ==Size.Large)		{	newCost+=4* multiplier;	}
		else 	/*size ==Size.XLarge*/	{	newCost+=6* multiplier;	}
		return newCost;
	}

}
