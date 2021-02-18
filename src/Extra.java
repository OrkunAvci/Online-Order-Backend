package onlineOrder;

public class Extra extends Food
{
	double multiplier= 0.4;
	
	public Extra(String name, double cost, int ID)
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
		if		(size ==Size.Small)		{	newCost+=2.5* multiplier;	}
		else if (size ==Size.Medium)	{	newCost+=3.4* multiplier;	}
		else if (size ==Size.Large)		{	newCost+=4.8* multiplier;	}
		else  	/*size ==Size.XLarge*/	{	newCost+=6.2* multiplier;	}
		return newCost;
	}

}
