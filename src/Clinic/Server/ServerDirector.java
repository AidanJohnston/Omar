package Clinic.Server;

import Clinic.Core.*;
import Util.*;
import java.util.ArrayList;

public class ServerDirector {
    /*  This should stay dead, but just in case everything goes wrong and we need to do this  
    public Method login(){
        return this.getClass().getEnclosingMethod();
    }
    //*/
    public Token login(User user){
        UserType type = UserType.DOCTOR; // REPLACE WITH DATABASE LOOKUP
        int userID = 1;
        System.out.println("Login Params: " + user.toString());
        Token token = new Token(type, userID);

        return token;
    }
    public Object logout(Object params){
        return null;
    }
    public Object createAppointment(Object params) {return null;}
    public Object getAllSchedule(Object params) {return null;}
    public Object getScheduleOfDoctor(Object params) {return null;}
    public Object getCurrentAppointmentOfPatient(Object params) {return null;}
    public Object getAllAppointmentOfPatient(Object params) {return null;}
    public Object getAllDoctor() {

        ArrayList<Doctor> list = new ArrayList<>();
        list.add(new Doctor("Aidan"));
        list.add(new Doctor("Sean"));
        list.add(new Doctor("Dawson"));
        list.add(new Doctor("John"));
        list.add(new Doctor("Mai"));

        return list;
    }
    public Object getDoctorWithId(Object params) {return null;}
    public Object setDoctor(Object params) {return null;}
    public Object getAllDiagnosisFromPatient(Object params) {return null;}
    public Object getAllPrescriptionFromPatient(Object params) {return null;}
    public Object setSchedule(Object params) {return null;}
    public Object getCurrentAppointmentDoctor(Object params) {return null;}
    public Object getAllPatient(Object params) {return null;}
}