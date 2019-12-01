package Clinic.Client.fxGUI.controllers;

import Clinic.Client.ClientSecretary;
import Clinic.Client.fxGUI.util.LabelList;
import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.Doctor;
import Util.Exceptions.IncorrectPayloadException;
import Util.Exceptions.ServerException;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class doctorHomePageController extends baseController {
    private String data;
    private Session session;

    public GridPane doctorHomePage;
    public VBox mainbox;

    public void initWithData(Session _session){
        session = _session;
        data = session.getDataObject().toString();
    }

    public void showAllDoctors() {
        try{
            ArrayList<Doctor> doctors = session.getClient().getDoctorAll(session.getToken());
            LabelList results = new LabelList(doctors,  new Doctor(null));
            mainbox.getChildren().add(results);
        }catch(ServerException ex){
            System.out.println("Payload machine broke");
        }

    }

    public void logout(ActionEvent e)
    {
        try{
            ClientSecretary client = session.getClient();
            client.logout(session.getToken());
        }
        catch(ServerException ex){
            System.out.println("Logout Failed, doing it anyways");
        }
        switchScene(doctorHomePage, "../pages/loginPage.fxml", loginController.class, session);
    }
}
