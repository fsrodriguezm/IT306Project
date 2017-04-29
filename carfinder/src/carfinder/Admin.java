package carfinder;

public class Admin extends User{
	
	public Admin(String username, String password, String name, String phone, String email){
		super(username, password, name, phone, email);
	}
	
	public String stringForFile(){
		return super.getUsername()+","+super.getPassword() +","+super.getName()+","+super.getPhone()+","+super.getEmail();
	}

	@Override
	public String toString() {
		return "Name: "+getName()+
				"\nPhone: "+getPhone()+
				"\nEmail: "+getEmail();
	}

}
