public class Main {
	public static void main(String[] args) {
		ArrayStack arrayStack = new ArrayStack(10);
		arrayStack.push(10);
		arrayStack.push(20);
		arrayStack.push(30);

		while(!arrayStack.isEmpty()) {
			int topEntry = theStack.pop();
			System.out.println(topEntry);
			System.out.println(" ");
		}
		System.out.println("");
	}
}