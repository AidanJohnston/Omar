package Clinic.Server;

import Clinic.Core.*;
import Clinic.Server.Connection.MyServer;
import Util.*;


import java.io.Serializable;
import java.util.ArrayList;

public class ServerDirector {
    public Object update(Object params){
        return null;
    }
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
    public Object error(Object params){
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
        return null;
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