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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//import sun.plugin.javascript.navig.Anchor;

import javax.swing.*;

public class mainPageController extends baseController {
    private String data;
    private Session session;

    public Label output;
    public VBox mainbox;

    public void initWithData(Session _session){
        session = _session;
        data = session.getDataObject().toString();
    }

    public void doOutput(ActionEvent e){
        output.setText(data);
    }

    public void showAllDoctors(){
        try{
            LabelList results = new LabelList(session.getClient().getDoctorAll(session.getToken()), new Doctor(null));
            mainbox.getChildren().add(results);
        }catch(IncorrectPayloadException ex){
            System.out.println("Payload machine broke");
        }

    }

    public void logout(ActionEvent e)
    {
        switchScene(output, "loginPage.fxml", loginController.class, session);

    }
}
