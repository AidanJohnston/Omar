package Clinic.Server.Data;

import Clinic.Core.Doctor;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
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
}
