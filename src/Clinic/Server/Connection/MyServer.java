package Clinic.Server.Connection;

import Clinic.Core.Payload;
import Clinic.Server.ServerSecretary;

import java.io.IOException;
import java.util.Scanner;

public class MyServer extends AbstractServer  {

	private ServerSecretary serverSecretary;

	public MyServer(int port, ServerSecretary serverSecretary)   { // Constructor
		super(port);

		try {
			this.listen();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		this.serverSecretary = serverSecretary;
	}
	
	@Override
	protected void handleMessageFromClient(Object payload, ConnectionToClient client) {
		System.out.println("CLIENT SENT ME SOMETHING");
		serverSecretary.handleMessageFromClient((Payload) payload, client);
	}
}
