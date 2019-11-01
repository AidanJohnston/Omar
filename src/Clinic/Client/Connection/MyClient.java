package Clinic.Client.Connection;

import Clinic.Client.ClientSecretary;
import java.io.IOException;

/**
 * MyClient.java - The MyClient class is used as the head of the connection between the client and the server.  My Clinic.Client
 * doesn't worry about the logic of the message it sends or receives.  When MyClient receives a message from the server
 * it hands it off the the client secretary to handle the processing of the message.
 *
 * @author Aidan Johnston
 * @version 1.0
 * @see AbstractClient
 */
public class MyClient extends AbstractClient {

	private ClientSecretary secretary;

	/**
	 * The constructor for MyClient.  The constructor will try to connect to the server.  If it fails the program wille
	 * exit.
	 * @param host Host address to try to connect to
	 * @param port Host port number
	 * @param secretary Reference to the clients secretary
	 */
	public MyClient(String host, int port, ClientSecretary secretary)
	  { 
	    super(host, port);
		this.secretary = secretary;

	    try {
	        this.openConnection();
	    }
	    catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR while attempting to open connection, exiting...");
            System.exit(1); // on error exit
        }
      }

	/**
	 * Handles messages received from the server, passes them off to the clients secretary
	 * @param msg   the message sent.
	 */
	@Override
	protected void handleMessageFromServer(Object msg) {
		this.secretary.handleMessageFromServer(msg);
	}

	/**
	 * MyClient received a message from the client secretary to try to sent to the server
	 * @param payload The message to send to the server
	 */
	public void sendMessageToServer(Object payload) {
		try {
			this.sendToServer(payload);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
    }
}
