package buildsystem;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
        // Collect data for residential building
        System.out.println("Enter details for the Residential Building:");
        System.out.print("Address: ");
        String residentialAddress = sc.nextLine();
        System.out.print("Number of Floors: ");
        int residentialFloors = sc.nextInt();
        System.out.print("Total Area (sq meters): ");
        double residentialArea = sc.nextDouble();
        System.out.print("Number of Apartments: ");
        int numberOfApartments = sc.nextInt();
        System.out.print("Rent per Apartment: ");
        double rentPerApartment = sc.nextDouble();
 
        ResidentialBuilding residentialBuilding = new ResidentialBuilding(
                residentialAddress, residentialFloors, residentialArea, numberOfApartments, rentPerApartment);
 
        System.out.println("\nResidential Building:");
        residentialBuilding.displayInfo();
 
        System.out.println();
 
        // Collect data for commercial building
        sc.nextLine(); // consume the leftover newline
        System.out.println("Enter details for the Commercial Building:");
        System.out.print("Address: ");
        String commercialAddress = sc.nextLine();
        System.out.print("Number of Floors: ");
        int commercialFloors = sc.nextInt();
        System.out.print("Total Area (sq meters): ");
        double commercialArea = sc.nextDouble();
        System.out.print("Office Space (sq meters): ");
        double officeSpace = sc.nextDouble();
        System.out.print("Rent per Square Meter: ");
        double rentPerSquareMeter = sc.nextDouble();
 
        CommercialBuilding commercialBuilding = new CommercialBuilding(
                commercialAddress, commercialFloors, commercialArea, officeSpace, rentPerSquareMeter);
 
        System.out.println("\nCommercial Building:");
        commercialBuilding.displayInfo();
 
        sc.close();
	}

}
