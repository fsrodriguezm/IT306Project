package carfinder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
	private String username;
	private String password;
	private String name;
	private String phone;
	private String email;
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$", Pattern.CASE_INSENSITIVE);
	
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
		return phone;
	}
	public boolean setPhone(String phone) { //Format validated
		if(!phone.equals("")){
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
	
	public static boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
	}
	
	public boolean setEmail(String email) {
		if(!email.equals("")){
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
				"\nPhone: "+phone+
				"\nEmail: "+email;
	}

	
	
}
