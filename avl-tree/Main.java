public class Main {
  public static void main(String[] args) {
    AVLTree tree = new AVLTree();

    tree.insert(10);
    tree.insert(5);
    tree.preOrderTraversal();
    System.out.println();
    tree.insert(20);
    tree.insert(15);
    tree.insert(25);
    tree.insert(22);
    tree.preOrderTraversal();

  }
}