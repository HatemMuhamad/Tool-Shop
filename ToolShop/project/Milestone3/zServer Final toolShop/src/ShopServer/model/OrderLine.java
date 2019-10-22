package ShopServer.model;
/**
 * Provides data fields and methods to create a Java data-type, representing an order line in a java application.
 *
 * @author Y. Attia
 * @author H. Muhamad
 * @author Y. Khalil
 * @version 1.0
 * @since April 4th, 2019
 */
public class OrderLine {
	
	private Item theItem;
	private int orderQuantity;
	
	/**
	 * constructs a new orderline
	 * 
	 * @param item: instance of the item
	 * @param quantity: quantity to be ordered
	 */
	public OrderLine (Item item, int quantity) {
		theItem = item;
		setOrderQuantity(quantity); 
		
	}
	/**
	 * 
	 * @return the item associated with hte order
	 */
	public Item getTheItem() {
		return theItem;
	}
	/**
	 * sets the item associated with the order
	 * 
	 * @param theItem
	 */
	public void setTheItem(Item theItem) {
		this.theItem = theItem;
	}
	/**
	 * 
	 * @return order quantity
	 */
	public int getOrderQuantity() {
		return orderQuantity;
	}
	/**
	 * sets the order quantity
	 * 
	 * @param orderQuantity
	 */
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	/**
	 * @return String of the order member variables
	 */
	public String toString (){
		return  "Item Name: " + theItem.getItemName() +
				", Item ID: " + theItem.getItemId()+ "\n" + 
				"Order Quantity: " + orderQuantity + "\n";
	}

}
