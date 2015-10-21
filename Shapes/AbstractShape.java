/*
 * abstract class
 */

public abstract class AbstractShape implements ShapeInterface {
	
	private double x;
	private double y;
	private double area;

	public AbstractShape(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public AbstractShape() {
		x = y = 0;
		// or constructor chaining: this(0,0)
	}

	public void setX(double value) {
		x = value;
	}

	public void setY(double value) {
		y = value;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public abstract double getArea();

}