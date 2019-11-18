package Clinic.Client.fxGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class loginController extends baseController{
    public AnchorPane loginPage;
    public TextField passField;
    public TextField userField;
    public Label output;

    private Stage stage;
    private Parent root;
    private Session session;

    public void initWithData(Session _session){
        session = _session;
    }

    public void switchScene(ActionEvent e){

        switchScene(loginPage, "mainpage.fxml", mainPageController.class, null);

    }

    public void tryLogin(ActionEvent e){
        if(userField.getText().equalsIgnoreCase("sean") && passField.getText().equalsIgnoreCase("password")){
            output.setText("You did it!");
            session.setDataObject("Logged in as " + userField.getText());
            switchScene(loginPage, "mainpage.fxml", mainPageController.class, session);
        }
        else{
            output.setText("Wrong :" + userField.getText() + " " + passField.getText());
        }
    }

}
