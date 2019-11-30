package Clinic.Server.Data;

import Clinic.Core.*;

import java.io.BufferedOutputStream;
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
    public void writeAppointments(ArrayList<Appointment> objs) throws IllegalArgumentException, IllegalAccessException, IOException {
        new PrintWriter(FileNames.APPOINTMENTS).close();
        FileOutputStream fout = new FileOutputStream(FileNames.APPOINTMENTS);
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(objs);
        oout.close();
    }

    public void writeDiagnoses(ArrayList<Diagnosis> objs) throws IllegalArgumentException, IllegalAccessException, IOException {
        new PrintWriter(FileNames.DIAGNOSES).close();
        FileOutputStream fout = new FileOutputStream(FileNames.DIAGNOSES);
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(objs);
        oout.close();
    }

    public void writeDoctors(ArrayList<Doctor> objs) throws IllegalArgumentException, IllegalAccessException, IOException {
        new PrintWriter(FileNames.DOCTORS).close();
        FileOutputStream fout = new FileOutputStream(FileNames.DOCTORS);
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(objs);
        oout.close();
    }

    public void writePatients(ArrayList<Patient> objs) throws IllegalArgumentException, IllegalAccessException, IOException {
        new PrintWriter(FileNames.PATIENTS).close();
        FileOutputStream fout = new FileOutputStream(FileNames.PATIENTS);
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(objs);
        oout.close();
    }

    public void writePrescriptions(ArrayList<Prescription> objs) throws IllegalArgumentException, IllegalAccessException, IOException {
        new PrintWriter(FileNames.PRESCRIPTIONS).close();
        FileOutputStream fout = new FileOutputStream(FileNames.PRESCRIPTIONS);
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(objs);
        oout.close();
    }

    public void writeSchedules(ArrayList<Schedule> objs) throws IllegalArgumentException, IllegalAccessException, IOException {
        new PrintWriter(FileNames.SCHEDULES).close();
        FileOutputStream fout = new FileOutputStream(FileNames.SCHEDULES);
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(objs);
        oout.close();
    }

    public void writeStaff(ArrayList<Staff> objs) throws IllegalArgumentException, IllegalAccessException, IOException {
        new PrintWriter(FileNames.APPOINTMENTS).close();
        FileOutputStream fout = new FileOutputStream("patients.txt");
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(objs);
        oout.close();
    }

    public void writeUsers(ArrayList<User> objs) throws IllegalArgumentException, IllegalAccessException, IOException {
        new PrintWriter(FileNames.USERS).close();
        FileOutputStream fout = new FileOutputStream(FileNames.USERS);
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(objs);
        oout.close();
    }
}
