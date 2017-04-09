package carfinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class CarFinderApp {
	public static void main(String [] args){
		
		LinkedList<User> users = new LinkedList<>();
		LinkedList<Car> cars = new LinkedList<>();
		cacheUsers(users); //Loads customers and admins from text file to the users linked list
		cacheCars(cars); //Loads cars from the text file to user links
		JOptionPane.showMessageDialog(null, "Welcome to Car Finder"); // Splash screen
		User loggedUser = login(users); //Credential check for users
		menuDirector(loggedUser); 
		
	}

	public static User login(LinkedList<User> users) {
		String username="";
		String password="";
		do{
			username = JOptionPane.showInputDialog(null, "Username:");
			if(username.equals("")){
				JOptionPane.showMessageDialog(null, "Invalid username.");
			}
		}while(username.equals(""));
		
		do{
			password = JOptionPane.showInputDialog(null, "Password:");
			if(password.equals("")){
				JOptionPane.showMessageDialog(null, "Invalid password.");
			}
		}while(username.equals(""));
		
		User loggedUser = new User();
		loggedUser = checkCredentials(username, password, users);
		if(loggedUser.getName()==null){
	        String[] choices = {"Register", "Login", "Quit"};
            int response = JOptionPane.showOptionDialog(
                    null                       	// Center in window.
                  , "User not found."        	// Message
                  , "Car Finder"               	// Title in titlebar
                  , JOptionPane.YES_NO_OPTION  	// Option type
                  , JOptionPane.PLAIN_MESSAGE  	// messageType
                  , null                       	// Icon (none)
                  , choices                    	// Button text as above.
                  , "Register"    				// Default button's label
                );
            	if(response == 0){
            		register(users);
            	}
            	else if(response == 1){
            		login(users);
            	}
            	else{
            		System.exit(0);
            	}
            }
	
		return loggedUser;
		
	}
	
	private static void register(LinkedList<User> users) {
		// TODO Auto-generated method stub
		
	}

	private static User checkCredentials(String username, String password, LinkedList<User> users) {
		User user = new User();
		 for(int x=0; x<users.size(); x++){
			if(username.equals(users.get(x).getUsername()) && password.equals(users.get(x).getPassword())){
			}
		}
		 return user;
	}

	public static void menuDirector(User user) {
		if(user instanceof Admin){
			adminMenu(user);
		}
		else{
			customerMenu(user);
		}	
	}

	private static void customerMenu(User user) {
		// TODO Auto-generated method stub
		
	}

	private static void adminMenu(User user) {
		// TODO Auto-generated method stub
		
	}

	public static void cacheCars(LinkedList<Car> cars) {
 		try{
		    Scanner input = new Scanner(new File("src/carfinder/cars.txt"));
		    input.useDelimiter(",");
	
		    while(input.hasNext()) {
		    	String id = input.next();
		    	String year = input.next();
		    	String make = input.next();
		    	String model = input.next();
		    	String color = input.next();
		    	String type = input.next();
		    	String mpg = input.next();
		    	String feature1 = input.next();
		    	String feature2 = input.next();
		    	String transmission = input.next();
		    	String interior = input.next();
		    	String carPackage = input.next();
		    	int capacity =  Integer.parseInt(input.next());
		    	double price = Double.parseDouble(input.next());
		    	
		        cars.add(new Car(id, year, make, model, color, 
		        		type, mpg, feature1, feature2, transmission, interior, carPackage, capacity, price));
		    }
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	public static void cacheUsers(LinkedList<User> users) {
 		try{
		    Scanner input = new Scanner(new File("src/carfinder/customers.txt"));
		    input.useDelimiter(",");
	
		    while(input.hasNext()) { 
			    	String username = input.next();
			    	String password = input.next();
			    	String name = input.next();
			    	String phone = input.next();
			    	String email = input.next();
			    	String feature1 = input.next();
			    	String feature2 = input.next();
			    	String carWanted = input.next();
			    	double mpg = Double.parseDouble(input.next());
			    	double budget = Double.parseDouble(input.next());
			    	int numSeats = Integer.parseInt(input.next());
			    	boolean navigation = input.nextBoolean();
			    	String interior = input.next();  
			    	String transmission = input.next();
			    	//Car Object Variables
			    	String id = input.next();
			    	String year = input.next();
			    	String make = input.next();
			    	String model = input.next();
			    	String color = input.next();
			    	String ctype = input.next();
			    	String cmpg = input.next();
			    	String cfeature1 = input.next();
			    	String cfeature2 = input.next();
			    	String ctransmission = input.next();
			    	String cinterior = input.next();
			    	String carPackage = input.next();
			    	int capacity = input.nextInt();
			        double price = Double.valueOf(input.next().substring(1));
			        
			        users.add(new Customer(username, password, name, phone, email, 
			        		feature1, feature2, carWanted, budget, mpg, numSeats, 
			        		navigation, interior, transmission, new Car(id, year, make, model, color, 
			        		ctype, cmpg, cfeature1, cfeature2, ctransmission, cinterior, carPackage, capacity, price)));
		    }
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
 			
 		try{
		    Scanner input = new Scanner(new File("src/carfinder/admins.txt"));
		    input.useDelimiter(",");
	
		    while(input.hasNext()) {
		    	String username = input.next();
		    	String password = input.next();
		    	String name = input.next();
		    	String phone = input.next();
		    	String email = input.next();
		    	
		        users.add(new Admin(username, password, name, phone, email));
		    }
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
