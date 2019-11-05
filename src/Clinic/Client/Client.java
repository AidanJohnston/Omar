package Clinic.Client;

import Clinic.Client.Connection.MyClient;
import Util.IncorrectPayloadException;
import Clinic.Core.Doctor;
import Clinic.Core.Token;

public class Client {

    public static void main(String args[]) throws IncorrectPayloadException {
        ClientSecretary clientSecretary = new ClientSecretary();

        MyClient myClient = new MyClient("localhost", 6969, clientSecretary);
        clientSecretary.setMyClient(myClient);

            Token a = clientSecretary.login("orange", "AIdan");
        
        Doctor d = clientSecretary.getDoctorWithID(1, new Token(Doctor.class, 1)); //this is bad, stop
        System.out.println(a);
        System.out.println(d.getFname());
    }
}
