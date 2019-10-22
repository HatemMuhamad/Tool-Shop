package ShopServer.model;


import java.util.ArrayList;
/**
 * Provides data fields and methods to create a Java data-type, representing an inventory in a java application.
 *
 * @author Y. Attia
 * @author H. Muhamad
 * @author Y. Khalil
 * @version 1.0
 * @since April 4th, 2019
 */
public class Inventory {
	/**
	 * The list of tools in inventory
	 */
	private ArrayList <Item> itemList;
	/**
	 * The order of the inventory of items.
	 */
	private Order myOrder;
	
	
	/**
	 * A default constructor that constructs a shop's inventory object creating arraylist of tools
	 */
	public Inventory() {
		itemList = null;
	}
	/**
	* Constructs a Shop's Inventory object with the specified tools arraylist. The values of the data fields are supplied by the given parameters, and creates an object of type order.
	* @param tools is the inventory's arraylist of tools
	*/
	public Inventory (ArrayList <Item> itemList) {
		this.itemList = itemList;
		myOrder = new Order ();
	}
	/**
	* Gets the inventory's arraylist tools.
	* @return arraylist of tools in inventory
	*/
	public ArrayList <Item> getItemList() {
		return itemList;
	}
	/**
	* sets the inventory's arraylist tools.
	* @param itemList is arraylist of tools in inventory
	*/
	public void setItemList(ArrayList <Item> itemList) {
		this.itemList = itemList;
	}
	/**
	 * Buys item from shop if available, else places an order for the required item.
	 * @param toolName is the tool to be bought
	 */
	public Item manageItem (String name){
		Item theItem = decreaseItem (name);
		
		if (theItem != null){
			placeOrder (theItem);
		}
		return theItem;
	}
	/**
	 * Creates an order line for the required item, to be added to current order.
	 * @param theItem item to place order for.
	 */
	public void placeOrder (Item theItem){
		OrderLine ol = theItem.placeOrder();
		if (ol !=null){
			myOrder.addOrderLine(ol);
		}
	}
	/**
	 * Decreases quantity of specified item if available.
	 * @param name of item.
	 * @return the item.
	 */
	private Item decreaseItem (String name) {
		
		Item theItem = searchForItem (name);
		
		if (theItem == null)
			return null;
		
		if (theItem.decreaseItemQuantity() == true){
			
			return theItem;
		}
		return null;
		
	}
	
	/**
	 * Gets quantity of tool
	 * @param name of tool to get quantity of
	 * @return quantity of specified tool
	 */
	public int getItemQuantity (String name){
		Item theItem = searchForItem (name);
		if (theItem == null)
			return -1;
		else
			return theItem.getItemQuantity();
	}
	/**
	 * Searches for tool in inventory by specified tool Name.
	 * @param toolName is the Name of tool searched for
	 *@return the item searched for.
	 */
	public Item searchForItem (String name) {
		for (Item i: itemList) {
			if (i.getItemName().equals(name))
				return i;
		}
		return null;
	}
	
	/**
	 * Returns string of tools in inventory
	 * @return a String of all items in the inventory.
	 */
	public String toString () {
		String str = "";
		for (Item i: itemList) {
			//
			str += i;
		}
		return str;
	}
	/**
	 * Searches for tool in inventory by specified tool ID.
	 * @param toolId is the ID of tool searched for
	 * @return the item searched for.
	 */
	public Item searchForItem(int id) {
		for (Item i: itemList) {
			if (i.getItemId() == id)
				return i;
		}
		return null;
	}
	/**
	 * returns a string of the order of an item.
	 * @return string of order generated.
	 */
	public String printOrder() {
		return myOrder.toString();
	}

}
