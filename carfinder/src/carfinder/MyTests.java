package carfinder;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

public class MyTests {

        @Test
        public void sampleTest() {
            User user = new User();
            Customer customer = new Customer();
            Car car = new Car();
            LinkedList<Car> carList = new LinkedList<Car>();
            carList.add(car);

//			VALIDATION
//			Check entering empty input text areas
	        	assertEquals(false, user.setUsername(""));
	        	assertEquals(false, user.setPassword(""));
	        	assertEquals(false, user.setEmail(""));
	        	assertEquals(false, user.setName(""));
	        	assertEquals(false, user.setPhone(""));
	        	
	        	assertEquals(false, customer.setFeature1(""));
	        	assertEquals(false, customer.setFeature2(""));
	        	assertEquals(false, customer.setCarWanted(""));
	        	assertEquals(false, customer.setBudget(0)); //
	        	assertEquals(false, customer.setTransmission(""));

//			Check entering null/”cancel” buttons
                
//			Check entering alphabetic characters for numeric inputs
	        	
                
//			Check entering negative numbers for things like MPG, budget, etc.
	        	assertEquals(false, customer.setBudget(-2));
	        	assertEquals(false, car.setPrice(-3));
	        	assertEquals(false, car.setCapacity(-2));
	        	assertEquals(false, car.setYear("2016"));

                
//			Check email and phone number formats?
                
//			LOGIN
                
//			Test login in as admin and customer to make sure it takes you to the right screen
//			Failing a login should bring you back to initial menu
                
//			SAVING TO FILE
                
//			Check to make sure cars and users are saved to the respective files
                
//			SELECECTING A CAR
                
//			Check to make sure recommend cars are given when a match is found
                
//			Check to make sure the selected car is saved inside the customer object
                
//			EDITING A CAR
                
//			Check to make sure edits made to cars are updated correctly
	        	carfinder.CarFinderApp.editCar(carList);
                
        }
}
