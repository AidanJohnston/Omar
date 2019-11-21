package Clinic.Client.fxGUI;

import Clinic.Core.Doctor;
import Util.Exceptions.IncorrectPayloadException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
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
