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
		
		int n = 0;
		while(n=0){
		JOptionPane.showMessageDialog(null, "Welcome to Car Finder"); // Splash screen
		User loggedUser = login(users); //Credential check for users
		menuDirector(loggedUser); 
		}
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

	private static void adminMenu(LinkedList<Car> cars) {
				
		int n = 0;
		while (n != 3) {
			Object[] options = { "Add a car", "Edit a car", "View Inventory", "Log out" };
			n = JOptionPane.showOptionDialog(null, "Admin Menu: Select an Option", "", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[3]);
			if (n == 0) {
				addCar(cars);
			} else if (n == 1) {
				editCar(cars);
			} else if (n == 2) {
				viewInventory(cars);
			}
		}
		if (n == 3) {
			logout(); //if i remove this and leave it blank will it exit the adminmenu method?
		}
	}

	public static void addCar(LinkedList<Car> cars) {// do i need to pass the linked list
		String id = car.getId();// are we going to keep a count for the next ID
								// to assign?
		String[] years = new String[117];
		int yearOption = 1901;
		for (int x = 0; x <= 116; x++) {
			years[x] = Integer.toString(yearOption);
			yearOption++;
		}
		Object[] possibilities = years;
		String s = (String) JOptionPane.showInputDialog(null, "Select a year for the car" + "", "",
				JOptionPane.PLAIN_MESSAGE, null, possibilities, possibilities[116]);
		String year = s;

		String make = "Toyota"; // We are just doing toyota, right?
		Object[] possibilities2 = {"Camry", "Corolla", "Prius", "Sienna","Tacoma","Yaris"};										// alphabetize
		String m = (String) JOptionPane.showInputDialog(null, "Select a make for the car" + "", "",
				JOptionPane.PLAIN_MESSAGE, null, possibilities2, "Yaris");
		String model = m;

		Object[] possibilities3 = { "Black", "Blue", "Brown", "Gold", "Gray", "Green", "Red", "White" }; 
		String c = (String) JOptionPane.showInputDialog(null, "Select a color for the car" + "", "",
				JOptionPane.PLAIN_MESSAGE, null, possibilities3, "White");
		String color = c;

		Object[] possibilities4 = {"Convertible", "Coupe", "Hatckback","Hybrid","Luxury","Minivan", "Sedan", "Sports","SUV","Truck"};
		String t = (String) JOptionPane.showInputDialog(null, "Select a color for the car" + "", "",
				JOptionPane.PLAIN_MESSAGE, null, possibilities4, "Truck");
		String type = t;

		String mpg = JOptionPane.showInputDialog("Enter the miles per gallon of the vehicle.");

		Object[] possibilities5 = { "Headed Seats", "Blindspot Monitor" }; // Can
		// add
		// more
		String f1 = (String) JOptionPane.showInputDialog(null, "Select a feature for the car" + "", "",
				JOptionPane.PLAIN_MESSAGE, null, possibilities5, "Blindspot Monitor");
		String feature1 = f1;
		String feature2 = f1;
		while (feature2 == feature1) {
			Object[] possibilities6 = { "Headed Seats", "Blindspot Monitor" }; // Can
			// add
			// more
			String f2 = (String) JOptionPane.showInputDialog(null, "Select another feature for the car" + "", "",
					JOptionPane.PLAIN_MESSAGE, null, possibilities6, "Blindspot Monitor");
			feature2 = f2;
			if (feature2 == feature1) {
				JOptionPane.showMessageDialog(null, "You must select a feature that is different from Feature 1.");
			}
		}

		Object[] possibilities7 = { "Automatic", "Manual" };
		String trans = (String) JOptionPane.showInputDialog(null, "Select a transmission type for the car" + "", "",
				JOptionPane.PLAIN_MESSAGE, null, possibilities7, "Manual");
		String transmission = trans;

		Object[] possibilities8 = { "Leather", "Nylon", "Polyester", "Vinyl" };
		String i = (String) JOptionPane.showInputDialog(null, "Select a interior for the car" + "", "",
				JOptionPane.PLAIN_MESSAGE, null, possibilities8, "Vinyl");
		String interior = i;

		Object[] possibilities9 = { "LX", "XSE" };
		String p = (String) JOptionPane.showInputDialog(null, "Select a package for the car" + "", "",
				JOptionPane.PLAIN_MESSAGE, null, possibilities9, "Vinyl");
		String carPackage = p;

		Object[] possibilities10 = { "2", "3", "4", "5", "6", "7", "8" };
		String seats = (String) JOptionPane.showInputDialog(null, "Select the number of seats for the car" + "", "",
				JOptionPane.PLAIN_MESSAGE, null, possibilities10, "8");
		int num = Integer.parseInt(seats);
		int capacity = num;

		double price = Double.parseDouble(JOptionPane.showInputDialog("Enter the price of the vehicle."));

		cars.add(new Car(id, year, make, model, color, type, mpg, feature1, feature2, transmission, interior,
				carPackage, capacity, price));
		// write to file here?

		adminMenu(cars);
	}

	public static void editCar(LinkedList<Car> cars) {
		viewInventory();
		Car carSelected = new Car("1", "Year", "Toyota","Model", "Color", "Type", "Miles Per Gallon", "Feature 1", "Feature 2",
				"Transmission", "Interior", "Car Package", 6, 12 ); //change this to the car the user selects
	String choice = "";

	while (choice != "Exit") {
		Object[] possibilities11 = { "Year", "Model", "Color", "Type", "Miles Per Gallon", "Feature 1", "Feature 2",
				"Transmission", "Interior", "Car Package", "Number of seats", "Price", "Exit"};
		String selection = (String) JOptionPane.showInputDialog(null,
				"Select the part you would like to edit." + "", "", JOptionPane.PLAIN_MESSAGE, null,
				possibilities11, "Exit");
		choice = selection;
		switch (choice) {
		case "Year":
			String[] years = new String[117];
			int yearOption = 1901;
			for (int x = 0; x <= 116; x++) {
				years[x] = Integer.toString(yearOption);
				yearOption++;
			}
			Object[] possibilities = years;
			String s = (String) JOptionPane.showInputDialog(null, "Select a year for the car" + "", "",
					JOptionPane.PLAIN_MESSAGE, null, possibilities, possibilities[116]);
			carSelected.setYear(s);
			break;
		case "Model":
			Object[] possibilities2 = { "Prius", "Yaris", "Tacoma", "Camry", "Sienna", "Corolla" }; // Can
			// add
			// more
			// and
			// alphabetize
			String m = (String) JOptionPane.showInputDialog(null, "Select a make for the car" + "", "",
					JOptionPane.PLAIN_MESSAGE, null, possibilities2, "Corolla");
			carSelected.setModel(m);
			break;
		case "Color":
			Object[] possibilities3 = { "Black", "Blue", "Brown", "Gold", "Gray", "Green", "Red", "White" }; // Can
			// add
			// more
			String c = (String) JOptionPane.showInputDialog(null, "Select a color for the car" + "", "",
					JOptionPane.PLAIN_MESSAGE, null, possibilities3, "White");
			carSelected.setColor(c);
			break;
		case "Type":
			Object[] possibilities4 = { "Sedan", "SUV", "Minivan", "Truck" }; // Can
			// add
			// more
			String t = (String) JOptionPane.showInputDialog(null, "Select a color for the car" + "", "",
					JOptionPane.PLAIN_MESSAGE, null, possibilities4, "Truck");
			carSelected.setType(t);
			break;
		case "Miles Per Gallon":
			String mpg = JOptionPane.showInputDialog("Enter the miles per gallon of the vehicle.");
			carSelected.setMpg(mpg);
			break;
		case "Feature 1":
			do{
			Object[] possibilities5 = { "Headed Seats", "Blindspot Monitor" }; 
			String f1 = (String) JOptionPane.showInputDialog(null, "Select a feature for the car" + "", "",
					JOptionPane.PLAIN_MESSAGE, null, possibilities5, "Blindspot Monitor");
			carSelected.setFeature1(f1);
			if (carSelected.getFeature1() == carSelected.getFeature2()) {
				JOptionPane.showMessageDialog(null, "You must select a feature that is different from the other feature.");
			}
			}while(carSelected.getFeature1() == carSelected.getFeature2());
			break;
		case "Feature 2":
			do{
				Object[] possibilities6 = { "Headed Seats", "Blindspot Monitor" }; 
				String f2 = (String) JOptionPane.showInputDialog(null, "Select a feature for the car" + "", "",
						JOptionPane.PLAIN_MESSAGE, null, possibilities6, "Blindspot Monitor");
				carSelected.setFeature2(f2);
				if (carSelected.getFeature1() == carSelected.getFeature2()) {
					JOptionPane.showMessageDialog(null, "You must select a feature that is different from the other feature.");
				}
				}while(carSelected.getFeature1() == carSelected.getFeature2());
			break;
		case "Transmission":
			Object[] possibilities7 = { "Automatic", "Manual" };
			String trans = (String) JOptionPane.showInputDialog(null, "Select a transmission type for the car" + "", "",
					JOptionPane.PLAIN_MESSAGE, null, possibilities7, "Manual");
			carSelected.setTransmission(trans);
			break;
		case "Interior":
			Object[] possibilities8 = { "Leather", "Nylon", "Polyester", "Vinyl" };
			String i = (String) JOptionPane.showInputDialog(null, "Select a interior for the car" + "", "",
					JOptionPane.PLAIN_MESSAGE, null, possibilities8, "Vinyl");
			carSelected.setInterior(i);				
			break;
		case "Car Package":
			Object[] possibilities9 = { "LX", "XSE" };
			String p = (String) JOptionPane.showInputDialog(null, "Select a package for the car" + "", "",
					JOptionPane.PLAIN_MESSAGE, null, possibilities9, "Vinyl");
			carSelected.setCarPackage(p);				
			break;
		case "Number of seats":
			Object[] possibilities10 = { "2", "3", "4", "5", "6", "7", "8" };
			String seats = (String) JOptionPane.showInputDialog(null, "Select the number of seats for the car" + "", "",
					JOptionPane.PLAIN_MESSAGE, null, possibilities10, "8");
			int num = Integer.parseInt(seats);
			carSelected.setCapacity(num);				
			break;
		case "Price":
			double price = Double.parseDouble(JOptionPane.showInputDialog("Enter the price of the vehicle."));
			carSelected.setPrice(price);
			break;
		case "Exit":
			choice = "Exit";
			break;
		default:
			choice = "";
		}
	}

	}

	public static void viewInventory(LinkedList<Car> cars) {

	}

	public static void logout() {
		login();// call this method? dont think so cuz the program will get an error after it runs. might need a while loop or something in main
	}
		
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
