package rectangle;

public class Rectangle {
	double width;
	double height;
	
	public Rectangle(double width, double height)
	{
		super();
		this.width = width;
		this.height = height;
	}
	double calculateArea() {
		return width * height;
	}
	double calculatePerimeter() {
		return 2*(width + height);
	}
}
