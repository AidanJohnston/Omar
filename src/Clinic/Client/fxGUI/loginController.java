package Clinic.Client.fxGUI;
import Clinic.Core.Token;
import Util.Exceptions.IncorrectPayloadException;
import com.sun.xml.internal.fastinfoset.tools.FI_SAX_XML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Clinic.Client.ClientSecretary;

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
        String user = userField.getText();
        String pass = passField.getText();
        if(userField.getText().equalsIgnoreCase("sean") && passField.getText().equalsIgnoreCase("password")){
            output.setText("You did it!");
            try{
                //session.setToken(session.getClient().login(user, pass));
                ClientSecretary client = session.getClient();
                Token token = client.login(user, pass);
                session.setToken(token);
            }catch(IncorrectPayloadException ex){
                System.out.print("Payload machine broke");
            }

            session.setDataObject("Logged in as " + userField.getText());
            switchScene(loginPage, "mainpage.fxml", mainPageController.class, session);
        }
        else{
            output.setText("Wrong :" + userField.getText() + " " + passField.getText());
        }
    }

}
