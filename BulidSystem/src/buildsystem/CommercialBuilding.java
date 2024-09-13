package buildsystem;

public class CommercialBuilding extends Building {
	private double officeSpace; 
    private double rentPerSquareMeter;
    
	public CommercialBuilding(String address, int numberOfFloors, double totalArea, double officeSpace,
			double rentPerSquareMeter) {
		super(address, numberOfFloors, totalArea);
		this.officeSpace = officeSpace;
		this.rentPerSquareMeter = rentPerSquareMeter;
	}
	 @Override
	    public double calculateRent() {
	        return officeSpace * rentPerSquareMeter;
	    }
	 @Override
	    public void displayInfo() {
	        super.displayInfo();
	        System.out.println("Office Space: " + officeSpace + " sq meters");
	        System.out.println("Rent per Square Meter: $" + rentPerSquareMeter);
	        System.out.println("Total Rent: $" + calculateRent());
	    }
}
