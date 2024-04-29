public class Main {
  public static void main(String[] args) {
    var tree = new AVLTree();
    tree.insert(20);
    tree.insert(10);
    tree.insert(30);
    tree.insert(15);
    tree.insert(12);
    tree.insert(11);

    tree.preOrderTraversal();
    System.out.println();
    tree.breadthTraversal();

  }
}