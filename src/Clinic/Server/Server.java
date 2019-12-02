package Clinic.Server;

import Clinic.Core.Appointment;
import Clinic.Core.Doctor;
import Clinic.Server.Connection.MyServer;
import Clinic.Server.Data.Queries;
import Util.RequestType;
import Util.Exceptions.AppointmentNotFoundException;

import java.io.Serializable;
import java.util.ArrayList;

public class Server {

    public static void main(String args[]) throws InterruptedException, AppointmentNotFoundException {
        //ArrayList<Appointment> list = new Queries().getFutureAppsDoctor(new Doctor(2));
        ServerSecretary serverSecretary = new ServerSecretary();
        System.out.print("Starting server\n");
        MyServer myServer = new MyServer(6969, serverSecretary);
        System.out.println("Server Started");
    }
}
