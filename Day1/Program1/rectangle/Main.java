package rectangle;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the width of the Rectangle:");
		double width = sc.nextDouble();
		System.out.println("Enter the height of the Rectangle:");
		double height = sc.nextDouble();
		
		Rectangle rect = new Rectangle(width, height);
		double area = rect.calculateArea();
		System.out.println("Area of the Rectangle: " + area);
		double preimeter = rect.calculatePerimeter();
		System.out.println("Area of the Rectangle: " + preimeter);
		sc.close();
	}

}
