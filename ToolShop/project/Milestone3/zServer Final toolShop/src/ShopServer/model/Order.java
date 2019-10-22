package ShopServer.model;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
/**
 * Provides data fields and methods to create a Java data-type, representing an order in a java application.
 *
 * @author Y. Attia
 * @author H. Muhamad
 * @author Y. Khalil
 * @version 1.0
 * @since April 4th, 2019
 */
public class Order {
	
	
	private Date today;
	private int orderId;
	private ArrayList <OrderLine> orderLines;
	
	/**
	 * constructs a new order that will hold an arraylist of orderlines
	 */
	public Order () {
		today = Calendar.getInstance().getTime();
		orderLines = new ArrayList <OrderLine> ();
	}
	
	/**
	 * adds an orderline instance to the orderlines
	 * 
	 * @param ol: instance of orderline
	 */
	public void addOrderLine (OrderLine ol) {
		orderLines.add(ol);
	}
	/**
	 * 
	 * @return arraylist of orderlines
	 */
	public ArrayList <OrderLine> getOrderLines (){
		return orderLines;
	}
	/**
	 * sets the arraylist of orderlines
	 * 
	 * @param lines
	 */
	public void setOrderLines (ArrayList <OrderLine> lines){
		orderLines = lines;
	}
	/**
	 * 
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * sets the orderId
	 * 
	 * @param orderId
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return an invoice of the orders made
	 */
	public String toString (){
		String order = "Order Date: " + today.toString() + "\0\0";
		String str = "";
		for (OrderLine ol: orderLines) {
			str += ol;
			str += "------------------------\0";
		}
		if (str == "")
			str = "There are currently no orderlines";
		
		order += str;
		order += "\0";
		return order;
	}

}
