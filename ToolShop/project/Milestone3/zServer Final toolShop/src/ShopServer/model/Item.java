package ShopServer.model;
/**
 * Provides data fields and methods to create a Java data-type, representing an item in a java application.
 *
 * @author Y. Attia
 * @author H. Muhamad
 * @author Y. Khalil
 * @version 1.0
 * @since April 4th, 2019
 */
public class Item {
	
	private int itemId;
	private String itemName;
	private int itemQuantity;
	private double itemPrice;
	private boolean alreadyOrdered;
	private Supplier theSupplier;
	private static final int ORDERQUANTITY = 40;
	private static final int MINIMUMUMBER = 20; 	
	
	/***
	  *  constructs new item object
	  * 
	  * @param id: item ID
	  * @param name: item name
	  * @param quanitiy:item quantity
	  * @param price: item price
	  * @param sup: supplier associated to the item
	  */
	public Item (int id, String name, int quanitiy, double price, Supplier sup) {
		
		itemId = id;
		itemName = name;
		itemQuantity = quanitiy;
		itemPrice = price;
		sup = theSupplier; 
		setAlreadyOrdered(false);
	}
	/**
	 * 
	 * @return true if item quantity>0 else returns false
	 */
	public boolean decreaseItemQuantity () {
		if (itemQuantity > 0) {
			itemQuantity--;
		    return true;	
		}
		else
			return false;
			
	}
	/**
	 * 
	 * @return an OrderLine instance if we created a new order	of the item
	 */
	public OrderLine placeOrder (){
		OrderLine ol;
		if (getItemQuantity() < MINIMUMUMBER && alreadyOrdered == false){
			ol = new OrderLine (this, ORDERQUANTITY);
			alreadyOrdered = true;
			return ol;
		}
	    return null;
	}
	/**
	 * 
	 * @return item Id
	 */
	public int getItemId() {
		return itemId;
	}
	/**
	 * sets the itemId
	 * @param itemId
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	/**
	 * 
	 * @return name of the item
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * sets name of the item
	 * @param itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * 
	 * @return item quantity
	 */
	public int getItemQuantity() {
		return itemQuantity;
	}
	/**
	 * sets the item quantity
	 * @param itemQuantity
	 */
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	/**
	 * 
	 * @return price of the item
	 */
	public double getItemPrice() {
		return itemPrice;
	}
	/**
	 * sets item price
	 * @param itemPrice
	 */
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	/**
	 * sets the supplier
	 * @param sup
	 */
	public void setTheSupplier (Supplier sup) {
		theSupplier = sup;
	}
	/**
	 * 
	 * @return the supplier associated with the item
	 */
	public Supplier getTheSupplier () {
		return theSupplier;
	}
	/**
	 * returns a string of the item members variables
	 */
	public String toString () {
		return "Item ID: " + itemId + ", Item Name: " + itemName + ", Item Quantity: " + 
	           itemQuantity +"\0";
	}
	/**
	 * 
	 * @return boolean variable of true or false
	 */
	public boolean isAlreadyOrdered() {
		return alreadyOrdered;
	}
	/**
	 * sets boolean value for alreadyOrder to either true or false		
	 * @param alreadyOrdered
	 */
	public void setAlreadyOrdered(boolean alreadyOrdered) {
		this.alreadyOrdered = alreadyOrdered;
	}

}
