import java.util.Scanner;

public class RabbitGame {
	BinaryTreeInterface<String> root;
	BinaryTreeInterface<String> current;

	// constructor
	public RabbitGame {
		root = new BinaryTree("Rabbit");
	}

	public void play() {
		while (true) {
			makeAPassThroughTree();
		}
	}

	public void makeAPassThroughTree() {
	}

	// advance to a new tree. return null if game is over
	public BinaryTreeInterface<String> advance() {
		return null;
	}

	// change the current leaf node into a question node with children
	private void changeCurrentNodeToQuestion() {

	}

	// prompt code
	// yes no question
	private boolean yesNoQuestion(String question) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(question + " (y/n): ");
		return scanner.nextLine().equals("y");
	}

	// what is it? 
	// returns a string
	private String whatIsIt() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is it?:");
		return scanner.nextLine();
	}

	private String questionToDifferentiate(String newAnimal, String oldAnimal) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Give me a question that is true for " + newAnimal + " but not for " + oldAnimal + ": ");
		return scanner.nextLine();
	}
}