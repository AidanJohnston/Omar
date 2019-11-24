package Clinic.Server.Data;

import Clinic.Core.*;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class DataWriter {
    public void writeDoctors(ArrayList<Doctor> doctors) throws IllegalArgumentException, IllegalAccessException, IOException {
            FileOutputStream fout = new FileOutputStream("doctors.xml");
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(doctors);
    }
    public void writePatients(ArrayList<Patient> patients) throws IllegalArgumentException, IllegalAccessException, IOException {
        FileOutputStream fout = new FileOutputStream("patients.xml");
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(patients);
    }
    public void writeStaff(ArrayList<Staff> staff) throws IllegalArgumentException, IllegalAccessException, IOException {
        FileOutputStream fout = new FileOutputStream("patients.xml");
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(staff);
    }
}
