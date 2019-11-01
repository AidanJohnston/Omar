package Clinic.Client;

import Clinic.Client.Connection.MyClient;

public class Client {

    public static void main(String args[]) {
        ClientSecretary clientSecretary = new ClientSecretary();

        MyClient myClient = new MyClient("localhost", 6969, clientSecretary);
        clientSecretary.setMyClient(myClient);


    }
}
