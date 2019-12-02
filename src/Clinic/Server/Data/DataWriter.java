package Clinic.Server.Data;

import Clinic.Core.*;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class DataWriter {
    public void writeAppointments(ArrayList<Appointment> objs) {
        try {
            new PrintWriter(FileNames.APPOINTMENTS).close();
            FileOutputStream fout = new FileOutputStream(FileNames.APPOINTMENTS);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(objs);
            oout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeCredentials(ArrayList<Credentials> objs) {
        try {
            new PrintWriter(FileNames.CREDENTIALS).close();
            FileOutputStream fout = new FileOutputStream(FileNames.CREDENTIALS);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(objs);
            oout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public void writeDiagnoses(ArrayList<Diagnosis> objs) {
        try {
            new PrintWriter(FileNames.DIAGNOSES).close();
            FileOutputStream fout = new FileOutputStream(FileNames.DIAGNOSES);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(objs);
            oout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeDoctors(ArrayList<Doctor> objs) {
        try {
            new PrintWriter(FileNames.DOCTORS).close();
            FileOutputStream fout = new FileOutputStream(FileNames.DOCTORS);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(objs);
            oout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writePatients(ArrayList<Patient> objs) {
        try {
            new PrintWriter(FileNames.PATIENTS).close();
            FileOutputStream fout = new FileOutputStream(FileNames.PATIENTS);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(objs);
            oout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public void writePrescriptions(ArrayList<Prescription> objs) {
        try {
            new PrintWriter(FileNames.PRESCRIPTIONS).close();
            FileOutputStream fout = new FileOutputStream(FileNames.PRESCRIPTIONS);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(objs);
            oout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeStaff(ArrayList<Staff> objs) {
        try {
            new PrintWriter(FileNames.APPOINTMENTS).close();
            FileOutputStream fout = new FileOutputStream("patients.txt");
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(objs);
            oout.close();
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public void writeUsers(ArrayList<User> objs) {
        try {
            new PrintWriter(FileNames.USERS).close();
            FileOutputStream fout = new FileOutputStream(FileNames.USERS);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(objs);
            oout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
