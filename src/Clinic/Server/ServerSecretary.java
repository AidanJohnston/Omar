package Clinic.Server;

import Clinic.Core.*;
import Clinic.Server.Connection.ConnectionToClient;
import Clinic.Server.Connection.MyServer;
import Util.RequestType;
import Util.UserType;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * ServerSecretary.java - This class handles the requests from clients, such as finding information, removing information
 * or updating information from the database.
 *
 * @author Aidan Johnston
 * @version 1.0
 */
public class ServerSecretary {

     private List<Token> clientTokens;
     private MyServer myServer;
     private int avaiableID;

     /**
      * Constructor for ServerSecretary, sets up the list of login tokens and the available ids
      */
     public ServerSecretary() {
          this.avaiableID = 0;
          clientTokens = new ArrayList<Token>();
     }

     /**
      * Returns the instance of myServer the secretary is currently using
      * @return myServer
      */
     public MyServer getMyServer() {
          return myServer;
     }

     /**
      * Sets an instance of myServer
      * @param myServer
      */
     public void setMyServer(MyServer myServer) {
          this.myServer = myServer;
     }

     /**
      * Looks through the list clientTokens and tries to find one with the same ID.  If one is found it returns true.
      * If none is found false is returned.
      * @param token
      * @return boolean
      */
     private boolean findToken(Token token) {
          boolean flag = false;

          for(int i = 0; i < clientTokens.size(); i++) {
               if(clientTokens.get(i).getUserID() == token.getUserID())
                    flag = true;
          }
          return flag;
     }

     /**
      * Information passed from myServer when message from client is triggered.  Messages are first checked to ensure that
      * the user is currently logged in, then it filters it down into its message type and performs the task.
      * @param payload
      * @param client
      */
     public void handleMessageFromClient(Payload payload, ConnectionToClient client) {


          System.out.println("Handling Request from: " + client.getName());


          if(payload.getType() == RequestType.LOGIN) {
               System.out.println("LOGIN TRIGGERED");
               this.login(payload, client);
          }

          else if(findToken(payload.getToken())) {

               if (payload.getType() == RequestType.LOGOUT) {
                    this.logout(payload, client);
               }

               if (payload.getType() == RequestType.DOCTOR_GET_GIVEN_ID) {
                    this.getDoctorWithID(payload, client);
               }

          }
     }

     /**
      * Adds the user to the list of logged in users.  If it can not find the user sends an error to the client.
      * @param payload
      * @param client
      */
     private void login(Payload payload, ConnectionToClient client) {
          //TODO - CONNECT TO DATABASE AND CONFIRM LOGIN
          //TODO - GET TYPE OF USER


          //THIS IS WRONG, USING AS PLACE HOLDER, ASSUMING LOGIN WAS SUCCESSFUL
          UserType type = UserType.DOCTOR; // REPLACE WITH DATABASE LOOKUP
          int userID = 1;

          Token token = new Token(type, userID);
          clientTokens.add(token);

          payload.setObject(token);

          System.out.println("ID is " + payload.getId());
          try {
               System.out.println("SEND TO CLIENT TIRGGERED");
               client.sendToClient(payload);
          }
          catch (IOException e) {
               e.printStackTrace();
          }
     }

     /**
      * Logs the user out from the server.  Returns an update confirmation to the client.
      * @param payload
      * @param client
      */
     private void logout(Payload payload, ConnectionToClient client) {
          for (int i = 0; i < clientTokens.size(); i++) {
               if(clientTokens.get(i).getUserID() == payload.getToken().getUserID()) {
                    clientTokens.remove(i);
                    try {
                         client.sendToClient(new Payload(payload.getId(),RequestType.LOGOUT,"Successfully logged out."));
                    }
                    catch (IOException e) {
                         e.printStackTrace();
                    }
               }
          }
     }

     private void getDoctorWithID(Payload payload, ConnectionToClient client) {
          if(findToken(payload.getToken())) {
               List<Doctor> doctorList = new ArrayList<>();
               doctorList.add(new Doctor("aidanJohnston[", "Aidan", "Johnston", LocalDate.of(1999, 69, 420), 420, "69 suck my ass street", 59, "807-630-3284", "Fucking bitches"));
               doctorList.add(new Doctor("aidanJohnston[", "Aidan", "Johnston", LocalDate.of(1999, 69, 420), 420, "69 suck my ass street", 59, "807-630-3284", "Fucking bitches"));
               doctorList.add(new Doctor("aidanJohnston[", "Aidan", "Johnston", LocalDate.of(1999, 69, 420), 420, "69 suck my ass street", 59, "807-630-3284", "Fucking bitches"));
               doctorList.add(new Doctor("aidanJohnston[", "Aidan", "Johnston", LocalDate.of(1999, 69, 420), 420, "69 suck my ass street", 59, "807-630-3284", "Fucking bitches"));
               doctorList.add(new Doctor("aidanJohnston[", "Aidan", "Johnston", LocalDate.of(1999, 69, 420), 420, "69 suck my ass street", 59, "807-630-3284", "Fucking bitches"));
               doctorList.add(new Doctor("aidanJohnston[", "Aidan", "Johnston", LocalDate.of(1999, 69, 420), 420, "69 suck my ass street", 59, "807-630-3284", "Fucking bitches"));
               doctorList.add(new Doctor("aidanJohnston[", "Aidan", "Johnston", LocalDate.of(1999, 69, 420), 420, "69 suck my ass street", 59, "807-630-3284", "Fucking bitches"));
               payload.setObject(doctorList);
          }
          else {
               payload.setType(RequestType.ERROR);
               payload.setObject("You are not logged in dumbass");
          }

          try {
               client.sendToClient(payload);
          }
          catch (IOException e) {
               e.printStackTrace();

          }
     }
}
