package Clinic.Client.fxGUI.controllers;
import Clinic.Client.fxGUI.util.Session;
import Clinic.Core.Token;
import Util.Exceptions.IncorrectPayloadException;
import Util.Exceptions.LoginFailedException;
import Util.Exceptions.ServerException;
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

            try{
                ClientSecretary client = session.getClient();
                Token token = client.login(user, pass);
                session.setToken(token);

                session.setDataObject("Logged in as " + userField.getText());
                if(session.getToken().getType().equals(UserType.DOCTOR)){
                    switchScene(loginPage, "../pages/doctorHomePage.fxml", doctorHomePageController.class, session);
                }
                if(session.getToken().getType().equals(UserType.PATIENT)){
                    switchScene(loginPage, "../pages/patientHomePage.fxml", patientHomePageController.class, session);
                }
                if(session.getToken().getType().equals(UserType.STAFF)){
                    switchScene(loginPage, "../pages/staffHomePage.fxml", staffHomePageController.class, session);
                }

            }
            catch(LoginFailedException ex){
                System.out.println("Login Failed");
                output.setText("Login Failed");
            }
            catch(ServerException ex) {
                System.out.println("Server machine broke");
            }


        }
    }