package Clinic.Server;

import Clinic.Core.*;
import Clinic.Server.Connection.MyServer;
import Util.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class ServerDirector {
    public Object login(Object params){
        UserType type = UserType.DOCTOR; // REPLACE WITH DATABASE LOOKUP
        int userID = 1;
        System.out.println("Login Params: " + params.toString());
        Token token = new Token(type, userID);

        Payload payload = new Payload(1, "login", token);
        
        return payload;
    }
    public Object logout(Object params){
        return null;
    }
    public Object diagnosisGetAllPatient(Object params){
        return null;
    }
    public Object diagnosisGetAllDoctor(Object params){
        return null;
    }
    public Object diagnosisUpdateGivenReference(Object params){
        return null;
    }
    public Object diagnosisCreateGivenReference(Object params){
        return null;
    }
    public Object diagnosisRemoveGivenReference(Object params){
        return null;
    }
    public Object doctorGetGivenPatient(Object params){
        return null;
    }
    public Object doctorGetAll(Object params){
        ArrayList<Doctor> doctorList = new ArrayList<>();

        doctorList.add(new Doctor("aidanJohnston[", "Aidan", "Johnston", LocalDate.of(1999, 12, 2), 420, "69 suck my ass street", 59, "807-630-3284", "Fucking bitches"));
        doctorList.add(new Doctor("aidanJohnston[", "Dawson", "Gilmore", LocalDate.of(2000, 3, 26), 420, "69 suck my ass street", 59, "807-630-3284", "Fucking bitches"));
        return new Payload(1, RequestType.SUCCESS, doctorList);
    }
    public Object doctorGetGivenId(Object params){
        return null;
    }
    public Object doctorUpdateGivenDoctor(Object params){
        return null;
    }
    public Object doctorCreateGivenDoctor(Object params){
        return null;
    }
    public Object doctorRequestGivenName(Object params){
        return null;
    }
    public Object doctorRequestGivenTime(Object params){
        return null;
    }
    public Object doctorRequestGivenDate(Object params){
        return null;
    }
    public Object doctorRemoveGivenDoctor(Object params){
        return null;
    }
    public Object patientGetAll(Object params){
        return null;
    }
}