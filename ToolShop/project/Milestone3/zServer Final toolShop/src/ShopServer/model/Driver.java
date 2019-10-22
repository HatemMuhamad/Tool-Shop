package ShopServer.model;

import java.sql.*;

public class Driver {
public static void main( String [] args) {
	try {
		// Get a connection to the data base
	
		Connection myConn =DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "yossri", "student");
		// create a statement
		Statement myStmt= myConn.createStatement();
		// execute SQL query
		ResultSet myRs= myStmt.executeQuery(" select * from itemlist");
		
		// process the result set
		while(myRs.next()) {
			System.out.println(myRs.getInt("itemId")+ ","+ myRs.getString("itemName"));
			System.out.println("anything");
	
	
		}
	}catch(Exception e)
	{
	e.printStackTrace();	
	}
}
}
