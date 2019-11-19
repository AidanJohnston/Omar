package Clinic.Server.Data;

import Clinic.Core.Doctor;

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
    private String writeTag(String tagName, String value) {
        return "<" + tagName + ">" + value + "</" + tagName + ">\r\n";
    }

    private String indent(int i) {
        String s = "";
        for (int x = 0; x < i; x++) {
            s += "\t";
        }
        return s;
    }

    public void writeDoctors(ArrayList<Doctor> doctors) throws IllegalArgumentException, IllegalAccessException {
        try {
            FileOutputStream fout = new FileOutputStream("doctors.xml");
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(doctors);
        }catch (UnsupportedEncodingException e) {
                System.out.println("This VM does not support the Latin-1 character set.");
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        
    }
}
