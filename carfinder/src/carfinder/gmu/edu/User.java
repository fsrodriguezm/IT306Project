package carfinder.gmu.edu;

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
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + "]";
	}
	
	
	
}
