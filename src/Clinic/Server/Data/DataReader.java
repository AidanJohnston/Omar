package Clinic.Server.Data;

import Clinic.Core.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class DataReader {
    public ArrayList<Appointment> readAppointments() {
        ArrayList<Appointment> objs = null;
        try {
            FileInputStream fout = new FileInputStream(FileNames.APPOINTMENTS);
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<Appointment>)oout.readObject();
            oout.close();
        }catch (Exception e) {
            System.out.println("This VM does not support the Latin-1 character set.");
            System.out.println(e.getMessage());
        }
        return objs;
    }

    public ArrayList<Credentials> readCredentials() {
        ArrayList<Credentials> objs = null;
        try {
            FileInputStream fout = new FileInputStream(FileNames.CREDENTIALS);
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<Credentials>)oout.readObject();
            oout.close();
        }catch (Exception e) {
            System.out.println("This VM does not support the Latin-1 character set.");
            System.out.println(e.getMessage());
        }
        return objs;
    }

    public ArrayList<Doctor> readDoctors() {
        ArrayList<Doctor> objs = null;
        try {
            FileInputStream fout = new FileInputStream(FileNames.DOCTORS);
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<Doctor>)oout.readObject();
            oout.close();
        }catch (Exception e) {
            System.out.println("This VM does not support the Latin-1 character set.");
            System.out.println(e.getMessage());
        }
        return objs;
    }

    public ArrayList<Patient> readPatients() {
        ArrayList<Patient> objs = null;
        try {
            FileInputStream fout = new FileInputStream(FileNames.PATIENTS);
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<Patient>)oout.readObject();
            oout.close();
        }catch (Exception e) {
            System.out.println("This VM does not support the Latin-1 character set.");
            System.out.println(e.getMessage());
        }
        return objs;
    }

    public ArrayList<Staff> readStaff() {
        ArrayList<Staff> objs = null;
        try {
            FileInputStream fout = new FileInputStream(FileNames.STAFF);
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<Staff>)oout.readObject();
            oout.close();
        }catch (Exception e) {
            System.out.println("This VM does not support the Latin-1 character set.");
            System.out.println(e.getMessage());
        }
        return objs;
    }

    //THIS ONE SHOULDNT ACTUALLY BE USED, BUT ITS HERE JUST IN CASE
    public ArrayList<User> readUser() {
        ArrayList<User> objs = null;
        try {
            FileInputStream fout = new FileInputStream(FileNames.USERS);
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<User>)oout.readObject();
            oout.close();
        }catch (Exception e) {
            System.out.println("This VM does not support the Latin-1 character set.");
            System.out.println(e.getMessage());
        }
        return objs;
    }
}
