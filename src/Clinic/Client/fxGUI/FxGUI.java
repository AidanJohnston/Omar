package Clinic.Client.fxGUI;

import Clinic.Client.ClientSecretary;
import Clinic.Client.Connection.MyClient;
import Clinic.Client.fxGUI.controllers.loginController;
import Clinic.Client.fxGUI.util.Session;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FxGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ClientSecretary clientSecretary = new ClientSecretary(); 

        MyClient myClient = new MyClient("localhost", 6969, clientSecretary);
        clientSecretary.setMyClient(myClient);


        try{
            Parent root = FXMLLoader.load(getClass().getResource("pages/loginPage.fxml"));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pages/loginPage.fxml"));
            primaryStage.setTitle("Clinic UI");
            primaryStage.setScene(new Scene(loader.load()));
            loginController controller = loader.<loginController>getController();
            controller.initWithData(new Session(null,clientSecretary, null));
            primaryStage.show();
        }catch(Exception e){
            System.out.println("GUI machine broke");
            throw new Exception("GUI MACHINE BROKE");
        }


    }
}
