package Clinic.Client;

import Clinic.Client.Connection.*;
import Clinic.Client.GUI.*;
import Util.*;
import Util.Exceptions.*;
import Clinic.Core.*;

import java.util.ArrayList;

@Deprecated
public class Client {

    public static void main(String args[]) throws ServerException {
        ClientSecretary clientSecretary = new ClientSecretary();

        MyClient myClient = new MyClient("localhost", 6969, clientSecretary);
        clientSecretary.setMyClient(myClient);
        Token a = clientSecretary.login("seans", "s");

        ArrayList<Patient> list = clientSecretary.getPatientAll(a);
        System.out.println(list);
    }
}
