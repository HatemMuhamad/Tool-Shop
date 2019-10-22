package ShopServer.serverController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ShopServer.model.Shop;

/**
 * Provides data fields and methods to create a Java data-type, representing a
 * server in a java application.
 *
 * @author Y. Attia
 * @author H. Muhamad
 * @author Y. Khalil
 * @version 1.0
 * @since April 4th, 2019
 */

public class ServerController {
	
	static PrintWriter out;
	Socket aSocket;
	ServerSocket serverSocket;
	static BufferedReader in;
	Shop theShop;
	private ExecutorService pool;
	Connection myConn;
	
	/**
	 * Constructs a Server with port 9898
	 * @throws SQLException 
	 */
	public ServerController()  {// Shop aShop) {
		try {
			serverSocket = new ServerSocket(9898);
			System.out.println("Server is running");
			myConn =DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "yossri", "student");
			pool = Executors.newCachedThreadPool();

		} catch (IOException e) {
			System.out.println("Creating new socket error");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Runs the Server
	 * 
	 * @throws IOException
	 */
	public void runServer() throws IOException {
	
		try {
			while (true) {
				aSocket = serverSocket.accept();
				this.theShop= new Shop(aSocket, myConn);
				pool.execute(theShop);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// shutdown the threadpool. in case of an error
			pool.shutdown();
			try {
				in.close();
				out.close();
				aSocket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	/**
	 * Starts running the Server
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		ServerController myServer = new ServerController();
		System.out.println("after accept");
		myServer.runServer();

	}
}
