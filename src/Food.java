package onlineOrder;
import java.util.ArrayList;

public class Food
{
	protected String name;
	protected double cost;
	protected int ID;
	protected Size size;
	
	public Food(String name, double cost, int ID)
	{
		this.ID= ID;
		this.name = name;
		this.cost = cost;
		this.size= Size.Medium;
	}
	
	public void setSize(Size size)
	{
		this.size= size;
	}
	
	public Size getSize()
	{
		return size;
	}
		
	public void setCost(double newCost)
	{
		cost= newCost;
	}
	
	public double getCost()
	{
		return cost;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void updateCost(double newCost)
	{
		cost = newCost;
	}
	
}
