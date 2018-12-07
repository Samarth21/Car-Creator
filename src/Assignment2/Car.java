/*
Name:Samarth Patel
Student Number: 200398207
*/
package Assignment2;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Samarth Patel
 */
public class Car {
     /**
     * This is the instance variable for manufacturer, model, manufactureDate and maxSpeed.
     */
    private String manufacturer;
    private String model;
    private LocalDate manufactureDate;
    private int maxSpeed;
    private String carType;
    
    
    /**
     * This is the constructor for car class
     * The name of constructor is same as name of class
     * @param manufacturer
     * @param model
     * @param manufactureDate
     * @param maxSpeed 
     */

    public Car(String manufacturer, String model, LocalDate manufactureDate, int maxSpeed, String carType) {
        setManufacturer(manufacturer);
        setModel(model);
        setManufactureDate(manufactureDate);
        setMaxSpeed(maxSpeed);
        setCarType(carType);
     
    }

    /**
     * This is the get and set method for manufacturer name 
     * with the validation that name of manufacturer start with upper case letter 
     * @return 
     */
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        if(manufacturer.matches("[A-Z][a-z]*"))
           this.manufacturer = manufacturer;
        else
            throw new IllegalArgumentException("The first letter of manufacturer must be upper case");
    }
    
    /**
     * This is the get and set method  for model of car
     * with the validation that it is not empty
     * @return 
     */

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if(!model.isEmpty())
           this.model = model;
        else
            throw new IllegalArgumentException("The model cannot be empty");
    }
 
    /**
     * This is the get and set method for manufacturer date of car 
     * with the validation that it will not be in future
     * @return 
     */
    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
         if(manufactureDate.isBefore(LocalDate.now()))
            this.manufactureDate = manufactureDate;
         else
             throw new IllegalArgumentException("The manufacturer date cannot be in future");
    }

    /**
     * This is the get and set method for max speed of car
     * with the validation that it will more than 0 and less than 400
     * @return 
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        if(maxSpeed > 0 && maxSpeed <= 400)
           this.maxSpeed = maxSpeed;
        else 
            throw new IllegalArgumentException("The max speed must be greater than 0 kmph and less than 400 kmph");
    }

    /**
     * This is the get and set for car type 
     * the set method validates that car type must be
     * Compact car, luxury car, sports car, SUV, Standard Pickup Truck
     * @return 
     */
    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        if(carType == "Compact Car" || carType == "Luxury Car" || carType == "Sports Car" || carType == "SUV" || carType == "Standard Pickup Truck")
           this.carType = carType;
        else
            throw new IllegalArgumentException("The Car Type must be Compact Car or Luxury Car or Sports Car or SUV or Standard Pickup Truck");
    }
   
}
