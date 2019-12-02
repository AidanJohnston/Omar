package Clinic.Server.Data;

import Clinic.Core.*;
import Util.UserType;
import Util.Exceptions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Queries {
    public Credentials login(Credentials creds) throws LoginFailedException{
        try{
            Credentials match = new DataReader()
                .readCredentials()
                .stream()
                .filter(c -> c.getUsername().equals(creds.getUsername()))
                .filter(c -> c.getHashword().equals(creds.getHashword()))
                .collect(Collectors.toList())
                .get(0);
            return match;
        }catch(IndexOutOfBoundsException e){
            throw new LoginFailedException("Username or Password incorrect");
        }
    }

    public ArrayList<Appointment> getAppsPatient(Patient p) throws AppointmentNotFoundException {
        try{
            return new ArrayList<Appointment>(new DataReader()
                .readAppointments()
                .stream()
                .filter(a -> a.getPatientID() == p.getID())
                .collect(Collectors.toList()));
        }catch(NullPointerException e){
            throw new AppointmentNotFoundException("No appointments were found for the given patient");
        }
    }

    public ArrayList<Appointment> getFutureAppsPatient(Patient p) throws AppointmentNotFoundException {
        try{
            return new ArrayList<Appointment>(new DataReader()
                .readAppointments()
                .stream()
                .filter(a -> a.getPatientID() == p.getID())
                .filter(a -> a.getDate().isAfter(LocalDate.now()))
                .collect(Collectors.toList()));
        }catch(NullPointerException e){
            throw new AppointmentNotFoundException("No appointments were found for the given patient");
        }
    }

    public ArrayList<Appointment> getAppsDoctor(Doctor d) throws AppointmentNotFoundException {
        try{
            return new ArrayList<Appointment>(new DataReader()
                .readAppointments()
                .stream()
                .filter(a -> a.getDoctorID() == d.getID())
                .collect(Collectors.toList()));
        }catch(NullPointerException e){
            throw new AppointmentNotFoundException("No appointments were found for the given patient");
        }
    }

    public ArrayList<Appointment> getFutureAppsDoctor(Doctor d) throws AppointmentNotFoundException {
        try{
            return new ArrayList<Appointment>(new DataReader()
                .readAppointments()
                .stream()
                .filter(a -> a.getDoctorID() == d.getID())
                .filter(a -> a.getDate().isAfter(LocalDate.now()))
                .collect(Collectors.toList()));
        }catch(NullPointerException e){
            throw new AppointmentNotFoundException("No appointments were found for the given patient");
        }
    }

    public Doctor getDoctorByID(Doctor doc) throws DoctorNotFoundException {
        try{
            Doctor match = new DataReader()
                .readDoctors()
                .stream()
                .filter(d -> d.getID() == doc.getID())
                .collect(Collectors.toList())
                .get(0);
            return match;
        }
        catch(IndexOutOfBoundsException e){
            throw new DoctorNotFoundException("Doctor not found");
        }
    }

    public Patient getPatientByID(Patient pat) throws PatientNotFoundException {
        try{
            Patient match = new DataReader()
                .readPatients()
                .stream()
                .filter(p -> p.getID() == pat.getID())
                .collect(Collectors.toList())
                .get(0);
            return match;
        }catch(IndexOutOfBoundsException e){
            throw new PatientNotFoundException("Patient Not Found");
        }
    }

    public ArrayList<Prescription> getPrescriptions(Patient p) throws AppointmentNotFoundException {
        return new ArrayList<Prescription>(getAppsPatient(p)
            .stream()
            .map(a -> a.getPrescription())
            .collect(Collectors.toList()));
    }

    public ArrayList<Diagnosis> getDiagnoses(Patient p) throws AppointmentNotFoundException {
        return new ArrayList<Diagnosis>(getAppsPatient(p)
            .stream()
            .map(a -> a.getDiagnosis())
            .collect(Collectors.toList()));
    }
}