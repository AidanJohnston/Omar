package Clinic.Client.fxGUI;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class sampleController {
    public TextField passField;
    public TextField userField;
    public Label output;

    public void tryLogin(ActionEvent e){
        if(userField.getText().equalsIgnoreCase("sean") && passField.getText().equalsIgnoreCase("password")){
            output.setText("You did it!");
        }
        else{
            output.setText("Wrong :" + userField.getText() + " " + passField.getText());
        }
    }

    //public
}
