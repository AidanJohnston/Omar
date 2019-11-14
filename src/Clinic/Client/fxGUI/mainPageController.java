package Clinic.Client.fxGUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;

public class mainPageController extends baseController {
    public String data;
    public Label output;
    public <T extends Object> void initWithData(T input){
        data = input.toString();
    }

    public void doOutput(ActionEvent e){
        output.setText(data);

    }

    public void logout(ActionEvent e){
        switchScene(output, "loginPage.fxml", loginController.class, null);
    }
}
