package carfinder;

public class Customer extends User{
	private String feature1;
	private String feature2;
	private String carWanted;
	private double budget;
	private double mpg;
	private int numSeats;
	private boolean navigation;
	private String interior;
	private String transmission;
	private Car car;

	public Customer(String username, String password, String name, String phone, String email, 
			String feature1, String feature2, String carWanted, double budget, 
			double mpg, int numSeats, boolean navigation, String interior, String transmission, Car car) {
		super(username, password, name, phone, email);
		this.car = car;
		this.feature1 = feature1;
		this.feature2 = feature2;
		this.carWanted = carWanted;
		this.budget = budget;
		this.mpg = mpg;
		this.numSeats = numSeats;
		this.navigation = navigation;
		this.interior = interior;
		this.transmission = transmission;
		this.car = car;
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
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public double getMpg() {
		return mpg;
	}
	public void setMpg(double mpg) {
		this.mpg = mpg;
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
		return "Customer [car=" + car + ", feature1=" + feature1 + ", feature2=" + feature2
				+ ", carWanted=" + carWanted + ", budget=" + budget + ", mpg=" + mpg + ", numSeats=" + numSeats
				+ ", navigation=" + navigation + ", interior=" + interior + ", transmission=" + transmission + "]";
	}
	
}
