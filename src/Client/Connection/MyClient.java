package Client.Connection;

import java.io.IOException;
import java.util.Scanner;

public class MyClient extends AbstractClient {

	public MyClient(String host, int port)
	  { 
	    super(host, port); 
	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		System.out.println(String.format("Server: " + msg));
	}

	//TODO Redo main as constructor
	public static void main(String[] args) throws IOException   {
		MyClient Client1 = new MyClient("localhost", 8989);
		String s;
		Scanner myObj = new Scanner(System.in);
		try {
			Client1.openConnection();
		} catch (IOException e1) { 
			e1.printStackTrace();
			System.out.println("ERROR while attempting to open connection, exiting...");
			System.exit(1); // on error exit
		}
		while(true) {
			try {
				s = myObj.nextLine();
				Client1.sendToServer(s);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	    
	} 
}
