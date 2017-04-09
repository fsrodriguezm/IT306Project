package carfinder;

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
	public boolean setEmail(String email) {
		if(!email.equals("")){
			this.email = email;
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public String toString() {
		return "Username: "+username+ 
				"\npassword: "+password+ 
				"\nname: "+name+
				"\nphone: "+phone+
				"\nemail: "+email;
	}
	
	
	
}
