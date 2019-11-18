package Clinic.Server.Data;

import Clinic.Core.Doctor;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class DataWriter {
    public void writeDoctors(ArrayList<Doctor> doctors){
        try{
            OutputStream fout= new FileOutputStream("doctors.xml"); 
            OutputStream bout= new BufferedOutputStream(fout); 
            OutputStreamWriter outfile = new OutputStreamWriter(bout, "8859_1");
            outfile.write("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\r\n");
            
            outfile.flush();
            outfile.close();
            }catch (UnsupportedEncodingException e) {
                System.out.println("This VM does not support the Latin-1 character set.");
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        
    }
}
