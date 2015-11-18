public class Main {

    public static void main(String[] args) {

        BinaryTree<String> leafK = new BinaryTree<String>("K");
        BinaryTree<String> leafJ = new BinaryTree<String>("J");
        BinaryTree<String> leafI = new BinaryTree<String>("I");
        BinaryTree<String> leafH = new BinaryTree<String>("H");
        BinaryTree<String> leafG = new BinaryTree<String>("G");
        BinaryTree<String> leafF = new BinaryTree<String>("F");

        BinaryTree<String> nodeE = new BinaryTree<String>("E", leafJ, leafK);
        BinaryTree<String> nodeD = new BinaryTree<String>("D", leafH, leafI);
        BinaryTree<String> nodeC = new BinaryTree<String>("C", leafF, leafG);
        BinaryTree<String> nodeB = new BinaryTree<String>("B", nodeD, nodeE);
        BinaryTree<String> nodeA = new BinaryTree<String>("A", nodeB, nodeC);

        nodeA.iterativePreorderTraverse();
    }
}
