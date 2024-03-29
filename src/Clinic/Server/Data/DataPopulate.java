package Clinic.Server.Data;

import Clinic.Core.*;
import Clinic.Server.ServerDirector;
import Util.UserType;
import Util.Exceptions.IncorrectPayloadException;
import Util.Exceptions.LoginFailedException;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class DataPopulate {
    public static void main(String args[]) throws LoginFailedException, IncorrectPayloadException {
        //ArrayList<Patient> pats = new DataReader().readPatients();
        //ArrayList<Doctor> docs = new DataReader().readDoctors();

        popDoc();
        popCreds();
        popPatient();
        popStaff();
        popAppointment();
    }

    private static void popCreds() {
        ArrayList<Credentials> creds = new ArrayList<>();

        creds.add(new Credentials("seanp", "p", 1, UserType.PATIENT));
        creds.add(new Credentials("seand", "d", 2, UserType.DOCTOR));
        creds.add(new Credentials("seans", "s", 3, UserType.STAFF));
        DataWriter d = new DataWriter();
        try {
            d.writeCredentials(creds);
        } catch (Exception e) {
            System.out.println("Writer broke");
        }
    }

    private static void popDoc() {
        ArrayList<Doctor> list = new ArrayList<>();

        list.add(new Doctor("Aidan", "Johnston", LocalDate.of(1999, 5, 27), 420, "25 Street rd.", 129, "8076303284", "Surgery", "Head Doctor", LocalTime.of(9, 0), LocalTime.of(5, 0)));
        list.add(new Doctor("Sean", "Dunlop", LocalDate.of(1999, 7, 23), 403, "658 Boulevard street", 2, "87630483", "Pharmacist", "Second Doctor", LocalTime.of(9, 0), LocalTime.of(5, 0)));

        DataWriter d = new DataWriter();
        // write some example info to the database xml
        try {
            d.writeDoctors(list);
        } catch (Exception e) {
            System.out.println("Writer broke");
        }
    }

    private static void popPatient() throws IncorrectPayloadException {
        ArrayList<Patient> list = new ArrayList<>();

        list.add(new Patient("Dawson", "Aevo", LocalDate.of(2000, 3, 26 ), 696969, "420 oh heck yeah Street", 14, "80-7259803", 2525, LocalDate.of(2020, 1, 12), "ON"));
        list.add(new Patient("Aidan", "Johnston", LocalDate.of(1999, 5, 25), 2525, "Hey there this is an adress",  52352, "607-2343", 242, LocalDate.of(2020, 12, 23), "ON"));

        DataWriter d = new DataWriter();
        //write some example info to the database xml
        try {
            d.writePatients(list);
        } catch (Exception e) {
            System.out.println("Writer broke");
        }
        //new ServerDirector().createPatient(new Patient("Aidan", "Johnston", new Date(1999, 5, 25), 2525, "Hey there this is an adress",  52352, "607-2343", 242, new Date(2020, 12, 23), "ON"));
        
    }

    private static  void popStaff() {
        ArrayList<Staff> list = new ArrayList<>();

        list.add(new Staff("Rebeka", "Dismo", LocalDate.of(1954, 1, 14), 130, "43 first street", 123, "807-2415235"));
        new DataWriter().writeStaff(list);
    }


    private static void popAppointment() {
        ArrayList<Appointment> list = new ArrayList<>();

        list.add(new Appointment(new DataReader().readPatients().get(0), new DataReader().readDoctors().get(0), LocalDate.of(2020, 12, 2), "05:02", new Diagnosis(), new Prescription()));
        list.add(new Appointment(new DataReader().readPatients().get(1), new DataReader().readDoctors().get(1), LocalDate.of(2018, 12, 2), "13:30", new Diagnosis("Sick", LocalDate.of(2018, 12, 2), "You are sick"), new Prescription("Drug", LocalDate.of(2018, 12, 2), "Cures being sick", "Take once an hour")));

        DataWriter d = new DataWriter();
        //write some example info to the database xml
        try {
            d.writeAppointments(list);
        } catch (Exception e) {
            System.out.println("Writer broke");
        }
    }
}
