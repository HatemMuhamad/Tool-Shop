package ShopClient.ClientController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


import ShopClient.view.mainGui;

/**
 * Provides data fields and methods to create a client in a java application
 *
 * @author Y. Attia
 * @author H. Muhamad
 * @author Y. Khalil
 * @version 1.0
 * @since April 4th, 2019
 */

public class ClientController {
	private PrintWriter out;
	private BufferedReader in;
	private Socket aSocket;
	private GUIController guicontroller;
	

	/**
	 * Constructs a Client object with the specified server name and port number.
	 * The values of the data fields are supplied by the given parameters:
	 * 
	 * @param serverName is the name of the Server
	 * @param portNumber is the number of the port used
	 */
	public ClientController(String serverName, int portNumber) {
		try {
			aSocket = new Socket(serverName, portNumber);
			in = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			out = new PrintWriter(aSocket.getOutputStream(), true);
			//this.logincontroller = new loginController(new loginGui(),out);
			this.guicontroller = new GUIController(new mainGui(), out);

		} catch (IOException e) {
			System.err.println("error in client");
		}

	}

	/**
	 * Communicates with server, sending user input to server
	 */
	public void communicateWithServer() {
		String response = "";
		 guicontroller.setVisible();
		try {
			while (true) {

				response = in.readLine();
				
				if (response.equals("quit")) {
					break;
				}
					else if (response.startsWith("0"))
						guicontroller.showMessage(response.substring(1, response.length()).replace('\0', '\n'));
					else {
						guicontroller.printOnTextArea(response.replace("\0", "\n"));
					}
					response = "";

			}

		} catch (

		IOException e) {

			e.printStackTrace();
		}
		try {

			out.close();
			in.close();
			aSocket.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	

	/**
	 * Run Client.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ClientController aClient = new ClientController("localhost", 9898);
		aClient.communicateWithServer();
	}
}