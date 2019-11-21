package Clinic.Server;

import Clinic.Core.Doctor;
import Clinic.Server.Connection.MyServer;
import Util.RequestType;

import java.io.Serializable;

public class Server {

    public static void main(String args[]) throws InterruptedException {
        ServerSecretary serverSecretary = new ServerSecretary();
        System.out.print("Starting server");
        Thread.sleep((int)(Math.random()*1500) + 500);
        System.out.print(".");
        Thread.sleep((int)(Math.random()*1500) + 500);
        System.out.print(".");
        Thread.sleep((int)(Math.random()*1500) + 500);
        System.out.print(".\n");
        Thread.sleep((int)(Math.random()*1500) + 500);
        MyServer myServer = new MyServer(6969, serverSecretary);
        System.out.println("Server Started");
    }
}
