package Clinic.Server;

import Clinic.Server.Connection.MyServer;

import java.io.Serializable;

public class Server {

    public static void main(String args[]) {
        ServerSecretary serverSecretary = new ServerSecretary();
        MyServer myServer = new MyServer(6969, serverSecretary);
    }
}
