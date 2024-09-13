package buildsystem;

public class ResidentialBuilding extends Building{
	 private int numberOfApartments;
	 private double rentPerApartment;
	 
	 public ResidentialBuilding(String address, int numberOfFloors, double totalArea, int numberOfApartments,
			double rentPerApartment) {
		super(address, numberOfFloors, totalArea);
		this.numberOfApartments = numberOfApartments;
		this.rentPerApartment = rentPerApartment;
	}
	 @Override
	    public double calculateRent() {
	        return numberOfApartments * rentPerApartment;
	    }
	 @Override
	    public void displayInfo() {
	        super.displayInfo();
	        System.out.println("Number of Apartments: " + numberOfApartments);
	        System.out.println("Rent per Apartment: $" + rentPerApartment);
	        System.out.println("Total Rent: $" + calculateRent());
	    }
}
