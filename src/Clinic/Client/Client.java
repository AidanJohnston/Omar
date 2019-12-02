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

        ArrayList<Appointment> list = clientSecretary.getAppointmentsDoctorAll(a, a.getUserID());
        System.out.println("break");
        clientSecretary.makeAppointment(a,new Appointment(
            new DataReader().readPatients().get(1), 
            new DataReader().readDoctors().get(1), 
            LocalDate.of(2018, 12, 2), 
            "13:30", 
            new Diagnosis(
                "Sick", 
                LocalDate.of(2018, 12, 2), 
                "You are sick"), 
            new Prescription(
                "Drug", 
                LocalDate.of(2018, 12, 2), 
                "Cures being sick", 
                "Take once an hour")));
        list = clientSecretary.getAppointmentsDoctorAll(a, a.getUserID());
        System.out.println("break");
    }
}
