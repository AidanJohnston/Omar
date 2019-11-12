package Clinic.Server;

import Clinic.Core.Doctor;
import Clinic.Server.Connection.MyServer;
import Util.RequestType;

import java.io.Serializable;

public class Server {

    public static void main(String args[]) {
        ServerSecretary serverSecretary = new ServerSecretary();
        System.out.println("Starting server...");
        MyServer myServer = new MyServer(6969, serverSecretary);
    }
}
