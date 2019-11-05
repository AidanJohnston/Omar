package Clinic.Client;

import Clinic.Client.Connection.MyClient;
import Util.IncorrectPayloadException;
import Util.UserType;
import Clinic.Core.Doctor;
import Clinic.Core.Token;

public class Client {

    public static void main(String args[]) throws IncorrectPayloadException {
        ClientSecretary clientSecretary = new ClientSecretary();

        MyClient myClient = new MyClient("192.168.1.16", 6969, clientSecretary);
        clientSecretary.setMyClient(myClient);

        Token a = clientSecretary.login("orange", "AIdan");
        
        System.out.println(a.getUserID());
        
        System.out.println(a);
    }
}
