package carfinder;

public class Admin extends User{
	
	public Admin(String type, String username, String password, String name, String phone, String email){
		super(type, username, password, name, phone, email);
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
		return "Admin [addCar()=" + addCar() + ", editCar()=" + editCar() + ", viewInventory()=" + viewInventory()
				+ ", getUserType()=" + getUserType() + ", getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", getName()=" + getName() + ", getPhone()=" + getPhone() + ", getEmail()="
				+ getEmail() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}

}
