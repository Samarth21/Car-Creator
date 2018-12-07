package Assignment2;

/*
Name:Samarth Patel
Student Number: 200398207
*/

import Assignment2.Car;
import java.time.LocalDate;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Samarth Patel
 */
public class CarTest {
    
    Car validCar;
    public CarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        validCar = new Car("Audi","R8", LocalDate.of(2012, Month.SEPTEMBER, 10),330, "Sports Car");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getManufacturer method, of class Car.
     * That validates that first letter of manufacturer is in upper case
     * when the expected result is same as result in validCar variable
     */
    @Test
    public void testGetManufacturer() {
        String expResult ="Audi";
        String result = validCar.getManufacturer();
        assertEquals(expResult, result);
    }

    /**
     * Test of setManufacturer method, of class Car.
     * setManufacturer method have validation that first letter is in upper case
     * so in this test method string value that we pass in have first letter in upper case so this test will pass
     */
    @Test
    public void testSetManufacturer() {
        validCar.setManufacturer("Dodge");
        String result = validCar.getManufacturer();
        assertEquals("Dodge",result);   
    }
    
    /**
     * This method has try and catch block 
     * in try block sam causes exception and catch block shows the exception
     */

    @Test
    public void testSetManufacturerInvalid() {
        
        try{
            validCar.setManufacturer("sam");
            fail("The first letter must be in upper case should have triggered an exception");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
    }
    /**
     * Test of getModel method, of class Car.
     * That validates that model is empty
     * when the expected result is same as result in validCar variable
     */
    @Test
    public void testGetModel() {
        String expResult = "R8";
        String result = validCar.getModel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setModel method, of class Car.
     * setModel method has validation that it is not empty
     * And here we have a string value so this test will pass
     */
    @Test
    public void testSetModel() {
        validCar.setModel("Charger");
        assertEquals("Charger", validCar.getModel());
    }
    
    /**
     * This method has try and catch block 
     * in try block model variable is empty that causes exception and catch block catches the exception
     */
    
    @Test
    public void testSetModeInvalid()
    {
        String model = "";
        try{
            validCar.setModel(model);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
    }

   /**
     * Test of getManufacturerDate method, of class Car.
     * when the expected result is same as result in validCar variable
     */
    @Test
    public void testGetManufactureDate() {
        LocalDate expResult = LocalDate.of(2012, Month.SEPTEMBER, 10);
        LocalDate result = validCar.getManufactureDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setManufactureDate method, of class Car.
     * the set method validates that manufacture date is not in future
     * in this test variable manufactureDate is in past so this test will pass
     */
    @Test
    public void testSetManufactureDate() {
      LocalDate manufactureDate = LocalDate.of(2000, Month.DECEMBER, 1);
        validCar.setManufactureDate(manufactureDate);
        assertEquals(manufactureDate, validCar.getManufactureDate());
    } 
    
     /**
     * This method has try and catch block 
     * in try block manufactureDate variable has future date that causes exception and catch block catches the exception
     */
    @Test
     public void testSetManufactureDateInvalid()
    {
        LocalDate manufactureDate = LocalDate.of(2021, Month.APRIL, 1);       
        try{
            validCar.setManufactureDate(manufactureDate);
            fail("A Manufacture date in the future should have triggered an exception");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
    }
    /**
     * Test of getMaxSpeed method, of class Car.
     * when the expected result is same as result in validCar variable the test will pass
     */
     
    @Test
    public void testGetMaxSpeed() {
        int expResult = 330;
        int result = validCar.getMaxSpeed();
        assertEquals(expResult, result);
    }
    /**
     * Test of setMaxSpeed method, of class Car.
     * setMaxSpeed() method validates that its value is greater than 0 and less than 400
     * in this test 400 is valid values so this test will pass
     */
    @Test
    public void testSetMaxSpeed() {
        validCar.setMaxSpeed(400);
       assertEquals(400,validCar.getMaxSpeed());
      }
    
     /**
     * This method has try and catch block 
     * in try block maxSpeed variable has a negative value that causes exception and catch block catches the exception
     */
     @Test
    public void testSetMaxSpeedInvalid()
    {
        int maxSpeed = -1;
        try{
            validCar.setMaxSpeed(maxSpeed);
            fail("Max Speed must be greater than 0");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
    }
    
     /**
     * This method has try and catch block 
     * in try block maxSpeed variable has value greater than 400 that causes exception and catch block catches the exception
     */
    
    @Test
    public void testSetMaxSpeed2Invalid()
    {
        int maxSpeed = 5000;
        try{
            validCar.setMaxSpeed(maxSpeed);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
    }

    /**
     * Test of getCarType method, of class Car.
     */
    @Test
    public void testGetCarType() {
       
        String expResult = "Sports Car";
        String result = validCar.getCarType();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setCarType method, of class Car.
     */
    @Test
    public void testSetCarTypeCompactCar() {
        String result = "Compact Car";
        validCar.setCarType("Compact Car");
        assertEquals(result, validCar.getCarType());
    }
    
    @Test
    public void testSetCarTypeLuxuryCar() {
        String result = "Luxury Car";
        validCar.setCarType("Luxury Car");
        assertEquals(result, validCar.getCarType());
    }
        
    @Test
    public void testSetCarTypeSportsCar() {
        String result = "Sports Car";
        validCar.setCarType("Sports Car");
        assertEquals(result, validCar.getCarType());
    }
    
    @Test
    public void testSetCarTypeSUV() {
        String result = "SUV";
        validCar.setCarType("SUV");
        assertEquals(result, validCar.getCarType());
    }

     @Test
    public void testSetCarTypeStandardPickupTruck() {
        String result = "Standard Pickup Truck";
        validCar.setCarType("Standard Pickup Truck");
        assertEquals(result, validCar.getCarType());
    }

     @Test
    public void testSetCarTypenvalid()
    {
        String cartype = "Sam Car";
        try{
            validCar.setCarType(cartype);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
    }
    
}