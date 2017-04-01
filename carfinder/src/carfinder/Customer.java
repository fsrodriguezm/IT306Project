package carfinder;

public class Customer extends User{
	private Car currentCar;
	private String feature1;
	private String feature2;
	private String carWanted;
	private double budget;
	private double mileage;
	private int numSeats;
	private boolean navigation;
	private String interior;
	private String transmission;
	

	public Customer(String type, String username, String password, String name, String phone, String email, 
			Car currentCar, String feature1, String feature2, String carWanted, double budget, 
			double mileage, int numSeats, boolean navigation, String interior, String transmission) {
		super(type, username, password, name, phone, email);
		this.currentCar = currentCar;
		this.feature1 = feature1;
		this.feature2 = feature2;
		this.carWanted = carWanted;
		this.budget = budget;
		this.mileage = mileage;
		this.numSeats = numSeats;
		this.navigation = navigation;
		this.interior = interior;
		this.transmission = transmission;
	}
	
	public Car getCurrentCar() {
		return currentCar;
	}
	public void setCurrentCar(Car currentCar) {
		this.currentCar = currentCar;
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
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	public int getNumSeats() {
		return numSeats;
	}
	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}
	public boolean isNavigation() {
		return navigation;
	}
	public void setNavigation(boolean navigation) {
		this.navigation = navigation;
	}
	public String getInterior() {
		return interior;
	}
	public void setInterior(String interior) {
		this.interior = interior;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	@Override
	public String toString() {
		return "Customer [currentCar=" + currentCar + ", feature1=" + feature1 + ", feature2=" + feature2
				+ ", carWanted=" + carWanted + ", budget=" + budget + ", mileage=" + mileage + ", numSeats=" + numSeats
				+ ", navigation=" + navigation + ", interior=" + interior + ", transmission=" + transmission + "]";
	}
	
}
