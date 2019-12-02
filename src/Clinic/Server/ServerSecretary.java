package Clinic.Server;

import Clinic.Core.*;
import Clinic.Server.Connection.ConnectionToClient;
import Clinic.Server.Connection.MyServer;
import Util.Exceptions.*;
import Util.RequestType;
import Util.UserType;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
     private Token findToken(Token token) {
          try{
               return (clientTokens
                    .stream()
                    .filter(t -> t.getTokenID().equals(token.getTokenID()))
                    .collect(Collectors.toList())
                    .get(0));
          }catch(IndexOutOfBoundsException e){
               return null;
          }
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
          Object object = null;


          //Attempting to send back to the server
          
          try{
               if(!payload.getType().equals(RequestType.LOGIN)){
                    if(findToken(payload.getToken()) == null){
                        throw new  InvalidTokenException("Client session is not valid");
                    }
               }
               if(payload.getType().equals(RequestType.LOGOUT)){
                    clientTokens.remove(findToken(payload.getToken()));
               }else{
                    Method method = director.getClass().getMethod(payload.getType(), Object.class);
                    object = method.invoke(director, payload.getObject());

                    if(object.getClass() == Token.class){
                         clientTokens.add((Token)object);
                         //Sending message to client
                    }
               }
               
               client.sendToClient(
                    new Payload(
                         payload.getId(),
                         RequestType.SUCCESS,
                         object,
                         payload.getStartTime()));
               

               //This statement is here to calm the compiler, because we are using reflection it doesn't know what method that it is going to be run.
               //Because of this, it doesn't think that IncorrectPayload exception will be thrown, even thought every one of the ServerDirector methods throws IncorrectPayloadException
               if(false){
                    throw new IncorrectPayloadException("How did you get here");
               }
          }
          catch (InvocationTargetException e ) {
               if(e.getCause() instanceof ServerException){
                    try {
                         client.sendToClient(new Payload(payload.getId(), RequestType.ERROR, (ServerException)e.getCause(), payload.getStartTime()));
                    }
                    catch (IOException e1) {
                         e1.printStackTrace();
                    }
               }else{
                    e.printStackTrace();
               }
          }catch(Exception e){
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
                         client.sendToClient(new Payload(payload.getId(),RequestType.SUCCESS,"Successfully logged out."));
                    }
                    catch (IOException e) {
                         e.printStackTrace();
                    }
               }
          }
     }
}
