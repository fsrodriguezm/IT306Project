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
	public void setFeature1(String feature1) {
		this.feature1 = feature1;
	}
	public String getFeature2() {
		return feature2;
	}
	public void setFeature2(String feature2) {
		this.feature2 = feature2;
	}
	public String getCarWanted() {
		return carWanted;
	}
	public void setCarWanted(String carWanted) {
		this.carWanted = carWanted;
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
	public void setTransmission(String transmission) {
		this.transmission = transmission;
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
			if(car.getColor()!=null){
				report = report + "\n****Car****"+
								  "\nCustomer Car: " + car;
			}
		return report;
	}
	
}
