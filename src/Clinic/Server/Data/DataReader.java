package Clinic.Server.Data;

import Clinic.Core.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class DataReader {
    public ArrayList<Appointment> readAppointments() throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
        ArrayList<Appointment> objs = null;
        try {
            FileInputStream fout = new FileInputStream("appointments.xml");
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<Appointment>)oout.readObject();
        }catch (UnsupportedEncodingException e) {
                System.out.println("This VM does not support the Latin-1 character set.");
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        return objs;
    }

    public ArrayList<Diagnosis> readDiagnoses() throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
        ArrayList<Diagnosis> objs = null;
        try {
            FileInputStream fout = new FileInputStream("diagnoses.xml");
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<Diagnosis>)oout.readObject();
        }catch (UnsupportedEncodingException e) {
                System.out.println("This VM does not support the Latin-1 character set.");
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        return objs;
    }

    public ArrayList<Doctor> readDoctors() throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
        ArrayList<Doctor> objs = null;
        try {
            FileInputStream fout = new FileInputStream("doctors.xml");
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<Doctor>)oout.readObject();
        }catch (UnsupportedEncodingException e) {
                System.out.println("This VM does not support the Latin-1 character set.");
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        return objs;
    }

    public ArrayList<Patient> readPatients() throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
        ArrayList<Patient> objs = null;
        try {
            FileInputStream fout = new FileInputStream("patients.xml");
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<Patient>)oout.readObject();
        }catch (UnsupportedEncodingException e) {
                System.out.println("This VM does not support the Latin-1 character set.");
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        return objs;
    }
    
    public ArrayList<Prescription> readPrescription() throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
        ArrayList<Prescription> objs = null;
        try {
            FileInputStream fout = new FileInputStream("prescriptions.xml");
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<Prescription>)oout.readObject();
        }catch (UnsupportedEncodingException e) {
                System.out.println("This VM does not support the Latin-1 character set.");
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        return objs;
    }

    public ArrayList<Schedule> readSchedule() throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
        ArrayList<Schedule> objs = null;
        try {
            FileInputStream fout = new FileInputStream("schedules.xml");
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<Schedule>)oout.readObject();
        }catch (UnsupportedEncodingException e) {
                System.out.println("This VM does not support the Latin-1 character set.");
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        return objs;
    }

    public ArrayList<Staff> readStaff() throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
        ArrayList<Staff> objs = null;
        try {
            FileInputStream fout = new FileInputStream("staff.xml");
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<Staff>)oout.readObject();
        }catch (UnsupportedEncodingException e) {
                System.out.println("This VM does not support the Latin-1 character set.");
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        return objs;
    }

    //THIS ONE SHOULDNT ACTUALLY BE USED, BUT ITS HERE JUST IN CASE
    public ArrayList<User> readUser() throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
        ArrayList<User> objs = null;
        try {
            FileInputStream fout = new FileInputStream("users.xml");
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<User>)oout.readObject();
        }catch (UnsupportedEncodingException e) {
                System.out.println("This VM does not support the Latin-1 character set.");
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        return objs;
    }
}
