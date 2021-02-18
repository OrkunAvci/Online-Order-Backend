package onlineOrder;
import java.util.ArrayList;

public class User 
{
	protected String name;
	protected String address;
	protected String phone;
	protected String email;
	protected String password;
	private String creditCardInfo;
	private ArrayList<Order> prevOrders;
	private Order myOrder;
	private boolean payOnDoor;
	
	public User(String name, String address, String phone, String email, String credit, String password, ArrayList<Order> prev, boolean payHow) // prev??????
	{
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.creditCardInfo= credit;
		this.password= password;
		prevOrders= new ArrayList<Order>();
		if (prev !=null)
			prevOrders.addAll(prev);
		myOrder= new Order();
		payOnDoor= payHow;
	}
	
	public double getCost(String x)
	{
		return myOrder.getCost(x);
	}
	
	public boolean changeDrink(Menu req, Drink drink)
	{
		myOrder.changeDrink(req, drink);
		return true;
	}
	
	public boolean changePassword(String present, String wanted, String check)
	{
		if ( checkPassword(present) && checkPassword(wanted) && wanted.compareTo(check) ==0 )
		{
			password= wanted;
			return true;
		}
		return false;
	}
	
	public boolean checkPassword(String log)
	{
		if	( password.compareTo(log) ==0 )	{	return true;	}
		return false;
	}
	
	public boolean setMenuSize(Menu req, Size size)
	{
		myOrder.setMenuSize(req, size);
		return true;
	}
	
	public boolean addMenu(Menu x)
	{
		myOrder.insertMenu(x);
		return true;
	}
	
	public boolean addFood(Food x)
	{
		myOrder.addFood(x);
		return true;
	}
	
	public String makePayment()
	{
		if (myOrder.makePayment())
		{
			prevOrders.add(myOrder);
			return "Payment successful. Enjoj your meal!";
		}
		else
			return "Payment already has been done. Denied.";
	}
	
	public boolean getPayOnDoor()
	{
		return payOnDoor;
	}
	
	public Order getMyOrder()
	{
		return myOrder;
	}
	
	public boolean changeOrder(Order myOrder)
	{
		this.myOrder = myOrder;
		return true;
	}
	
	public boolean clearOrder()
	{
		myOrder= new Order();
		return true;
	}
	
	public String getCredit()
	{
		return creditCardInfo;
	}
	
	public void setCredit(String credit)
	{
		creditCardInfo= credit;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
}
