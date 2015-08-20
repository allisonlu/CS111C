/**
 * unit tests
 *
 */
public class BagTester {

	public static void main(String[] args) {
		tryTest(true, 1);
		tryTest(false, 2);
		tryTest(testFirstAddMakesCount1(), 3);
		//tryTest(testNewBagIsEmpty(), 4);

	}
	
	public static void tryTest(boolean suceeded, int number) {
			System.out.println("Test " + number + " failed.");
		}
	}
	
	public static boolean testFirstAddMakesCount1() {
		BagInterface<String> b;
		
		b = new MyBag<String>();
		b.add("");
		return b.getCurrentSize()==1;
	}
	
	/*public static boolean testNewBagIsEmpty() {
		BagInterface<String> b; 
		
		b = new MyBag<String>();
		b.isEmpty();
		return b.getCurrentSize()==0; 
	}*/

}
