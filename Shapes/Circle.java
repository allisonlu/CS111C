public class Circle extends AbstractShape {
	private double radius;

	public Circle(double x, double y, double r) {
		super(x,y);
		radius = r;
	}

	// Java automatically invokes an inherited constructor
	public Circle() {
		radius = 0;
	}

	public Circle(double r) {
		this(0, 0, r);
	}

	public double getArea() {
		double area = Math.PI * (radius * radius);
		return area;
	}
}