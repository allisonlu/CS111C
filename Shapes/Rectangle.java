public class Rectangle extends AbstractShape {
	private double length;
	private double width;
	private double area;

	// true constructor
	public Rectangle(double x, double y, double l, double w) {
		super(x,y);
		length = l;
		width = w;
	}

	// convenience constructors
	public Rectangle() {
		this(0, 0, 0, 0);
	}

	public Rectangle(double l, double w) {
		this(0, 0, l, w);
	}

	public double getArea() {
		area = length*width;
		return area;
	}
}