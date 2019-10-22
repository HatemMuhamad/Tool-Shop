package ShopServer.model;
import java.util.ArrayList;
/**
 * Provides data fields and methods to create a Java data-type, representing a supplier in a java application.
 *
 * @author Y. Attia
 * @author H. Muhamad
 * @author Y. Khalil
 * @version 1.0
 * @since April 4th, 2019
 */
public class Supplier {
	
	private int supId;
	private String supName;
	private String supAddress;
	private String supContactName;
	private ArrayList <Item> itemList;
	
	/**
	 * 
	 * @param id: supplier Id
	 * @param name: supplier name
	 * @param address: supplier address
	 * @param contactName: supplier contact name
	 */
	public Supplier (int id, String name, String address, String contactName) {
		
		supId = id;
		supName = name;
		supAddress = address;
		supContactName = contactName;
		itemList = new ArrayList <Item>();
	}

	/**
	 * 
	 * @return supplier Id
	 */
	public int getSupId() {
		return supId;
	}

	/**
	 * sets the supplier ID
	 * 
	 * @param supId
	 */
	public void setSupId(int supId) {
		this.supId = supId;
	}

	/**
	 * 
	 * @return supplier name
	 */
	public String getSupName() {
		return supName;
	}

	/**
	 * sets the supplier name
	 * 
	 * @param supName
	 */
	public void setSupName(String supName) {
		this.supName = supName;
	}

	/**
	 * 
	 * @return supplier address
	 */
	public String getSupAddress() {
		return supAddress;
	}

	/**
	 * sets the supplier address
	 * 
	 * @param supAddress
	 */
	public void setSupAddress(String supAddress) {
		this.supAddress = supAddress;
	}

	/**
	 * 
	 * @return supplier contact name
	 */
	public String getSupContactName() {
		return supContactName;
	}

	/**
	 * sets the suppleir contact name
	 * 
	 * @param supContactName
	 */
	public void setSupContactName(String supContactName) {
		this.supContactName = supContactName;
	}
	/**
	 * @return String of supplier member variables
	 */
	public String toString () {
		return supName + " Supplier ID: " + supId+ "\0";
		
	}

	/**
	 * 
	 * @return arraylist of items associated with the supplier
	 */
	public ArrayList <Item> getItemList() {
		return itemList;
	}

	/**
	 * sets the item arrayList
	 * 
	 * @param itemList
	 */
	public void setItemList(ArrayList <Item> itemList) {
		this.itemList = itemList;
	}
	
	

}
