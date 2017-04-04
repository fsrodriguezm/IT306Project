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
		cacheUsers(users);
		//add a cacheCars() method
		JOptionPane.showMessageDialog(null, users.peek());
//		login(usersAr);
//		menu(usersAr);
// Test
		
	}

	private static void cacheUsers(LinkedList<User> users) {
 		try{
		    Scanner input = new Scanner(new File("src/carfinder/users.txt"));
		    input.useDelimiter(",");
	
		    while(input.hasNext()) {
		    	String type = input.next();
		    	if(type.equals("admin")){
			    	String username = input.next();
			    	String password = input.next();
			    	String name = input.next();
			    	String phone = input.next();
			    	String email = input.next();
			    	
			        users.add(new Admin(type, username, password, name, phone, email));
		    	}
		    	else{
			    	String username = input.next();
			    	String password = input.next();
			    	String name = input.next();
			    	String phone = input.next();
			    	String email = input.next();
			    	String currentCar = input.next();
			    	String feature1 = input.next();
			    	String feature2 = input.next();
			    	String carWanted = input.next();
			    	double budget = input.nextDouble();
			    	double mileage = input.nextDouble(); //Intended to be miles per gallon
			    	int numSeats = input.nextInt();
			    	boolean navigation = input.nextBoolean();
			    	String interior = input.next();  
			    	String transmission = input.next();
			        double price = Double.valueOf(input.next().substring(1));
			        
			        users.add(new Customer(type, username, password, name, phone, email, 
			    			new Car(), feature1, feature2, carWanted, budget, 
			    			mileage, numSeats, navigation, interior, transmission));
		    	}
		    }
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
