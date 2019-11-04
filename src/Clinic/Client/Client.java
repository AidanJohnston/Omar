package Clinic.Client;

import Clinic.Client.Connection.MyClient;

public class Client {

    public static void main(String args[]) throws InterruptedException {
        ClientSecretary clientSecretary = new ClientSecretary();

        MyClient myClient = new MyClient("localhost", 6969, clientSecretary);
        clientSecretary.setMyClient(myClient);

        String a = clientSecretary.login("orange", "AIdan");
        System.out.println(a);
    }
}
