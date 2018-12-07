/*
Name:Samarth Patel
Student Number: 200398207
*/
package Assignment2;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Samarth Patel
 */
public class CarObjectViewController implements Initializable {
    
    /**
     * This is an observable list that add a new car 
     */
    public static ObservableList<Car> recentAddedCars = FXCollections.observableArrayList();

    
    //this is instance variable for  button objet for add a new car
    @FXML private Button addNewCarButton;
    
    //this is instance variable label for car list 
    @FXML private Label carListLabel;
    
    //This instance variable is for table view object and different columns of table view
    @FXML private TableView<Car>tableView;
    @FXML private TableColumn<Car, String> manufacturerColumn;
    @FXML private TableColumn<Car, String> modelColumn;
    @FXML private TableColumn<Car, LocalDate> manufacturingDateColumn;
    @FXML private TableColumn<Car, Integer> maxSpeedColumn;
    @FXML private TableColumn<Car, String> carTypeColumn;
    //@FXML private TableColumn<Car, String> engineTypeColumn;
   
    //This method will change the scenes
     public void addANewCarButtonPushed(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CarCreator.fxml"));
        Parent carViewParent = loader.load();
         Scene carViewScene = new Scene(carViewParent);
        
        CarCreatorController controller = loader.getController();
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(carViewScene);
        window.show();
    }
     
     /**
     * Initializes the controller class.
     * This will run first when we run the project
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       manufacturerColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("manufacturer"));
       modelColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("model"));
       manufacturingDateColumn.setCellValueFactory(new PropertyValueFactory<Car, LocalDate>("manufactureDate"));
       maxSpeedColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("maxSpeed"));
       carTypeColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("carType"));
    
       //This will load dummy Data
       tableView.setItems(getCars());
          
    }  
    
    /**
     * This method will return the recentAddedCars list
     * @return 
     */
    public ObservableList<Car> getCars(){
        return recentAddedCars;
    }
    
    /**
     * This method will add new car to recentAddedCars list
     * @param newCar 
     */
    public void setNewCar(Car newCar){
        recentAddedCars.add(newCar);
    }
    
}
