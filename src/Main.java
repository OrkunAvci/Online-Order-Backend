package onlineOrder;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		/*
			---------General Variables-----------
			ArrayList<Comment>
			HashMap<Food.ID, int>
		*/
		DBLayer db= new DBLayer();
		Main syst= new Main();
		Food bigkingM= new Food("Big King", 0, 1);
		Food bigkingXL= new Food("Big King XXL", 0, 2);
		Food whoperS= new Food("Whoper JR", 0, 3);
		Food whoperM= new Food("Whoper", 0, 4);
		Food whoperL= new Food("Double Whoper", 0, 5);
		Food whoperXL= new Food("Triple Whoper", 0, 6);
		Drink cola= new Drink("Cola", 4.99, 7);
		Drink fanta= new Drink("Fanta", 4.99, 8);
		Drink sprite= new Drink("Sprite", 4.99, 9);
		Drink ayran= new Drink("Ayran", 2.99, 10);
		Extra fries= new Extra("French Fries", 3.99, 11);
		Extra nuggetBK= new Extra("6 Nuggets", 9.99, 12);
		Extra onionRing= new Extra("12 Onion Rings", 11.99, 13);
		ArrayList<Food> helper= new ArrayList<Food>();
		helper.add(bigkingM);
		Menu bigKingMed= new Menu("Burger King", helper, 20.0, 1);	helper.clear();
		helper.add(bigkingXL);
		Menu bigKingXXL= new Menu("Burger King",helper, 25.0, 2);	helper.clear();
		helper.add(whoperS);
		Menu whooperJR= new Menu ("Burger King", helper, 15.0, 3);	helper.clear();
		bigKingMed.addFood(cola);
		bigKingMed.addFood(fries);
		
		ArrayList<Order> prev= new ArrayList<Order>();
		
		User x= new User("x", "x", "x", "x", "x", "x", prev, false);
		prev.add(x.getMyOrder());
		Worker y= new Worker("name", "pass", "adress", "phone", "mail", "credit", prev);
		x.addMenu(bigKingMed);
		x.addFood(nuggetBK);
		x.addMenu(whooperJR);
		x.setMenuSize(bigKingMed, Size.Large);
		x.changeDrink(whooperJR, sprite);
		x.makePayment();
		System.out.println((x.getMyOrder()).toString());
		x.getCost(null);
		x.addMenu(bigKingXXL);
		x.makePayment();
		System.out.println(y.deliverOrder(x.getMyOrder()));
		
		DB_Menu tm= new DB_Menu();
		tm.encapsulate(bigKingMed);
		Menu out= tm.decapsulate();
		System.out.println(out.getContains());
	}
	
	public Worker signInWorker(String mail, String pass)
	{
		DBLayer db= new DBLayer();
		if (db.userControl(mail, pass))
			return (Worker)db.getUser(mail);
		return null;
	}
	
	public int signUpUser(String username, String name, String adress, String phone, String email, String password, String pass_correct)
	{
		DBLayer db= new DBLayer();
		if ((name.length() <6 || name.length() >32) || (adress.length() <10 || adress.length() >128) || (phone.length() !=10) /*&& ( (phone.toUpperCase()).compareTo(phone.toLowerCase()) )*/ || (password.length() <8 || password.length() >24))
		{
			return 1; //"Invalid Input."
		}
		if (password.compareTo(pass_correct) ==1)
		{
			ArrayList<Order> empty= new ArrayList<Order>();
			User newUser= new User(name, adress, phone, email, "", password, empty, false);
			if ( db.searchUser(email, phone) )
			{
				return 2; //"An account already exists with email adress."
			}
			else
			{
				if ( db.insertUser(newUser) )
					return 0; // "Check"
			}
		}
		return 3; //"Unmatched passwords."
	}
	
	public int signInUser(String request, String pass)
	{
		DBLayer db= new DBLayer();
		if ((request.length() <7 || request.length() >32) || (pass.length() <6 || pass.length() >24))
		{
			return 1; // "Invalid Input."
		}
		if (db.userControl(request, pass))
		{
			return 0;
		}
		return 2; // "No user by this info."
	}
	
	public boolean searchUser(String email, String phone)
	{
		if ( email ==null || phone ==null )	{	return false;	}
		DBLayer db= new DBLayer();
    	return db.searchUser(email, phone);
    }
        
    public boolean userControl(String email, String pass)
    {
    	if ( email ==null || pass ==null )	{	return false;	}
    	DBLayer db= new DBLayer();
    	return db.userControl(email, pass);
    }
        
    public boolean insertUser(User user)
    {
    	if ( user ==null )	{	return false;	}
    	DBLayer db= new DBLayer();
    	return db.insertUser(user);
    }
        
    public boolean userInfoUpdate(User user)
    {
    	if ( user ==null )	{	return false;	}
    	DBLayer db= new DBLayer();
    	return db.userInfoUpdate(user);
    }
        
    public ArrayList<User> getUsers(int offset, int numData)
    {
    	DBLayer db= new DBLayer();
    	return db.getUsers(offset, numData);
    }
        
    public User getUser(String email)
    {
    	if ( email ==null )	{	return null;	}
    	DBLayer db= new DBLayer();
    	return db.getUser(email);
    }
        
    public boolean deleteUser(String email)
    {
    	if ( email ==null )	{	return false;	}
    	DBLayer db= new DBLayer();
    	return db.deleteUser(email);
    }
    
    public boolean addMenu(Menu menu)
    {
    	if ( menu ==null )	{	return false;	}
    	DBLayer db= new DBLayer();
    	return db.addMenu(menu);
    }
    
    public ArrayList<Menu> getMenus()
    {
    	DBLayer db= new DBLayer();
    	return db.getMenus();
    }
        
    public Menu getMenu(int id)
    {
    	DBLayer db= new DBLayer();
        return db.getMenu(id);
    }
        
    public boolean changeMenu(Menu menu)
    {
    	if ( menu ==null )	{	return false;	}
    	DBLayer db= new DBLayer();
    	return db.changeMenu(menu);
    }
        
    public boolean deleteMenu(int id)
    {
    	DBLayer db= new DBLayer();
        return db.deleteMenu(id);
    }
        
    public ArrayList<Menu> getOrders(String email)
    {
    	DBLayer db= new DBLayer();
        return db.getOrders(email);
    }
        
    public boolean addOrder(DB_Menu menu)
    {
    	if ( menu ==null )	{	return false;	}
    	DBLayer db= new DBLayer();
        return db.addOrder(menu);
    }
    
    public ArrayList<Product> getProducts()
    {
    	DBLayer db= new DBLayer();
        return db.getProducts();
    }
        
    public Product getProduct(int x)
    {
    	DBLayer db= new DBLayer();
    	return db.getProduct(x);
    }
           
    public boolean addProduct(Product prod)
    {
    	if ( prod ==null )	{	return false;	}
    	DBLayer db= new DBLayer();
        return db.addProduct(prod);
    }
    
    public boolean changeProduct(Product prod)
    {
    	if ( prod ==null )	{	return false;	}
    	DBLayer db= new DBLayer();
        return db.changeProduct(prod);
    }
        
    public boolean deleteProduct(int id)
    {
        DBLayer db= new DBLayer();
        return db.deleteProduct(id);
    }
			
}
