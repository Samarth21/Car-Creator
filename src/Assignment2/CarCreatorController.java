/*
Name:Samarth Patel
Student Number: 200398207
*/
package Assignment2;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Samarth Patel
 */
public class CarCreatorController implements Initializable {

   //This is an instance variable for Manufacturer text field
    @FXML
    private TextField manufacturerTextField;
    
  /**
   * This is an Observable list that receive the data from the Object and saves it in addToTableView List
   */
    public static ObservableList<Car> addToTableView = FXCollections.observableArrayList();
    
    //This an variable for model text field
    @FXML
    private TextField modelTextField;
    
    //This is an instance variable for manufacturingdate DatePicker 
    @FXML
    private DatePicker manufacturingDateDatePicker;
    
   //This an instance variable for maximumSpeedSpinner 
    @FXML 
    private Spinner maximumSpeedSpinner;
  
    //This is an instance variable for Combo Box Object
    @FXML
    private ComboBox<String> carTypeComboBox;
    
    //This is instance variable for radiobutton example
    @FXML private RadioButton flatButton;
    @FXML private RadioButton veeButton;
    @FXML private RadioButton straightButton;
    @FXML private RadioButton ERWButton;
    @FXML private ToggleGroup engineTypeToggleGroup;
    
    //This is instance variable imageview example
    @FXML
    private ImageView imageView;
    
    //This instance variable for buttton of create car
    @FXML
    private Button createCarButton;
    
     //This instance variable for buttton of changeScreen
    @FXML
    private Button changeScreenButton;
    
    
    //this is for heading car creator
    @FXML
    private Label carCreator;
    
    //This is for error message label
    @FXML
    private Label errorMessage;
      
    /**
     * This method will change the image as we change the car type in combo box
     */
     public void carImageChanger()
    {
        String carty = carTypeComboBox.getValue().toString();
        if (carty.equalsIgnoreCase("Compact Car"))
            imageView.setImage(new Image("./images/Compact.png"));
        else if (carty.equalsIgnoreCase("Luxury Car"))
            imageView.setImage(new Image("./images/Luxury.png"));
        else if (carty.equalsIgnoreCase("Sports Car"))
            imageView.setImage(new Image("./images/Sport.png"));
        else if (carty.equalsIgnoreCase("SUV"))
            imageView.setImage(new Image("./images/SUV.png"));
        else
             imageView.setImage(new Image("./images/Truck.png"));
    }
     
     /**
      * This method will change the scene when we push the ListOf Cars Button
      * and the for loop will add the object to the table one after other
      * @param event
      * @throws IOException 
      */
     public void changeScreenButtonPushed(ActionEvent event) throws IOException
    {
         FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CarObjectView.fxml"));
        Parent listViewParent = loader.load();
         Scene listViewScene = new Scene(listViewParent);
        
         CarObjectViewController controller = loader.getController();
         for(int i=0; i<addToTableView.size(); i++)
             controller.setNewCar(addToTableView.get(i));
       
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(listViewScene);
        window.show();
    }
        
    /**
     * Initializes the controller class.
     * This will run first when we run the project
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        /**
         * This will configure spinner object 
         * The SpinnerValueFactory is the inbuilt model for spinner object 
         * without this the spinner object is without any use
         */
        SpinnerValueFactory<Integer> maxSpeedValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,400);
        this.maximumSpeedSpinner.setValueFactory(maxSpeedValue);
       // this.maximumSpeedSpinner.setEditable(true);
       
        
        /**
         * This will configure the combo box object
         * and adds Compact Car,Luxury Car, Sports Car, SUV, Standard Pickup Truck to it
         */
        carTypeComboBox.setPromptText("Select Type of Car");
        carTypeComboBox.getItems().addAll("Compact Car","Luxury Car","Sports Car","SUV","Standard Pickup Truck");
        
        /**
         *  This will configure the radio button object
         * the togge group will help us to select one radio button at a time 
         */
        engineTypeToggleGroup = new ToggleGroup();
        this.flatButton.setToggleGroup(engineTypeToggleGroup);
        this.veeButton.setToggleGroup(engineTypeToggleGroup);
        this.straightButton.setToggleGroup(engineTypeToggleGroup);
        this.ERWButton.setToggleGroup(engineTypeToggleGroup);
        
     //This is error message label the is setted empty
        this.errorMessage.setText("");
  
     }   
     
    /**
     *This method will try to get manufacturer, model, manufacturing date, maximum speed,
     * car type and create new car object if user enter the manufacturing date first
     * or it will catch exception and show it in error message label
     * the new created car object will get added to addToTableView list
     */
    @FXML
    public void createCarButtonPush()
    {
        if (this.manufacturingDateDatePicker.getValue() != null)
        {
            try{     
                Car newCar = new Car( 
                                        this.manufacturerTextField.getText(),
                                        this.modelTextField.getText(),
                                        this.manufacturingDateDatePicker.getValue(), 
                                         (Integer) maximumSpeedSpinner.getValue(),
                                        this.carTypeComboBox.getValue());
               
                addToTableView.add(newCar);
                
                
               this.errorMessage.setText("Added To List Of Cars Successfully !");
     }
    
    catch (IllegalArgumentException e)
            {
                this.errorMessage.setText(e.getMessage());
            }
        }
        else
        {
            this.errorMessage.setText("You need to set the Manufacturing Date First");
        }
        
    }
    
}

