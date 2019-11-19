package Clinic.Server;

import Clinic.Core.*;
import Clinic.Server.Connection.ConnectionToClient;
import Clinic.Server.Connection.MyServer;
import Util.Exceptions.IncorrectPayloadException;
import Util.RequestType;
import Util.UserType;

import java.io.IOException;
import java.lang.reflect.Method;
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

          //Printing out about message relieved
          System.out.println("Handling Request from: " + client.getName());
          System.out.println("Type: " + payload.getType());
          System.out.println("Ping: " + payload.getPing() + "ms");
          Object object;


          //Attempting to send back to the server
          try{

               //Invoking when method takes no parma
               if(payload.getObject() == null) {
                    Method method = director.getClass().getMethod(payload.getType());
                    object = method.invoke(director);
               }
               //When method takes parma
               else {
                    Method method = director.getClass().getMethod(payload.getType(), payload.getObject().getClass());
                    object = method.invoke(director, payload.getObject());
               }
               //Sending message to client
               client.sendToClient(
                    new Payload(
                            payload.getId(),
                            RequestType.SUCCESS,
                            object,
                            payload.getStartTime()));

               //This statement is here to calm the compiler, because we are using reflection it doesn't know what method that it is going to be run.
               //Because of this, it doesn't think that IncorrectPayload exception will be thrown, even thought every one of the ServerDirector methods throws IncorrectPayloadException
               if(false){
                    throw new IncorrectPayloadException("You dumb fuck how did you get here");
               }
          }
          catch (IOException e) {
               e.printStackTrace();
          }
          catch (NoSuchMethodException e) {
               try {
                    client.sendToClient(new Payload(payload.getId(), RequestType.ERROR, "Unknown method name dumbass", payload.getStartTime()));
               }
               catch (IOException e1) {
                    e1.printStackTrace();
               }
          }
          catch (IncorrectPayloadException e ) {
               try {
                    client.sendToClient(new Payload(payload.getId(), RequestType.ERROR, e.getMessage(), payload.getStartTime()));
               }
               catch (IOException e1) {
                    e1.printStackTrace();
               }
          }
          catch (Exception e ) {
               e.printStackTrace();
          }
     }

     /**
      * Logs the user out from the server.  Returns an update confirmation to the client.
      * @param payload
      * @param client
      */
     @Deprecated
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
