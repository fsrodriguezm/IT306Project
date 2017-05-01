package carfinder;

public class Customer extends User{
	private String feature1;
	private String feature2;
	private String carWanted;
	private double budget;
	private String transmission;
	private Car car=null;

	public Customer(String username, String password, String name, String phone, String email, 
			String feature1, String feature2, String carWanted, double budget, 
			String transmission, Car car) {
		super(username, password, name, phone, email);
		this.car = car;
		this.feature1 = feature1;
		this.feature2 = feature2;
		this.carWanted = carWanted;
		this.budget = budget;
		this.transmission = transmission;
		this.car = car;
	}
	
	public Customer() {
	}

	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getFeature1() {
		return feature1;
	}
	public boolean setFeature1(String feature1) {
		if(!feature1.equals("")){
			this.feature1 = feature1;
			return true;
		}
		else{
			return false;
		}
	}
	public String getFeature2() {
		return feature2;
	}
	public boolean setFeature2(String feature2) {
		if(!feature2.equals("")){
			this.feature2 = feature2;
			return true;
		}
		else{
			return false;
		}
	}
	public String getCarWanted() {
		return carWanted;
	}
	public boolean setCarWanted(String carWanted) {
		if(!carWanted.equals("")){
			this.carWanted = carWanted;
			return true;
		}
		else{
			return false;
		}
	}
	public double getBudget() {
		return budget;
	}
	public boolean setBudget(double budget) {
		if(budget > 0){
			this.budget = budget;
			return true;
		}
		else{
			return false;
		}
	}
	public String getTransmission() {
		return transmission;
	}
	public boolean setTransmission(String transmission) {
		if(!transmission.equals("")){
			this.transmission = transmission;
			return true;
		}
		else{
			return false;
		}
	}
	public String stringForFile(){
		return super.getUsername()+","+super.getPassword() +","+super.getName()+","+super.getPhone()+","+super.getEmail()+","+feature1+","+feature2+
				","+carWanted+","+budget+","+transmission+","+car.getId()+","+car.getYear()+","+
				car.getMake()+","+car.getModel()+","+car.getColor()+","+car.getType()+","+car.getMpg()+","+car.getFeature1()+","+car.getFeature2()+","+car.getTransmission()+","
				+car.getInterior()+","+car.getCarPackage()+","+car.getCapacity()+","+car.getPrice();
	}
	@Override
	public String toString() {
		String report =
			super.toString() +
			"\nPreferred Feature 1: " + feature1 +
			"\nPreferred Feature 2: " + feature2 +
			"\nCar Wanted: " + carWanted +
			"\nBudget: " + budget + 
			"\nTransmission: " + transmission;
			if(car.getColor()!=null && car.getColor().equals("")){
				System.out.println(car.getColor());
				report = report + "\n****Car****"+
								  "\nCustomer Car: " + car;
			}
		return report;
	}
	
}
