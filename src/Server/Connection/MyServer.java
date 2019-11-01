package Server.Connection;

import java.io.IOException;
import java.util.Scanner;

public class MyServer extends AbstractServer  {
 
	public MyServer(int port)   { // Constructor
		super(port); 
	}
	
	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
			System.out.println(String.format("Client " + client.getName() + ": " + msg));
	} 
	
	//////////////////////////////////////////////////////////////////////////////////////////

	//TODO Re write main as constructor
	public static void main(String[] args)   {
		String msg;
		Scanner myObj = new Scanner(System.in);
		MyServer MyServer1 = new MyServer(8989); // will use port 8989
		System.out.println("MyServer: MyServer1 has been created.");
		try {
			MyServer1.listen();
			System.out.println("MyServer: Server should now be running");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true) {
			msg = myObj.nextLine();
			try {
				MyServer1.sendToAllClients(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	} 
}
