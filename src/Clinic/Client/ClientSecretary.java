package Clinic.Client;

import Clinic.Client.Connection.MyClient;
import Clinic.Client.GUI.MyGUI;
import Clinic.Core.Doctor;
import Util.*;
import Util.Exceptions.*;
import Clinic.Core.Payload;
import Clinic.Core.Token;
import Clinic.Core.User;
import Util.RequestType;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

//merge this test - Sean

/**
 * ClientSecretary.java - The client secretary stands as a mediator between the GUI and the connection to the server.
 * The secretary provides the business logic between the GUI and the connection to the server.  The GUI can invoke
 * specific functions and perform predetermined actions.
 *
 *
 *
 * @author Aidan Johnsotn
 * @version 1.0
 */
public class ClientSecretary {

    MyClient myClient;
    MyGUI myGUI;
    List<ClientTask> tasklist;
    int avaiableID;

    public ClientSecretary() {
        this.avaiableID = 0;
        tasklist = new ArrayList<ClientTask>();
    }

    public void setMyClient(MyClient myClient) {
        this.myClient = myClient;
    }

    public void setMyGUI(MyGUI myGUI) {
        this.myGUI = myGUI;
    }

    private ClientTask prepareTask(Payload payload) throws IncorrectPayloadException {
        ClientTask task = new ClientTask(payload);
        tasklist.add(task);
        task.start();

        myClient.sendMessageToServer(payload);

        try {
            task.join();
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Client: received response from server: ");
        System.out.println("Type: " + task.getPayload().getType());
        System.out.println("Ping: " +  task.getPayload().getPing() + "ms");
        if(task.getPayload().getType() == RequestType.ERROR) {
            throw new IncorrectPayloadException((String)task.getPayload().getObject());
        }
        return task;
    }

    public void handleMessageFromServer(Object payloadFromServer) {
        System.out.println("Received a Payload");
        Payload payload = (Payload) payloadFromServer;
        Boolean flag = false;
        int i = 0;
        for(i = 0; i < tasklist.size(); i++) {
            if(tasklist.get(i).getPayload().getId() == payload.getId()) {
                ClientTask task = tasklist.get(i);

                task.setReturnValue(payload.getObject());
                task.setFlag(true);
                tasklist.remove(i);
            }
        }

    }

    /**
     * Login interface between the GUI and client server.
     * @param username
     * @param password
     * @return will return a token that can be used for making other requests to the server
     * @throws IncorrectPayloadException
     */
    public Token login(String username, String password) throws IncorrectPayloadException {
        avaiableID++;
        try {
            Payload payload = new Payload(avaiableID, RequestType.LOGIN, new User(username, this.md5(username, password)));
            return (Token) prepareTask(payload).getReturnValue();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    //TODO TAKEN FROM INTERNET - WILL DO MYSELF AT SOME POINT -AIDAN
    public static String md5(String salt, String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        if (salt != null) {
            md.update(salt.getBytes());
        }
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return sb.toString();
    }

    /**
     * Logout interface between the GUI and the client server.  Returns true if logout was successful.
     * @param token
     * @return Boolean
     * @throws IncorrectPayloadException
     */
    public boolean logout(Token token) throws IncorrectPayloadException {
        avaiableID++;
        Payload payload = new Payload(avaiableID, RequestType.LOGOUT, token);

        return (boolean) prepareTask(payload).getReturnValue();
    }

    /**
     * Returns a list of all doctors
     * @param token
     * @return List<Doctor>
     * @throws IncorrectPayloadException
     */
    public List<Doctor> getDoctorAll(Token token) throws IncorrectPayloadException {
        avaiableID++;
        Payload payload = new Payload(avaiableID, RequestType.DOCTOR_GET_ALL, token);

        return (List<Doctor>) prepareTask(payload).getReturnValue();
    }

    /**
     * Returns a given doctor given a specific ID
     * @param id
     * @param token
     * @return Doctor
     * @throws IncorrectPayloadException
     */
    public ArrayList<Doctor> getDoctorWithID(int id, Token token) throws IncorrectPayloadException {
        avaiableID++;
        Payload payload = new Payload(avaiableID, RequestType.DOCTOR_GET_GIVEN_ID, id);

        return (ArrayList<Doctor>) prepareTask(payload).getReturnValue();
    }
}
