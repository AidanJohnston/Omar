package Clinic.Server.Data;

import Clinic.Core.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class DataReader {
    public ArrayList<Doctor> readDoctors() throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
        ArrayList<Doctor> doctors = null;
        try {
            FileInputStream fout = new FileInputStream("doctors.xml");
            ObjectInputStream oout = new ObjectInputStream(fout);
            doctors = (ArrayList<Doctor>)oout.readObject();
        }catch (UnsupportedEncodingException e) {
                System.out.println("This VM does not support the Latin-1 character set.");
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        return doctors;
    }
    public ArrayList<Patient> readPatients() throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
        ArrayList<Patient> patients = null;
        try {
            FileInputStream fout = new FileInputStream("patients.xml");
            ObjectInputStream oout = new ObjectInputStream(fout);
            patients = (ArrayList<Patient>)oout.readObject();
        }catch (UnsupportedEncodingException e) {
                System.out.println("This VM does not support the Latin-1 character set.");
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        return patients;
    }
    public ArrayList<Staff> readStaff() throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
        ArrayList<Staff> staff = null;
        try {
            FileInputStream fout = new FileInputStream("staff.xml");
            ObjectInputStream oout = new ObjectInputStream(fout);
            staff = (ArrayList<Staff>)oout.readObject();
        }catch (UnsupportedEncodingException e) {
                System.out.println("This VM does not support the Latin-1 character set.");
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        return staff;
    }
}
