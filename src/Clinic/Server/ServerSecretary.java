package Clinic.Server;

import Clinic.Core.*;
import Clinic.Server.Connection.ConnectionToClient;
import Clinic.Server.Connection.MyServer;
import Util.RequestType;
import Util.UserType;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

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
     private ServerDirector director;
     /**
      * Constructor for ServerSecretary, sets up the list of login tokens and the available ids
      */
     public ServerSecretary() {
          this.avaiableID = 0;
          clientTokens = new ArrayList<Token>();
          director = new ServerDirector();
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

          for(Token var : clientTokens) {
               if(var.getUserID() == token.getUserID())
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
          System.out.println("Type: " + payload.getType());
          System.out.println("Ping: " + payload.getPing() + "ms");

          //*/
          try {
               client.sendToClient(
                    new Payload(
                         payload.getId(), 
                         RequestType.SUCCESS, 
                         director
                              .getClass()
                              .getMethod(
                                        payload.getType(), 
                                        Object.class
                                   )
                              .invoke(
                                        director, 
                                        payload.getObject()
                                   )
                    )
               );
          }
          catch (Exception e) {
               try {
                    client.sendToClient(new Payload(payload.getId(), RequestType.ERROR, e));
               } catch (IOException e1) {
                    e1.printStackTrace();
               }
          }
          /*/
          if(payload.getType() == RequestType.LOGIN) {
               this.login(payload, client);
          }


          if (payload.getType() == RequestType.LOGOUT) {
               this.logout(payload, client);
          }

          if (payload.getType() == RequestType.DOCTOR_GET_GIVEN_ID) {



               this.getDoctorWithID(payload, client);
          }
          //*/
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
}
