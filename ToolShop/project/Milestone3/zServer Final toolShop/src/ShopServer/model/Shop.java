package ShopServer.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Provides data fields and methods to create a Java data-type, representing a
 * shop in a java application.
 *
 * @author Y. Attia
 * @author H. Muhamad
 * @author Y. Khalil
 * @version 1.0
 * @since April 4th, 2019
 */
public class Shop implements Runnable {
	private BufferedReader in;
	private PrintWriter out;
	private Socket aSocket;
	/**
	 * The shop's inventory
	 */
	private Inventory theInventory;
	/**
	 * The shop's inventory
	 */
	private ArrayList<Supplier> supplierList;

	private static Connection myConn1;

	/**
	 * A default constructor that constructs a shop object creating inventory and
	 * arraylist of suppliers Connects to the database
	 * 
	 * @throws IOException
	 */
	public Shop(Socket aSocket, Connection myConn) throws IOException {
		this.aSocket = aSocket;
		this.in = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
		this.out = new PrintWriter((aSocket.getOutputStream()), true);
		supplierList = new ArrayList<Supplier>();
		readSuppliers();
		theInventory = new Inventory(readItems());
		// this.myConn=myConn;
		try {
			Shop.myConn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "yossri", "student");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Sets list of suppliers from a specified filename. reads suppliers from the
	 * data base and stores them directly in the arraylist of suppliers
	 */
	private void readSuppliers() {

		try {
			// Get a connection to the data base

			// create a statement
			Statement myStmt = myConn1.createStatement();
			// execute SQL query
			ResultSet myRs = myStmt.executeQuery(" select * from supplierlist");

			// process the result set
			while (myRs.next()) {

				supplierList.add(new Supplier(myRs.getInt("supplierId"), myRs.getString("supName"),
						myRs.getString("supAddress"), myRs.getString("supContactName")));
			}


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Sets inventory items from specified file name. reads items from the data base
	 * and saves them into the arraylist
	 */
	private ArrayList<Item> readItems() {

		ArrayList<Item> items = new ArrayList<Item>();

		try {

			// create a statement
			Statement myStmt = myConn1.createStatement();
			// execute SQL query
			ResultSet myRs = myStmt.executeQuery(" select * from itemlist");

			// process the result set
			while (myRs.next()) {
				int supplierId = myRs.getInt("supplierID");
				Supplier theSupplier = findSupplier(supplierId);
				if (theSupplier != null) {
					Item myItem = new Item(myRs.getInt("itemId"), myRs.getString("itemName"),
							myRs.getInt("itemQuantity"), myRs.getDouble("itemPrice"), theSupplier);
					items.add(myItem);
					theSupplier.getItemList().add(myItem);
				}

			}


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return items;
	}

	/**
	 * Searches for supplier in shop by specified supplier ID and returns result.
	 * decided to search in the arraylist instead of data base as we dont need to
	 * update it
	 * 
	 * @param supplierId is the ID of supplier searched for
	 * @return the supplier.
	 */
	private Supplier findSupplier(int supplierId) {
		Supplier theSupplier = null;
		for (Supplier s : supplierList) {
			if (s.getSupId() == supplierId) {
				theSupplier = s;
				break;
			}

		}
		return theSupplier;
	}

	/**
	 * Gets the shop's inventory.
	 * 
	 * @return inventory of shop
	 */
	public Inventory getTheInventory() {
		return theInventory;
	}

	/**
	 * Sets the shop's inventory.
	 * 
	 * @param inventory is the inventory of shop
	 */
	public void setTheInventory(Inventory inventory) {
		theInventory = inventory;
	}

	/**
	 * Gets the shop;s suppliers..
	 * 
	 * @return suppliers of shop
	 */
	public ArrayList<Supplier> getSupplierList() {
		return supplierList;
	}

	/**
	 * Sets the shop's supplierList.
	 * 
	 * @param suppliers are the suppliers of the shop
	 */
	public void setSupplierList(ArrayList<Supplier> suppliers) {
		supplierList = suppliers;
	}

	/**
	 * checks the items directly from the data base, instead of accessing the
	 * inventory arraylist
	 * 
	 * @return string of all items in store.
	 */
	public synchronized String listAllItems() {

		String s = " ";
		try {

			// create a statement
			Statement myStmt = myConn1.createStatement();
			// execute SQL query
			ResultSet myRs = myStmt.executeQuery(" select * from itemlist");

			// process the result set
			while (myRs.next()) {
				
				s += "Item ID: " + myRs.getInt("itemId") + ", Item Name: " + myRs.getString("itemName")
						+ ", Item Quantity: " + myRs.getInt("itemQuantity") + ", Item Price "
						+ myRs.getDouble("itemPrice") + "\0";

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;

	}

	/**
	 * Buys item from shop and checks quantity in order to make an order if needed.
	 * makes on-time update to the data base
	 * 
	 * @param toolName is the tool to be bought
	 */
	public synchronized String buyItem(String name) {
		int old = 0;
		String flag="";

			try {
				PreparedStatement ps = myConn1.prepareStatement(" select * from itemlist where itemName=?");
				ps.setString(1, name);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					flag=rs.getString("itemName");
					old = rs.getInt("itemQuantity");
				}
				if (old - 1 >= 0) {
					ps = myConn1.prepareStatement("UPDATE itemlist SET itemQuantity=? WHERE itemName =?");

					ps.setInt(1, old - 1);
					ps.setString(2, name);
					ps.executeUpdate();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flag.equals(""))
				return " item doesnot exist";
			else
				return " item quantity was decreased by 1";
		}
	

	/**
	 * returns store suppliers in the list of suppliers..
	 * 
	 * @return string of all suppliers of the shop.
	 */
	public synchronized String listAllSuppliers() {
		String s = " ";
		try {

			// create a statement
			Statement myStmt = myConn1.createStatement();
			// execute SQL query
			ResultSet myRs = myStmt.executeQuery(" select * from supplierlist");

			// process the result set
			while (myRs.next()) {
				
				s += "supplier name: "+myRs.getString("supName")+ ", supplier ID: " + myRs.getInt("supplierId")+" \0";
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
		


	}

	/**
	 * Searches for tool in inventory by specified tool Name, if item name found in
	 * array list then goes to data base to get latest version of the item
	 * 
	 * @param toolName is the name of tool searched for
	 */
	public String getItem(String name) {



			String item="";
			try {
				PreparedStatement ps = myConn1.prepareStatement(" select * from itemlist where itemName=?");
				ps.setString(1, name);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					item += "Item ID: " + rs.getInt("itemId") + ", Item Name: " + rs.getString("itemName")
							+ ", Item Quantity: " + rs.getInt("itemQuantity") + ", Item Price "
							+ rs.getDouble("itemPrice") + "\0";
				}
			} catch (SQLException e) {
				System.out.println(" problem at getItem by name" );
				e.printStackTrace();
			}
			if (item.equals(""))
				return " couldn't be found";
			else
				return "The item information is as follows: \0"+item;

		
	}

	/**
	 * Searches for tool in inventory by specified tool ID and returns result.,  if found looks in the data base for the latest version
	 * 
	 * @param toolId is the ID of tool searched for
	 */
	public String getItem(int id) {

		String item="";
			try {
				PreparedStatement ps = myConn1.prepareStatement(" select * from itemlist where itemId=?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					item += "Item ID: " + rs.getInt("itemId") + ", Item Name: " + rs.getString("itemName")
							+ ", Item Quantity: " + rs.getInt("itemQuantity") + ", Item Price "
							+ rs.getDouble("itemPrice") + "\0";
				}
			} catch (SQLException e) {
				System.out.println(" problem at getItem by name" );
				e.printStackTrace();
			}
			if (item.equals(""))
				return " couldnt be found";
			else
				return "The item information is as follows: \0"+item;// outputItem(theItem);
		}
	

	/**
	 * Returns a statement about the information of the item.
	 * 
	 * @param theItem item to be used.
	 * @return String of item's information.
	 */
	private String outputItem(Item theItem) {
		return "The item information is as follows: \0" + theItem.toString();
	}

	/**
	 * Checks quantity of specified tool.
	 * 
	 * @param name of tool to check quantity for
	 * @return String with results.
	 */
	public String getItemQuantity(String name) {
		
		String item="";
		try {
			PreparedStatement ps = myConn1.prepareStatement(" select * from itemlist where itemName=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
	
			item+=	"The quantity of Item " + rs.getString("itemName") + " is: " + rs.getInt("itemQuantity") + "\0";
			}
		} catch (SQLException e) {
			System.out.println(" problem at getItem by name" );
			e.printStackTrace();
		}
		if (item.equals(""))
			return " no such item"+name;
		else
			return item;// outputItem(theItem);


	}

	/**
	 * returns information about orders made by the shop.
	 * 
	 * @return String of information of order made.
	 */
	public String printOrder() {
		return theInventory.printOrder();
	}

	/**
	 * runs the shop thread, recieves input from the gui and assigns the appropriate
	 * response based on the correct indicator
	 * 
	 */

	@Override
	public void run() {
		String line = " ";// StringBuffer line = null;
		try {
			while (true) {
				try {
				line = this.in.readLine();
				}catch( Exception e) {
					System.out.print(" problem line");
				}
				if (line != null) {
					if(line.toString().startsWith("signin")) {
						out.println("signinsuccess");
					}
					else if (line.toString().startsWith("BUY")) {
						out.println("0" + buyItem(line.toString().substring(3, line.length())));

					} else if (line.toString().startsWith("LISTITEMS")) {
						out.println(listAllItems());
					} else if (line.toString().startsWith("LISTSUPPLIERS")) {
						out.println(listAllSuppliers());

					} else if (line.toString().startsWith("SEARCHID")) {
						out.println("0" + getItem(Integer.parseInt(line.toString().substring(8, line.length()))));
					} else if (line.toString().startsWith("SEARCHNAME")) {
						out.println("0" + getItem(line.toString().substring(10, line.length())));

					} else if (line.toString().startsWith("QUANTITY")) {
						out.println("0" + getItemQuantity(line.toString().substring(8, line.length())));

					} else if (line.toString().startsWith("PRINT")) {
						out.println(printOrder());

					}else if(line.toString().toLowerCase().equals("quit")) {
						break;
					}
				}
			}
			out.println("quit");
			System.out.println(" out closed after the while");
			out.close();
			aSocket.close();
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
