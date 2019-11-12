package Clinic.Server;

import Clinic.Core.Doctor;
import Clinic.Server.Connection.MyServer;
import Util.RequestType;

import java.io.Serializable;

public class Server {

    public static void main(String args[]) {
        ServerDirector fuckyousean = new ServerDirector();
        for(String s : RequestType.ALL_PATHS){
            try{
                fuckyousean.getClass().getMethod(s, Object.class);
            }catch(Exception e){
                System.out.println("SEAN AND/OR AIDAN CHANGED MY CODE AND DIDNT DO IT RIGHT");
                System.exit(69);
            }
        }
        
        ServerSecretary serverSecretary = new ServerSecretary();
        MyServer myServer = new MyServer(42069, serverSecretary);
        
    }
}
