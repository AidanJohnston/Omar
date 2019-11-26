package Clinic.Client.fxGUI.controllers;
import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.Token;
import Util.Exceptions.IncorrectPayloadException;
import Util.UserType;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Clinic.Client.ClientSecretary;


public class loginController extends baseController{
    public GridPane loginPage;
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

        switchScene(loginPage, "doctorHomePage.fxml", doctorHomePageController.class, null);

    }

    public void tryLogin(ActionEvent e){
        String user = userField.getText();
        String pass = passField.getText();
        if(userField.getText().equalsIgnoreCase("sean")){
            output.setText("You did it!");
            try{
                ClientSecretary client = session.getClient();
                Token token = client.login(user, pass);
                session.setToken(token);
            }catch(IncorrectPayloadException ex){
                System.out.print("Payload machine broke");
            }

            session.setDataObject("Logged in as " + userField.getText());
            if(session.getToken().getType() == UserType.DOCTOR){
                switchScene(loginPage, "doctorHomePage.fxml", doctorHomePageController.class, session);
            }
            if(session.getToken().getType() == UserType.PATIENT){
                switchScene(loginPage, "patientHomePage.fxml", patientHomePageController.class, session);
            }
        }
        else{
            output.setText("Wrong :" + userField.getText() + " " + passField.getText());
        }
    }

}
