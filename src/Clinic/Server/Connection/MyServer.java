package Clinic.Server.Connection;

import Clinic.Core.Payload;

import java.io.IOException;
import java.util.Scanner;

public class MyServer extends AbstractServer  {
 
	public MyServer(int port)   { // Constructor
		super(port); 
	}
	
	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) throws InterruptedException {
        Payload payload = (Payload) msg;
        if(payload.getType() == 1) {
            try {
                client.sendToClient(new Payload(payload.getId(), 1, (Object) "Orange"));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

	} 
	
	//////////////////////////////////////////////////////////////////////////////////////////

	//TODO Re write main as constructor
	public static void main(String[] args)   {
		String msg;
		Scanner myObj = new Scanner(System.in);
		MyServer MyServer1 = new MyServer(6969); // will use port 8989
		System.out.println("MyServer: MyServer1 has been created.");
		try {
			MyServer1.listen();
			System.out.println("MyServer: Clinic.Server should now be running");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}
