package carfinder;

public class Admin extends User{
	
	public Admin(String username, String password, String name, String phone, String email){
		super(username, password, name, phone, email);
	}

	@Override
	public String toString() {
		return "Name: "+getName()+
				"\nPhone: "+getPhone()+
				"\nEmail: "+getEmail();
	}

}
