package Clinic.Client.fxGUI.controllers;

import Clinic.Client.fxGUI.util.LabelList;
import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.Doctor;
import Util.Exceptions.IncorrectPayloadException;
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

    public void showAllDoctors(){
        try{
            ArrayList<Doctor> doctors = session.getClient().getDoctorAll(session.getToken());
            LabelList results = new LabelList(doctors,  new Doctor(null));
            mainbox.getChildren().add(results);
        }catch(IncorrectPayloadException ex){
            System.out.println("Payload machine broke");
        }

    }

    public void logout(ActionEvent e)
    {
        switchScene(doctorHomePage, "loginPage.fxml", loginController.class, session);
    }
}
