package carfinder;
import java.util.LinkedList;
public class Car {
	private int id;
	private String year;
	private String make;
	private String model;
	private String color;
	private String type;
	private String mpg;
	private String feature1;
	private String feature2;
	private String transmission;
	private String interior;
	private String carPackage;
	private int capacity;
	private double price;
	
	public static int idcount=1;
	
	public Car(){
		if(this.price == 0){
		this.price = 30000.0;
		this.mpg = "29";
		this.capacity = 4;
		}
	}
	
	public Car(int id, String year, String make, String model, String color, String type, String mpg,
			String feature1, String feature2, String transmission, String interior, String carPackage, int capacity, double price) {
		this.id = id;
		this.year = year;
		this.make = make;
		this.model = model;
		this.color = color;
		this.type = type;
		this.mpg = mpg;
		this.feature1 = feature1;
		this.feature2 = feature2;
		this.transmission = transmission;
		this.interior = interior;
		this.carPackage = carPackage;
		this.capacity = capacity;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public boolean setYear(String year) {
		if(year.equals("2017")){
			this.year = year;
			return true;
		}
		else{
			return false;
		}
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMpg() {
		return mpg;
	}
	public boolean setMpg(String mpg) {
		if(mpg.equals("")){
			this.mpg = mpg;
			return true;
		}
		else{
			return false;
		}
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
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getInterior() {
		return interior;
	}
	public void setInterior(String interior) {
		this.interior = interior;
	}
	public String getCarPackage() {
		return carPackage;
	}
	public void setCarPackage(String carPackage) {
		this.carPackage = carPackage;
	}
	public int getCapacity() {
		return capacity;
	}
	public boolean setCapacity(int capacity) {
		if(capacity > 0){
			this.capacity = capacity;
			return true;
		}
		else{
			return false;
		}
	}
	public double getPrice() {
		return price;
	}
	public boolean setPrice(double price) {
		if(price > 0){
			this.price = price;
			return true;
		}
		else{
			return false;
		}
	}
	public String stringToFile(){
		return id+","+year +","+make+","+model+","+color+","+type+","+mpg+
				","+feature1+","+feature2+","+transmission+","+interior+
				","+carPackage+","+capacity+","+price;
	}
	public static double getLowestPrice(LinkedList<Car> cars){
      	double lowest = cars.get(0).getPrice();
      	for(int i = 0; i< cars.size(); i++){
         if(cars.get(i).getPrice() < lowest){
            lowest = cars.get(i).getPrice();
         }
      	} 
      	return lowest;
   	}
   	public static double getHighestPrice(LinkedList<Car> cars){
      	double max = cars.get(0).getPrice();
      	for(int i = 0; i< cars.size(); i++){
         if(cars.get(i).getPrice() > max){
            max = cars.get(i).getPrice();
         }
      	}
      	return max;
    	}
	@Override
	public String toString() {
		return "ID: " + id + 
				"\nYear: " + year + 
				"\nMake: " + make + 
				"\nModel: " + model + 
				"\nColor: " + color +
				"\nType: " + type + 
				"\nMPG: " + mpg + 
				"\nFeature 1: " + feature1 + 
				"\nFeature 2: " + feature2 +
				"\nTransmission: " + transmission + 
				"\nInterior: " + interior + 
				"\nCar Package: " + carPackage +
				"\nCapacity: " + capacity + 
				"\nPrice: " + String.format("$%.2f",price);
	}
	
}
