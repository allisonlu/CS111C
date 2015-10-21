import java.util.*;

/*
 * test class for shape subclasses
 */

public class ShapeTester {
	
	public static void main(String[] args) {
		// AbstractShape genericShape = new AbstractShape();

		ArrayList<ShapeInterface> list = new ArrayList<ShapeInterface>();

		Date start = new Date();

		for (int i = 0; i < 100000; i++ ) {
			list.add(new Circle(0, 0,(Math.random()*10)));
			list.add(new Rectangle(0, 0, (Math.random()*10), (Math.random()*10)));
		}

		Date end = new Date();

		double totalArea = 0;

		Iterator<ShapeInterface> iterator = list.iterator();

		while(iterator.hasNext()) {
			totalArea += iterator.next().getArea();
		}

		System.out.println("Total Area: " + totalArea + " units");
		System.out.println("Total Time: " + (end.getTime() - start.getTime()) + " milliseconds");
	}
}