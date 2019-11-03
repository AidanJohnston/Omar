package Clinic.Client;

import Clinic.Client.Connection.MyClient;
import Clinic.Client.GUI.MyGUI;
import Clinic.Core.Payload;
import Clinic.Core.User;

import java.util.ArrayList;
import java.util.List;

/**
 * ClientSecretary.java - The client secretary stands as a mediator between the GUI and the connection to the server.
 * The secretary provides the business logic between the GUI and the connection to the server.  The GUI can invoke
 * specific functions and perform predetermined actions.
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

    private ClientTask prepareTask(Payload payload) throws InterruptedException {
        ClientTask task = new ClientTask(payload);
        tasklist.add(task);
        task.start();

        myClient.sendMessageToServer(payload);

        task.join();
        return task;
    }

    public void handleMessageFromServer(Object payloadFromServer) {
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
     * @return will return the user data for the
     */
    public String login(String username, String password) throws InterruptedException {
        avaiableID++;
        Payload payload = new Payload(avaiableID, 1, new User(username, password));

        return (String) prepareTask(payload).getReturnValue();
    }

    /**
     * Logout interface between the GUI and the client server.  Returns true if logout was successful.
     * @param token
     * @return Boolean
     * @throws InterruptedException
     */
    public boolean logout(String token) throws InterruptedException {
        avaiableID++;
        Payload payload = new Payload(avaiableID, 2, new User(token));

        return (boolean) prepareTask(payload).getReturnValue();
    }

}
