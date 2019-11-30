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
            FileInputStream fout = new FileInputStream(FileNames.APPOINTMENTS);
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<Appointment>)oout.readObject();
            oout.close();
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
            FileInputStream fout = new FileInputStream(FileNames.DIAGNOSES);
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<Diagnosis>)oout.readObject();
            oout.close();
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
            FileInputStream fout = new FileInputStream(FileNames.DOCTORS);
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<Doctor>)oout.readObject();
            oout.close();
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
            FileInputStream fout = new FileInputStream(FileNames.PATIENTS);
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<Patient>)oout.readObject();
            oout.close();
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
            FileInputStream fout = new FileInputStream(FileNames.PRESCRIPTIONS);
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<Prescription>)oout.readObject();
            oout.close();
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
            FileInputStream fout = new FileInputStream(FileNames.SCHEDULES);
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<Schedule>)oout.readObject();
            oout.close();
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
            FileInputStream fout = new FileInputStream(FileNames.STAFF);
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<Staff>)oout.readObject();
            oout.close();
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
            FileInputStream fout = new FileInputStream(FileNames.USERS);
            ObjectInputStream oout = new ObjectInputStream(fout);
            objs = (ArrayList<User>)oout.readObject();
            oout.close();
        }catch (UnsupportedEncodingException e) {
                System.out.println("This VM does not support the Latin-1 character set.");
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        return objs;
    }
}
