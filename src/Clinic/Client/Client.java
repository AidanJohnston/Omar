package Clinic.Client;

import Clinic.Client.Connection.*;
import Clinic.Client.GUI.*;
import Clinic.Server.Data.DataReader;
import Util.*;
import Util.Exceptions.*;
import Clinic.Core.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Deprecated
public class Client {

    public static void main(String args[]) throws Exception {
        ClientSecretary clientSecretary = new ClientSecretary();

        MyClient myClient = new MyClient("localhost", 6969, clientSecretary);
        clientSecretary.setMyClient(myClient);
        Token a = clientSecretary.login("seand", "d");

        ArrayList<Appointment> list = clientSecretary.getAppointmentsCurrentDoctor(a.getUserID(), a);
        System.out.println(list);
    }
}
