package onlineOrder;

import java.util.ArrayList;

public class Worker extends User
{
	private ArrayList<Order> list;
	
	public Worker(String name, String password, String address, String phone, String email, String credit, ArrayList<Order> orderList)
	{
		super(name, address, phone, email, credit, password, null, false);
		list= new ArrayList<Order>();
		if (list !=null)
			list.addAll(orderList);
	}
	
	/*--------Worker Specific--------*/
	
	public void deleteUser(String mail)
	{
		DBLayer db= new DBLayer();
		db.deleteUser(mail);
	}
	
	public void createFood(String name, double cost, int ID, int cat)
	{
		DBLayer db= new DBLayer();
		Product product= new Product(ID, cost, name, cat);
		db.addProduct(product);
	}
	
	public void deleteFood(int ID)
	{
		DBLayer db= new DBLayer();
		db.deleteProduct(ID);
	}
	
	public void createMenu(String companyName, ArrayList<Food> list, double cost, int ID)
	{
		DBLayer db= new DBLayer();
		Menu newMenu= new Menu(companyName, list, cost, ID);
		db.addMenu(newMenu);
	}
	
	public void deleteMenu(int ID)
	{
		DBLayer db= new DBLayer();
		db.deleteMenu(ID);
	}
	
	public String listOrders()
	{
		DBLayer db= new DBLayer();
		return db.listOrders();
	}
	
	public String deliverOrder(Order newOrder)
	{
		String x= "";
		if (list.contains(newOrder))
		{
			list.remove(newOrder);
			x+= newOrder.deliver();
		}
		return x;
	}
	
	public ArrayList<String> deliverAllOrders()
	{
		ArrayList<String> data= new ArrayList<String>();
		for (Order x: list)
		{
			data.add(deliverOrder(x));
		}
		return data;
	}
	
	/*---------Non-change Super Methods--------*/
	
	public boolean checkPassword(String pass)
	{
		return super.checkPassword(pass);
	}
	
	public boolean changePassword(String present, String wanted, String check)
	{
		return super.changePassword(present, wanted, check);
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
	
	/*--------Necessary Overrides--------*/
	
	public boolean setMenuSize(Menu req, Size size){	return false;	}
	
	public boolean addMenu(Menu x){	return false;	}
	
	public boolean addFood(Food x){	return false;	}
	
	public String makePayment()	{	return null;	}
	
	public boolean getPayOnDoor(){	return false;	}
	
	public Order getMyOrder(){	return null;	}
	
	public boolean changeOrder(Order myOrder){	return false;	}
	
	public boolean clearOrder(){	return false;	}
	
	public double getCost(){	return 0;	}
	
	public boolean changeDrink(Menu req, Drink drink){	return false;	}
	
	public String getUsername(){	return null;	}
	
	public String getCredit(){	return null;	}	// ???
	
	public void setCredit(String credit){}			// ???
	
}