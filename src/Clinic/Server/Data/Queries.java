package Clinic.Server.Data;

import Clinic.Core.*;
import Util.UserType;
import Util.Exceptions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
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
            throw new AppointmentNotFoundException("No appointments were found for the given doctor");
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
            throw new AppointmentNotFoundException("No appointments were found for the given doctor");
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

    public ArrayList<Doctor> getDocByName(String name) throws DoctorNotFoundException{
        Predicate<Doctor> p1 = d -> d.getFName().contains(name);
        Predicate<Doctor> p2 = d ->d.getLName().contains(name);
        try{
            return new ArrayList<Doctor>(new DataReader()
                .readDoctors()
                .stream()
                .filter(p1.or(p2))
                .collect(Collectors.toList()));
        }catch(NullPointerException e){
            throw new DoctorNotFoundException("No Doctors were found with the given name");
        }
    }

    public ArrayList<Doctor> getDocByDate(LocalDate date) throws DoctorNotFoundException {
        Predicate<Appointment> p1 = a -> a.getDate().equals(date);
        try{
            return new ArrayList<Doctor>(new DataReader()
                .readAppointments()
                .stream()
                .filter(p1.negate())
                .map(a -> a.getDoctor())
                .collect(Collectors.toList()));
        }catch(NullPointerException e){
            throw new DoctorNotFoundException("No Doctors were found on the given date");
        }
    }

    public ArrayList<Patient> getPatByName(String name) throws PatientNotFoundException{
        Predicate<Patient> p1 = d -> d.getFName().contains(name);
        Predicate<Patient> p2 = d ->d.getLName().contains(name);
        try{
            return new ArrayList<Patient>(new DataReader()
                .readPatients()
                .stream()
                .filter(p1.or(p2))
                .collect(Collectors.toList()));
        }catch(NullPointerException e){
            throw new PatientNotFoundException("No Patients were found with the given name");
        }
    }

    public ArrayList<Staff> getStaByName(String name) throws StaffNotFoundException{
        Predicate<Staff> p1 = d -> d.getFName().contains(name);
        Predicate<Staff> p2 = d ->d.getLName().contains(name);
        try{
            return new ArrayList<Staff>(new DataReader()
                .readStaff()
                .stream()
                .filter(p1.or(p2))
                .collect(Collectors.toList()));
        }catch(NullPointerException e){
            throw new StaffNotFoundException("No Staff were found with the given name");
        }
    }
}