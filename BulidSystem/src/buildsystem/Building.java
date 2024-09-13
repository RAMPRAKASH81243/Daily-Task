package buildsystem;

public class Building {
	 protected String address;
	 protected int numberOfFloors;
	 protected double totalArea;
	 
	public Building(String address, int numberOfFloors, double totalArea) {
		this.address = address;
		this.numberOfFloors = numberOfFloors;
		this.totalArea = totalArea;
	}
	public void displayInfo() {
        System.out.println("Address: " + address);
        System.out.println("Number of Floors: " + numberOfFloors);
        System.out.println("Total Area: " + totalArea + " sq meters");
    }
	public double calculateRent() {
		return 0.0;
	}
}
