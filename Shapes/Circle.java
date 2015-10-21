public class Circle extends AbstractShape {
	private double radius;

	public Circle(double x, double y, double r) {
		super(x,y);
		radius = r;
	}

	// Java automatically invokes an inherited constructor
	public Circle() {
		super();
		radius = 0;
	}

	public double getArea() {
		double area = Math.PI * (radius * radius);
		return area;
	}
}