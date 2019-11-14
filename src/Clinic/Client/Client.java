package Clinic.Client;

import Clinic.Client.Connection.*;
import Clinic.Client.GUI.*;
import Util.*;
import Util.Exceptions.*;
import Clinic.Core.*;

public class Client {

    public static void main(String args[]) throws IncorrectPayloadException {
        ClientSecretary clientSecretary = new ClientSecretary();

        System.out.println("Attemping to connect to server.");
        MyClient myClient = new MyClient("172.17.11.181", 6969, clientSecretary);
        System.out.println("Successful :)");

        clientSecretary.setMyClient(myClient);

        Token a = clientSecretary.login("orange", "AIdan");

        //MyGUI gui = new MyGUI(clientSecretary, a);
    }
}
