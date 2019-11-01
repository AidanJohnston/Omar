package Clinic.Client;

import Clinic.Client.Connection.MyClient;
import Clinic.Client.GUI.MyGUI;
import Clinic.Core.Payload;

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

    public MyClient getMyClient() {
        return myClient;
    }

    public void setMyClient(MyClient myClient) {
        this.myClient = myClient;
    }

    public MyGUI getMyGUI() {
        return myGUI;
    }

    public void setMyGUI(MyGUI myGUI) {
        this.myGUI = myGUI;
    }

    /**
     * Test fucntion, given a persons ID, return their name.
     * @return String - Name
     */
    public String requestName(int id) throws InterruptedException {
        avaiableID++;
        Payload payload = new Payload(avaiableID, 1, (Object) id);

        ClientTask task = new ClientTask(payload);
        tasklist.add(task);
        task.start();

        myClient.sendMessageToServer(payload);

        task.join();

        return (String) task.getReturnValue();

    }

    public void handleMessageFromServer(Object payloadFromServer) {
        Payload payload = (Payload) payloadFromServer;
        Boolean flag = false;
        int i = 0;
        for(i = 0; i < tasklist.size(); i++) {
            if(tasklist.get(i).getPaylaod().getId() == payload.getId()) {
                ClientTask task = tasklist.get(i);

                task.setReturnValue(payload.getObject());
                task.setFlag(true);
                tasklist.remove(i);
            }
        }

    }
}
