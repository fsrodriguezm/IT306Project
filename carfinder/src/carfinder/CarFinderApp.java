package carfinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.html.HTMLDocument.Iterator;

public class CarFinderApp {
	public static void main(String [] args){
		
		LinkedList<User> users = new LinkedList<>();
		LinkedList<Car> cars = new LinkedList<>();
		cacheUsers(users); //Loads customers and admins from text file to the users linked list
		cacheCars(cars); //Loads cars from the text file to user links
		JOptionPane.showMessageDialog(null, "Welcome to Car Finder"); // Splash screen
		
		User loggedUser = null;
		while(loggedUser==null){
			loggedUser = loginOption(users);
		}
		menuDirector(loggedUser, cars, users); 
	}
	
	public static User loginOption(LinkedList<User> users){
		User loggedUser = null;
        String[] choices = {"Register", "Login", "Quit"};
        int response = JOptionPane.showOptionDialog(
                null                       	// Center in window.
              , "Pick an option:"        	// Message
              , "Car Finder"               	// Title in titlebar
              , JOptionPane.YES_NO_OPTION  	// Option type
              , JOptionPane.PLAIN_MESSAGE  	// messageType
              , null                       	// Icon (none)
              , choices                    	// Button text as above.
              , "Register"    				// Default button's label
            );
        	if(response == 0){
        		loggedUser = register(users);
        	}
        	else if(response == 1){
        		loggedUser = login(users);
        	}
        	else{
        		System.exit(0);
        	}
		return loggedUser;
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
		if(loggedUser == null){
			JOptionPane.showMessageDialog(null, "User not found. Please try again.");
		}
			return loggedUser;
	}
	
	private static User register(LinkedList<User> users) {
		Customer nUser = new Customer();

			String name;
			boolean setName = false;
			while(!setName){
				name = JOptionPane.showInputDialog("Enter your full name: ");
				if(!nUser.setName(name)){
					JOptionPane.showMessageDialog(null, "Please try again.");
					setName = false;
				}
				else{
					setName = true;
				}
			}
			
			String username;
			boolean setUserName = false;
			while(!setUserName){
				username = JOptionPane.showInputDialog("Enter a username: ");
				if(!nUser.setUsername(username)){
					JOptionPane.showMessageDialog(null, "Please try again.");
					setUserName = false;
				}
				else{
					setUserName = true;
				}
			}
			
			String password;
			boolean setPassword = false;
			while(!setPassword){
				password = JOptionPane.showInputDialog("Enter a password: ");
				if(!nUser.setPassword(password)){
					JOptionPane.showMessageDialog(null, "Please try again.");
					setPassword = false;
				}
				else{
					setPassword = true;
				}
			}
			
			String email;
			boolean setEmail = false;
			while(!setEmail){
				email = JOptionPane.showInputDialog("Enter your email: ");
				if(!nUser.setEmail(email)){
					JOptionPane.showMessageDialog(null, "Please try again.");
					setEmail = false;
				}
				else{
					setEmail = true;
				}
			}
			
			String phone;
			boolean setPhone = false;
			while(!setPhone){
				phone = JOptionPane.showInputDialog("Enter your phone number: ");
				if(!nUser.setPhone(phone)){
					JOptionPane.showMessageDialog(null, "Please try again.");
					setPhone = false;
				}
				else{
					setPhone = true;
				}
			}
			
			String f1;
			Object[] possibilities5 = { "All season carpet", "Backup camera", "Blind spot monitor", "Heated Seats",
					"Moonroof", "Navigation", "Remote Start", "Satellite Radio", "Smart Key", "Spoiler" };
			do {
				f1 = (String) JOptionPane.showInputDialog(null, "Select a feature for the car" + "", "",
						JOptionPane.PLAIN_MESSAGE, null, possibilities5, "Spoiler");
				if (f1 == null) {
					JOptionPane.showMessageDialog(null, "You must select an option.");
				}
			} while (f1 == null);
			String feature1 = f1;
			String feature2 = f1;

			String f2 = null;
			while (feature2 == feature1) {
				Object[] possibilities6 = { "All season carpet", "Backup camera", "Blind spot monitor", "Heated Seats",
						"Moonroof", "Navigation", "Remote Start", "Satellite Radio", "Smart Key", "Spoiler" };
				do {
					f2 = (String) JOptionPane.showInputDialog(null, "Select another feature for the car" + "", "",
							JOptionPane.PLAIN_MESSAGE, null, possibilities6, "Spoiler");
					if (f2 == null) {
						JOptionPane.showMessageDialog(null, "You must select an option.");
					}
				} while (f2 == null);
				feature2 = f2;
				if (feature2 == feature1) {
					JOptionPane.showMessageDialog(null, "You must select a feature that is different from Feature 1.");
				}
			}
			
			String carType;
			Object[] possibilities7 = { "SUV", "Truck", "Sedan", "Minivan",
					"Coupe", "Convertible", "Sport", "Hatchback", "Luxury", "Hybrid" };
			do {
				carType = (String) JOptionPane.showInputDialog(null, "Select type of car wanted" + "", "",
						JOptionPane.PLAIN_MESSAGE, null, possibilities7, "Hybrid");
				if (carType == null) {
					JOptionPane.showMessageDialog(null, "You must select an option.");
				}
			} while (carType == null);
			nUser.setCarWanted(carType);
			
			String transmission;
			Object[] possibilities8 = { "Auto", "Manual" };
			do {
				transmission = (String) JOptionPane.showInputDialog(null, "Select transmission type" + "", "",
						JOptionPane.PLAIN_MESSAGE, null, possibilities8, "Auto");
				if (transmission == null) {
					JOptionPane.showMessageDialog(null, "You must select an option.");
				}
			} while (transmission == null);
			nUser.setTransmission(transmission);
			
			double budget;
			boolean setBudget = false;
			while(!setBudget){
				try{
					budget = Double.parseDouble(JOptionPane.showInputDialog("Enter your budget: "));
					if(!nUser.setBudget(budget)){
						JOptionPane.showMessageDialog(null, "Please try again.");
						setBudget = false;
					}
					else{
						setBudget = true;
					}
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Invalid amount. Please try again.");
					setBudget = false;
				}
			}
			
			nUser.setCar(new Car());
			nUser.setFeature1(f1);
			nUser.getCar().setFeature1(f1);
			nUser.setFeature2(f2);
			nUser.getCar().setFeature2(f2);
			
			
			
			users.add(nUser);

			saveUsersToFile(users);
			
		return nUser;
	}


