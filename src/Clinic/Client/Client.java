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
        
        Doctor d = clientSecretary.getDoctorWithID(1, a); //this is bad, stop
        
        System.out.println(a);
        System.out.println(d.getFname());
        
    }
}
