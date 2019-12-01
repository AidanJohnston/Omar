package Clinic.Server.Data;

import Clinic.Core.*;
import Util.UserType;

import java.util.ArrayList;

public class DataPopulate {
    public static void main(String args[]){
        popDoc();
        popCreds();
    }

    private static void popCreds(){
        ArrayList<Credentials> creds = new ArrayList<>();
        creds.add(new Credentials("sean", "p", 1, UserType.PATIENT));
        creds.add(new Credentials("sean", "d", 2, UserType.DOCTOR));
        creds.add(new Credentials("sean", "s", 3, UserType.STAFF));
    }

    private static void popDoc(){
        ArrayList<Doctor> list = new ArrayList<>();
        list.add(new Doctor("Aidan"));
        list.add(new Doctor("Sean"));
        list.add(new Doctor("Dawson"));
        list.add(new Doctor("John"));
        list.add(new Doctor("Mai"));
        DataWriter d = new DataWriter();
        //write some example info to the database xml
        try {
            d.writeDoctors(list);
        } catch (Exception e) {
            System.out.println("Writer broke");
        }
    }


}
