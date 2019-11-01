package Clinic.Client;

import Clinic.Client.Connection.MyClient;
import Clinic.Client.GUI.MyGUI;
import Clinic.Payload;

public class ClientSecretary {

    MyClient myClient;
    MyGUI myGUI;

    public ClientSecretary() {
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

    public void handleMessageFromServer(Object payloadFromServer) {
        Payload payload = (Payload) payloadFromServer;
    }
}
