package Clinic.Server;

import Clinic.Core.Doctor;
import Clinic.Core.Patient;
import Clinic.Core.Payload;
import Clinic.Core.Token;
import Clinic.Server.Connection.ConnectionToClient;
import Clinic.Server.Connection.MyServer;
import Util.RequestType;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class ServerSecretary {
     private List<Token> clientTokens;
     private MyServer myServer;
     private int avaiableID;
     public ServerSecretary() {
          this.avaiableID = 0;
     }

     public MyServer getMyServer() {
          return myServer;
     }

     public void setMyServer(MyServer myServer) {
          this.myServer = myServer;
     }

     public void handleMessageFromClient(Payload payload, ConnectionToClient client) throws IOException {

          //LOGIN

          if (payload.getType() == RequestType.LOGIN) {
               this.login(payload,client);
          }

          if(payload.getType() == RequestType.LOGOUT) {
              this.logout(payload, client);
          }

          if(payload.getType() == RequestType.DOCTOR_GET_GIVEN_ID)
               client.sendToClient(new Payload(payload.getId(), payload.getType(), new Doctor("AIdan")));
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
          Type type = payload.getClass();
          int userID = 1;


          Token token = new Token(type, userID);
          clientTokens.add(token);

          payload.setObject(token);
          try {
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
}
