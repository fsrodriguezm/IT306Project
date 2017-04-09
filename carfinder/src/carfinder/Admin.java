package carfinder;

public class Admin extends User{
	
	public Admin(String username, String password, String name, String phone, String email){
		super(username, password, name, phone, email);
	}
	
	public boolean addCar(){
		return false;
		
	}
	
	public boolean editCar(){
		return false;
		
	}
	
	public String viewInventory(){
		String invetory="";
		
		return invetory;	
	}

	@Override
	public String toString() {
		return "Username: "+getUsername()+ 
				"\npassword: "+getPassword()+ 
				"\nname: "+getName()+
				"\nphone: "+getPhone()+
				"\nemail: "+getEmail();
	}

}
