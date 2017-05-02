package carfinder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
	private String username;
	private String password;
	private String name;
	private String phone;
	private String email;
		
	public User(){
		
	}
	
	public User(String username, String password, String name, String phone, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}
	public boolean setUsername(String username) {
		if(!username.equals("")){
			this.username = username;
			return true;
		}
		else{
			return false;
		}
	}
	public String getPassword() {
		return password;
	}
	public boolean setPassword(String password) { //password validated for special characters
		if(!password.equals("")){
			this.password = password;
			return true;
		}
		else{
			return false;
		}
	}
	public String getName() {
		return name;
	}
	public boolean setName(String name) {
		if(!name.equals("")){
			this.name = name;
			return true;
		}
		else{
			return false;
		}
	}
	public String getPhone() {
		return "(" + phone.substring(0, 3) + ")-" + phone.substring(3, 6) + "-" + phone.substring(6,10);
	}
	public boolean setPhone(String phone) { //Format validated
		if(!phone.equals("") && phone.length() == 10){
			this.phone = phone;
			return true;
		}
		else{
			return false;
		}
	}
	public String getEmail() {
		return email;
	}
	
	public static boolean validEmail(String email){
		//Checks for the '@' to present only once
		int atCount = 0;
		for(int x=0; x<email.length(); x++){
			if(email.charAt(x) == '@'){
				atCount++;
			}
		}
		boolean validAt = false;
		if(atCount == 1){
			validAt = true;
		}
		//Checks if the dot is after the '@'
		boolean dotCheck = false;
		if(email.indexOf('@')<email.indexOf('.')){
			dotCheck = true;
		}
		//Checks if at least two digits are present after '.'
		if((email.indexOf('.') - email.length()) > 2){
			dotCheck = true;
		}
		
		//Determines if all validations are valid or not
		if(!email.equals("")&&validAt&&dotCheck){
			return true;
		}
		else{
			return false;
	    }
	}
	
	public boolean setEmail(String email) {
		if(validEmail(email)){
			this.email = email;
			return true;
		}
		else{
			return false;
		}
	}
	
	public String stringForFile(){
		return "";
	}

	@Override
	public String toString() {
		return 	"\nName: "+name+
				"\nUsername: "+username+
				"\nPhone: "+getPhone()+
				"\nEmail: "+email;
	}

	
	
}
