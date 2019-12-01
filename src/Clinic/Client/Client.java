package Clinic.Client;

import Clinic.Client.Connection.*;
import Clinic.Client.GUI.*;
import Util.*;
import Util.Exceptions.*;
import Clinic.Core.*;
@Deprecated
public class Client {

    public static void main(String args[]) throws IncorrectPayloadException {
        ClientSecretary clientSecretary = new ClientSecretary();

        MyClient myClient = new MyClient("localhost", 6969, clientSecretary);
        clientSecretary.setMyClient(myClient);
        //Token a = clientSecretary.login("orange", "AIdan");

       //MyGUI gui = new MyGUI(clientSecretary, a);
    }
}
