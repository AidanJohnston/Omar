package Clinic.Server;

import Clinic.Core.Doctor;
import Clinic.Server.Connection.MyServer;
import Util.RequestType;

import java.io.Serializable;

public class Server {

    public static void main(String args[]) throws InterruptedException {
        
        ServerSecretary serverSecretary = new ServerSecretary();
        System.out.print("Starting server");
        MyServer myServer = new MyServer(6969, serverSecretary);
        System.out.println("Server Started");
    }
}
