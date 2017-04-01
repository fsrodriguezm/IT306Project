package carfinder.gmu.edu;

public class Car {
	private double milage;
	private int numSeats;
	private boolean navigation;
	private String transmission;
	private String type;
	private double price;
	
	public Car(){
		
	}

	public double getMilage() {
		return milage;
	}

	public void setMilage(double milage) {
		this.milage = milage;
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

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [milage=" + milage + ", numSeats=" + numSeats + ", navigation=" + navigation + ", transmission="
				+ transmission + ", type=" + type + ", price=" + price + "]";
	}
	
	
}
