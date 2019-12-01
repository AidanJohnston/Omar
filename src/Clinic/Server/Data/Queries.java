package Clinic.Server.Data;

import Clinic.Core.*;
import Util.UserType;
import Util.Exceptions.LoginFailedException;

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

    public ArrayList<Appointment> getAppsPatient(int p){
        return new ArrayList<Appointment>(new DataReader()
            .readAppointments()
            .stream()
            .filter(a -> a.getPatientID() == p)
            .collect(Collectors.toList()));
    }

    public ArrayList<Appointment> getFutureAppsPatient(int p){
        return new ArrayList<Appointment>(new DataReader()
            .readAppointments()
            .stream()
            .filter(a -> a.getPatientID() == p)
            .filter(a -> a.getDate().isAfter(LocalDate.now()))
            .collect(Collectors.toList()));
    }

    public ArrayList<Appointment> getFutureAppsDoctor(int d){
        return new ArrayList<Appointment>(new DataReader()
            .readAppointments()
            .stream()
            .filter(a -> a.getDoctorID() == d)
            .filter(a -> a.getDate().isAfter(LocalDate.now()))
            .collect(Collectors.toList()));
    }
}