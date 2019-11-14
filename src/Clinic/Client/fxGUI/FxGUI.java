package Clinic.Client.fxGUI;

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
    public void start(Stage primaryStage) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Clinic UI");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();
        }catch(IOException e){
            System.out.println("GUI machine broke");
        }

    }
}
