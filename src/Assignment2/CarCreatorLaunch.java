/*
Name:Samarth Patel
Student Number: 200398207
*/
package Assignment2;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Samarth Patel
 */
public class CarCreatorLaunch extends Application{

    public static void main(String[] args) {
      launch(args); 
    }
    
        @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CarCreator.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Create Car");
        primaryStage.setScene(scene);
        primaryStage.show();
    }   
    
}