	private static User checkCredentials(String username, String password, LinkedList<User> users) {
		User user = new User();
		 for(int x=0; x<users.size(); x++){
			if(username.equals(users.get(x).getUsername()) && password.equals(users.get(x).getPassword())){
				user = users.get(x);
				break;
			}else{
				user = null;
			}
		}
		 return user;
	}

	public static void menuDirector(User user, LinkedList<Car> cars, LinkedList<User> users) {
		if(user instanceof Admin){
			adminMenu(cars);
		}
		else{
			customerMenu(user, cars, users);
		}	
	}

	private static void customerMenu(User user, LinkedList<Car> cars, LinkedList<User> users) {
		String[] options = new String[] {"Select Car", "View Profile", "Log Out"};
		int choice = 0;
		//Need to something to route customer to the select car method.
		
		
  		while(choice != 2){
  			choice = JOptionPane.showOptionDialog(null, "Please make a menu selection", "Choose an option", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
  		 switch(choice){
     	  case 0: 
   	  			selectCar(cars, user);
   	  			saveUsersToFile(users);
   	  			break;
     
     	  case 1: 
                viewProfile(user);
                break;
             
     	  case 2: 
                logOut();
                break;		
  		  }		
  		}
	}
	
	private static void saveUserToFile() {
		// TODO Auto-generated method stub
		
	}

	public static void logOut(){
     	JOptionPane.showMessageDialog(null, "Thank you for using Car Finder!");
        System.exit(0);
    }

	 public static void viewProfile(User user){
    	   JOptionPane.showMessageDialog(null, "Customer Profile:\n" + user.toString());
 	}

	 public static void selectCar(LinkedList<Car> cars, User u){
		  LinkedList<Car> carList = new LinkedList<Car>();
	        int choice = 0;
	        String results = "Cars: \n";
	        Customer cust = null;
	        if(u instanceof Customer){
	            cust = (Customer) u;
	        }
	        for(int i = 0; i < cars.size(); i++){
	             if((cars.get(i).getFeature1().toLowerCase().equals(cust.getFeature1().toLowerCase()) || cars.get(i).getFeature2().toLowerCase().equals(cust.getFeature1().toLowerCase()) ||
	            		cars.get(i).getFeature1().toLowerCase().equals(cust.getFeature2().toLowerCase()) || cars.get(i).getFeature2().toLowerCase().equals(cust.getFeature2().toLowerCase())) && ((cars.get(i).getPrice() <= cust.getBudget()) && cars.get(i).getTransmission().substring(0,3).equals(cust.getTransmission().substring(0,3)) && cars.get(i).getType().toLowerCase().equals(cust.getCarWanted().toLowerCase()))){
	              carList.add(cars.get(i));
	             }
	        }
	        Object[] options = new Object[carList.size() + 1];
	        options[0] = "Customize Car";
	        for(int i = 1; i < options.length;i++){
	         options[i] = i;
	        }
	        if(carList.size() > 0){
	        for(int i = 0; i< carList.size(); i++){
	            results += i+1 + ") Model: " + carList.get(i).getModel() + " | Type: " + carList.get(i).getType() + " | Feature 1: " + carList.get(i).getFeature1() + " | Feature 2: " + carList.get(i).getFeature2() +  " | Transmission: " + carList.get(i).getTransmission() +  " |  Price: " + carList.get(i).getPrice() + "\n";
	        }
	          choice = JOptionPane.showOptionDialog(null, "These are the cars that have features you desire. Please select one or press customize car\n" + results, "Select a car", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options , options[0]);
	        }
	          if(choice > 0){
	          cust.setCar(carList.get(choice - 1));
	          }
	         
	          else{
	           if(carList.size() == 0){
	            JOptionPane.showMessageDialog(null, "Sorry, there were no cars found that met your needs.");
	           }
	           JOptionPane.showMessageDialog(null, "Please begin customizing your car");
	           Car car = new Car();
	           String m;
	           do{
	           Object[] possibilities2 = { "Prius", "Yaris", "Tacoma", "Camry", "Sienna", "Corolla" }; // Can
	  			   m = (String) JOptionPane.showInputDialog(null, "Select a make for the car" + "", "",
	  					JOptionPane.PLAIN_MESSAGE, null, possibilities2, "Corolla");
	           if(m == null){
	            JOptionPane.showMessageDialog(null, "You must select an option.");
	           }
	           }while(m == null);
	           car.setModel(m);
	           
	           String t;
	           if(car.getModel().equals("Prius")){
	            car.setMpg("30");
	            t = "Sedan";
	           }
	           else if(car.getModel().equals("Yaris")){
	            car.setMpg("30");
	            t = "Sedan";
	           }
	           else if(car.getModel().equals("Tacoma")){
	            car.setMpg("19");
	            t = "Truck";
	           }
	           else if(car.getModel().equals("Camry")){
	            car.setMpg("24");
	            t = "Sedan";
	           }
	           
	           else if(car.getModel().equals("Sienna")){
	            car.setMpg("19");
	            t = "Minivan";
	           }
	           else{
	            car.setMpg("30");
	            t = "Sedan";
	           }
	           car.setType(t);
	            
	           String c;   
	           Object[] possibilities3 = { "Black", "Blue", "Brown", "Gold", "Gray", "Green", "Red", "White" }; // Can
	  			   do{
	              c = (String) JOptionPane.showInputDialog(null, "Select a color for the car" + "", "",
	  					JOptionPane.PLAIN_MESSAGE, null, possibilities3, "White");
	           if(c == null){
	            JOptionPane.showMessageDialog(null, "You must select an option.");
	           }
	           }while(c == null);
	           car.setColor(c);
	           
	  			Object[] possibilities5 = {"All season carpet", "Backup camera", "Blind spot monitor", "Heated Seats", "Moonroof", "Navigation", "Remote Start", "Satellite Radio", "Smart Key", "Spoiler"}; 
	  			String f1;
	         do{
	               f1 = (String) JOptionPane.showInputDialog(null, "Select a feature for the car" + "", "",
	  					JOptionPane.PLAIN_MESSAGE, null, possibilities5, "Blindspot Monitor");
	  			if(f1 == null){
	          JOptionPane.showMessageDialog(null, "You must select an option.");
	         }
	         }while(f1 == null);
	         car.setFeature1(f1);
	           
	           
	  				Object[] possibilities6 = {"All season carpet", "Backup camera", "Blind spot monitor", "Heated Seats", "Moonroof", "Navigation", "Remote Start", "Satellite Radio", "Smart Key", "Spoiler"}; 
	  				String f2;
	            do{
	                  f2 = (String) JOptionPane.showInputDialog(null, "Select a second feature for the car" + "", "",
	  						JOptionPane.PLAIN_MESSAGE, null, possibilities6, "Blindspot Monitor");
	  				car.setFeature2(f2);
	  				if (car.getFeature1() == car.getFeature2()) {
	  					JOptionPane.showMessageDialog(null, "You must select a feature that is different from the other feature.");
	  				}
	            else if(f2 == null){
	               JOptionPane.showMessageDialog(null, "You must select an option.");
	            }
	           }while(car.getFeature1() == car.getFeature2() || f2 == null);
	           
	           Object[] possibilities7 = { "Automatic", "Manual" };
	  			String trans;
	         do{
	              trans = (String) JOptionPane.showInputDialog(null, "Select a transmission type for the car" + "", "",
	  					JOptionPane.PLAIN_MESSAGE, null, possibilities7, "Manual");
	           if(trans == null){
	            JOptionPane.showMessageDialog(null, "You must select an option.");
	           }
	           }while(trans == null);
	           car.setTransmission(trans);
	           
	           Object[] possibilities8 = { "Leather", "Nylon", "Polyester", "Vinyl" };
	  			String i;
	         do{
	               i = (String) JOptionPane.showInputDialog(null, "Select a interior for the car" + "", "",
	  					JOptionPane.PLAIN_MESSAGE, null, possibilities8, "Vinyl");
	          if(i == null){
	            JOptionPane.showMessageDialog(null, "You must select an option.");
	          }
	         }while(i == null);
	           car.setInterior(i);
	           
	           Object[] possibilities9 = { "LX", "XSE" };
	           String p;
	           do{
	  			      p = (String) JOptionPane.showInputDialog(null, "Select a package for the car" + "", "",
	  					JOptionPane.PLAIN_MESSAGE, null, possibilities9, "LX");
	           car.setCarPackage(p);
	           if(p == null){
	            JOptionPane.showMessageDialog(null, "You must select an option.");
	           }
	           }while(p == null); 
	           car.setModel("Toyota");
	           cust.setCar(car);
	        }
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
				viewInventory2(cars);
			}
		}
		if (n == 3) {
			logout();
		}

	}

	private static void viewInventory2(LinkedList<Car> cars) {
			JPanel panel = new JPanel();
			DefaultListModel dlm = new DefaultListModel();
			
			String inventory="**Car Inventory**\n\n";
			for(int x=0; x<cars.size(); x++){
				//inventory = inventory +cars.get(x).toString()+"\n\n";
				dlm.addElement(cars.get(x).toString()+"\n\n");
			}
			
			JList list = new JList(dlm);
			panel.add(new JScrollPane(list));
			JOptionPane.showConfirmDialog(null, panel, "Inventory", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void addCar(LinkedList<Car> cars) {
		String[] years = new String[117];
		int yearOption = 1901;
		for (int x = 0; x <= 116; x++) {
			years[x] = Integer.toString(yearOption);
			yearOption++;
		}

		String s;
		do {
			Object[] possibilities = years;
			s = (String) JOptionPane.showInputDialog(null, "Select a year for the car" + "", "",
					JOptionPane.PLAIN_MESSAGE, null, possibilities, possibilities[116]);
			if (s == null) {
				JOptionPane.showMessageDialog(null, "You must select an option.");
			}
		} while (s == null);
		String year = s;

		String make = "Toyota";
		String m;
		Object[] possibilities2 = { "Camry", "Corolla", "Prius", "Sienna", "Tacoma", "Yaris" };
		do {
			m = (String) JOptionPane.showInputDialog(null, "Select a make for the car" + "", "",
					JOptionPane.PLAIN_MESSAGE, null, possibilities2, "Yaris");
			if (m == null) {
				JOptionPane.showMessageDialog(null, "You must select an option.");
			}
		} while (m == null);
		String model = m;

		String c;
		Object[] possibilities3 = { "Black", "Blue", "Brown", "Gold", "Gray", "Green", "Red", "White" };
		do {
			c = (String) JOptionPane.showInputDialog(null, "Select a color for the car" + "", "",
					JOptionPane.PLAIN_MESSAGE, null, possibilities3, "White");
			if (c == null) {
				JOptionPane.showMessageDialog(null, "You must select an option.");
			}
		} while (c == null);
		String color = c;

		String t;
		Object[] possibilities4 = { "Convertible", "Coupe", "Hatckback", "Hybrid", "Luxury", "Minivan", "Sedan",
				"Sports", "SUV", "Truck" };
		do {
			t = (String) JOptionPane.showInputDialog(null, "Select a color for the car" + "", "",
					JOptionPane.PLAIN_MESSAGE, null, possibilities4, "Truck");
			if (t == null) {
				JOptionPane.showMessageDialog(null, "You must select an option.");
			}
		} while (t == null);
		String type = t;

		String mpg = null;
		do {
			mpg = JOptionPane.showInputDialog("Enter the miles per gallon of the vehicle.");
			if (mpg == null) {
				JOptionPane.showMessageDialog(null, "You must select an option.");
			}
			try {
				if (mpg != null) {
					double d = Double.parseDouble(mpg);
				} // Tests to see if the value entered is numeric
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "You must input a number.");
				mpg = null;
			}
		} while (mpg == null);

		String f1;
		Object[] possibilities5 = { "All season carpet", "Backup camera", "Blind spot monitor", "Heated Seats",
				"Moonroof", "Navigation", "Remote Start", "Satellite Radio", "Smart Key", "Spoiler" };
		do {
			f1 = (String) JOptionPane.showInputDialog(null, "Select a feature for the car" + "", "",
					JOptionPane.PLAIN_MESSAGE, null, possibilities5, "Spoiler");
			if (f1 == null) {
				JOptionPane.showMessageDialog(null, "You must select an option.");
			}
		} while (f1 == null);
		String feature1 = f1;
		String feature2 = f1;

		String f2;
		while (feature2 == feature1) {
			Object[] possibilities6 = { "All season carpet", "Backup camera", "Blind spot monitor", "Heated Seats",
					"Moonroof", "Navigation", "Remote Start", "Satellite Radio", "Smart Key", "Spoiler" };
			do {
				f2 = (String) JOptionPane.showInputDialog(null, "Select another feature for the car" + "", "",
						JOptionPane.PLAIN_MESSAGE, null, possibilities6, "Spoiler");
				if (f2 == null) {
					JOptionPane.showMessageDialog(null, "You must select an option.");
				}
			} while (f2 == null);
			feature2 = f2;
			if (feature2 == feature1) {
				JOptionPane.showMessageDialog(null, "You must select a feature that is different from Feature 1.");
			}
		}

		String trans;
		Object[] possibilities7 = { "Automatic", "Manual" };
		do {
			trans = (String) JOptionPane.showInputDialog(null, "Select a transmission type for the car" + "", "",
					JOptionPane.PLAIN_MESSAGE, null, possibilities7, "Manual");
			if (trans == null) {
				JOptionPane.showMessageDialog(null, "You must select an option.");
			}
		} while (trans == null);
		String transmission = trans;

		String i;
		Object[] possibilities8 = { "Cloth Black", "Cloth Brown", "Leather Black", "Leather Brown", "Leather Red" };
		do {
			i = (String) JOptionPane.showInputDialog(null, "Select a interior for the car" + "", "",
					JOptionPane.PLAIN_MESSAGE, null, possibilities8, "Leather Red");
			if (i == null) {
				JOptionPane.showMessageDialog(null, "You must select an option.");
			}
		} while (i == null);
		String interior = i;

		String p;
		Object[] possibilities9 = { "Hybrid LE", "Hybrid SE", "Hybrid XSE", "LE", "SE", "Special Edition", "XSE" };
		do {
			p = (String) JOptionPane.showInputDialog(null, "Select a package for the car" + "", "",
					JOptionPane.PLAIN_MESSAGE, null, possibilities9, "XSE");
			if (p == null) {
				JOptionPane.showMessageDialog(null, "You must select an option.");
			}
		} while (p == null);
		String carPackage = p;

		String seats;
		Object[] possibilities10 = { "2", "4", "5", "6", "8" };
		do {
			seats = (String) JOptionPane.showInputDialog(null, "Select the number of seats for the car" + "", "",
					JOptionPane.PLAIN_MESSAGE, null, possibilities10, "8");
			if (seats == null) {
				JOptionPane.showMessageDialog(null, "You must select an option.");
			}
		} while (seats == null);
		int num = Integer.parseInt(seats);
		int capacity = num;

		double price = 0;
		String entry;
		do {
			try {
				entry = JOptionPane.showInputDialog("Enter the price of the vehicle.");
				if (entry == null) {
					JOptionPane.showMessageDialog(null, "You must enter a number.");
				} else {
					price = Double.parseDouble(entry);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "You must enter a number.");
				entry = null;
			}

		} while (entry == null);
		int id = Car.idcount++;
		cars.add(new Car(id, year, make, model, color, type, mpg, feature1, feature2, transmission, interior,
				carPackage, capacity, price));

		saveCarsToFile(cars);
		JOptionPane.showMessageDialog(null, "The car was successfully added to the inventory.");
		adminMenu(cars);
	}

	public static void editCar(LinkedList<Car> cars) {
		int input= 0;
		do{
			try{
			input = Integer.parseInt(JOptionPane.showInputDialog("Choose a car to edit\n" + viewInventory(cars)));
			if(input < Car.idcount || input > Car.idcount){
				JOptionPane.showMessageDialog(null,  "You must enter a car id from the list above.");
				input = 0;
			}
			}catch(NumberFormatException e){JOptionPane.showMessageDialog(null, "You must enter a car ID number on the list.");
			input = 0;}
		}while(input == 0);
		String choice = "";

		String selection;
		while (choice != "Exit") {
			Object[] possibilities11 = { "Year", "Model", "Color", "Type", "Miles Per Gallon", "Feature 1", "Feature 2",
					"Transmission", "Interior", "Car Package", "Number of seats", "Price", "Exit" };
			do {
				selection = (String) JOptionPane.showInputDialog(null, "Select the part you would like to edit." + "",
						"", JOptionPane.PLAIN_MESSAGE, null, possibilities11, "Exit");
				if (selection == null) {
					JOptionPane.showMessageDialog(null, "You must make a selection.");
				}
			} while (selection == null);
			choice = selection;
			switch (choice) {
			case "Year":
				String[] years = new String[117];
				int yearOption = 1901;
				for (int x = 0; x <= 116; x++) {
					years[x] = Integer.toString(yearOption);
					yearOption++;
				}
				String s;
				Object[] possibilities = years;
				do {
					s = (String) JOptionPane.showInputDialog(null, "Select a year for the car" + "", "",
							JOptionPane.PLAIN_MESSAGE, null, possibilities, possibilities[116]);
					if (s == null) {
						JOptionPane.showMessageDialog(null, "You must select an option.");
					}
				} while (s == null);
				cars.get(input - 1).setYear(s);
				break;
			case "Model":
				String m;
				Object[] possibilities2 = { "Camry", "Corolla", "Prius", "Sienna", "Tacoma", "Yaris" }; // alphabetize
				do {
					m = (String) JOptionPane.showInputDialog(null, "Select a make for the car" + "", "",
							JOptionPane.PLAIN_MESSAGE, null, possibilities2, "Yaris");
					if (m == null) {
						JOptionPane.showMessageDialog(null, "You must select an option.");
					}
				} while (m == null);
				cars.get(input - 1).setModel(m);
				break;
			case "Color":
				String c;
				Object[] possibilities3 = { "Black", "Blue", "Brown", "Gold", "Gray", "Green", "Red", "White" };
				do {
					c = (String) JOptionPane.showInputDialog(null, "Select a color for the car" + "", "",
							JOptionPane.PLAIN_MESSAGE, null, possibilities3, "White");
					if (c == null) {
						JOptionPane.showMessageDialog(null, "You must select an option.");
					}
				} while (c == null);
				cars.get(input - 1).setColor(c);
				break;
			case "Type":
				String t;
				Object[] possibilities4 = { "Convertible", "Coupe", "Hatckback", "Hybrid", "Luxury", "Minivan", "Sedan",
						"Sports", "SUV", "Truck" };
				do {
					t = (String) JOptionPane.showInputDialog(null, "Select a color for the car" + "", "",
							JOptionPane.PLAIN_MESSAGE, null, possibilities4, "Truck");
					if (t == null) {
						JOptionPane.showMessageDialog(null, "You must select an option.");
					}
				} while (t == null);
				cars.get(input - 1).setType(t);
				break;
			case "Miles Per Gallon":
				String mpg = null;
				do {
					mpg = JOptionPane.showInputDialog("Enter the miles per gallon of the vehicle.");
					if (mpg == null) {
						JOptionPane.showMessageDialog(null, "You must select an option.");
					}
					try {
						if (mpg != null) {
							double d = Double.parseDouble(mpg);
						} // Tests to see if the value entered is numeric
					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "You must input a number.");
						mpg = null;
					}
				} while (mpg == null);
				cars.get(input - 1).setMpg(mpg);
				break;
			case "Feature 1":
				String f1;
				do {
					Object[] possibilities5 = { "All season carpet", "Backup camera", "Blind spot monitor",
							"Heated Seats", "Moonroof", "Navigation", "Remote Start", "Satellite Radio", "Smart Key",
							"Spoiler" };
					do {
						f1 = (String) JOptionPane.showInputDialog(null, "Select a feature for the car" + "", "",
								JOptionPane.PLAIN_MESSAGE, null, possibilities5, "Spoiler");
						if (f1 == null) {
							JOptionPane.showMessageDialog(null, "You must select an option.");
						}
					} while (f1 == null);
					cars.get(input - 1).setFeature1(f1);
					if (cars.get(input - 1).getFeature1() == cars.get(input - 1).getFeature2()) {
						JOptionPane.showMessageDialog(null,
								"You must select a feature that is different from the other feature.");
					}
				} while (cars.get(input - 1).getFeature1() == cars.get(input - 1).getFeature2());
				break;
			case "Feature 2":
				String f2;
				do {
					Object[] possibilities6 = { "All season carpet", "Backup camera", "Blind spot monitor",
							"Heated Seats", "Moonroof", "Navigation", "Remote Start", "Satellite Radio", "Smart Key",
							"Spoiler" };
					do {
						f2 = (String) JOptionPane.showInputDialog(null, "Select another feature for the car" + "", "",
								JOptionPane.PLAIN_MESSAGE, null, possibilities6, "Spoiler");
						if (f2 == null) {
							JOptionPane.showMessageDialog(null, "You must select an option.");
						}
					} while (f2 == null);
					cars.get(input - 1).setFeature2(f2);
					if (cars.get(input - 1).getFeature1() == cars.get(input - 1).getFeature2()) {
						JOptionPane.showMessageDialog(null,
								"You must select a feature that is different from the other feature.");
					}
				} while (cars.get(input - 1).getFeature1() == cars.get(input - 1).getFeature2());
				break;
			case "Transmission":
				String trans;
				Object[] possibilities7 = { "Automatic", "Manual" };
				do {
					trans = (String) JOptionPane.showInputDialog(null, "Select a transmission type for the car" + "",
							"", JOptionPane.PLAIN_MESSAGE, null, possibilities7, "Manual");
					if (trans == null) {
						JOptionPane.showMessageDialog(null, "You must select an option.");
					}
				} while (trans == null);
				cars.get(input - 1).setTransmission(trans);
				break;
			case "Interior":
				String i;
				Object[] possibilities8 = { "Cloth Black", "Cloth Brown", "Leather Black", "Leather Brown",
						"Leather Red" };
				do {
					i = (String) JOptionPane.showInputDialog(null, "Select a interior for the car" + "", "",
							JOptionPane.PLAIN_MESSAGE, null, possibilities8, "Leather Red");
					if (i == null) {
						JOptionPane.showMessageDialog(null, "You must select an option.");
					}
				} while (i == null);
				cars.get(input - 1).setInterior(i);
				break;
			case "Car Package":
				String p;
				Object[] possibilities9 = { "Hybrid LE", "Hybrid SE", "Hybrid XSE", "LE", "SE", "Special Edition",
						"XSE" };
				do {
					p = (String) JOptionPane.showInputDialog(null, "Select a package for the car" + "", "",
							JOptionPane.PLAIN_MESSAGE, null, possibilities9, "XSE");
					if (p == null) {
						JOptionPane.showMessageDialog(null, "You must select an option.");
					}
				} while (p == null);
				cars.get(input - 1).setCarPackage(p);
				break;
			case "Number of seats":
				String seats;
				Object[] possibilities10 = { "2", "4", "5", "6", "8" };
				do {
					seats = (String) JOptionPane.showInputDialog(null, "Select the number of seats for the car" + "",
							"", JOptionPane.PLAIN_MESSAGE, null, possibilities10, "8");
					if (seats == null) {
						JOptionPane.showMessageDialog(null, "You must select an option.");
					}
				} while (seats == null);
				int num = Integer.parseInt(seats);
				cars.get(input - 1).setCapacity(num);
				break;
			case "Price":
				String entry;
				Double price = 0.0;
				do {
					try {
						entry = JOptionPane.showInputDialog("Enter the price of the vehicle.");
						if (entry == null) {
							JOptionPane.showMessageDialog(null, "You must enter a number.");
						} else {
							price = Double.parseDouble(entry);
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "You must enter a number.");
						entry = null;
					}

				} while (entry == null);
				cars.get(input - 1).setPrice(price);
				break;
			case "Exit":
				choice = "Exit";
				break;
			default:
				choice = "";
			}
		}

		saveCarsToFile(cars);
		JOptionPane.showMessageDialog(null, "The car has been updated.");
	}

	private static void saveCarsToFile(LinkedList<Car> cars) {
		PrintWriter pw =null;
		try{
			pw = new PrintWriter("src/carfinder/cars.txt");
			
			for(int x=0; x<cars.size(); x++){
				pw.write(cars.get(x).stringToFile()+"\n");
				
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			pw.close();
		}
		
	}
	
	private static void saveUsersToFile(LinkedList<User> users) {
		Customer c;
		Admin a;
		PrintWriter pw =null;
		try{
			pw = new PrintWriter("src/carfinder/customers.txt");
			for(int x=0; x<users.size(); x++){
				if(users.get(x) instanceof Customer){
					c = (Customer) users.get(x);
					pw.write(c.stringForFile()+"\n");
				}

			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			pw.close();
		}
		
	}

	public static String viewInventory(LinkedList<Car> cars) {
		String inventory="**Car Inventory**\n\n";
		for(int x=0; x<cars.size(); x++){
			inventory = inventory +cars.get(x).toString()+"\n\n";
		}
		
		
		return inventory;
	}

	public static void logout() {
		System.exit(0);// need to change possibly. Might work like this though
						// with a while loop in main
	}
		
	

	public static void cacheCars(LinkedList<Car> cars) {
 		try{
			BufferedReader br = new BufferedReader(new FileReader(new File("src/carfinder/cars.txt")));
			String line; 
			Scanner input = null; 
		    while((line = br.readLine()) !=null){
		    	input = new Scanner(line);
			    input.useDelimiter(",");
		    	int id = Integer.parseInt(input.next());
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
		    	

		    	Car.idcount++;
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
	
		    while(input.hasNextLine()) { 
			    	String username = input.next();
			    	String password = input.next();
			    	String name = input.next();
			    	String phone = input.next();
			    	String email = input.next();
			    	String feature1 = input.next();
			    	String feature2 = input.next();
			    	String carWanted = input.next();
			    	double budget = Double.parseDouble(input.next());
			    	String transmission = input.next();
			    	//Car Object Variables
			    	int id = Integer.parseInt(input.next());
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
			        		feature1, feature2, carWanted, budget, transmission, new Car(id, year, make, model, color, 
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
