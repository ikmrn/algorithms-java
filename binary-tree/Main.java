import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Tree tree0 = new Tree();
    Tree tree1 = new Tree();
    Tree tree2 = new Tree();
    tree0.insert(7);
    tree0.insert(4);
    tree0.insert(6);
    tree0.insert(1);
    tree0.insert(9);
    tree0.insert(8);
    tree0.insert(10);
    // tree1 = tree0
    tree1.insert(7);
    tree1.insert(4);
    tree1.insert(6);
    tree1.insert(1);
    tree1.insert(9);
    tree1.insert(8);
    tree1.insert(10);
    // tree2 != tree0
    tree2.insert(7);
    tree2.insert(4);
    tree2.insert(6);
    tree2.insert(1);
    tree2.insert(9);
    tree2.insert(8);
    tree2.insert(10);
    // tree2.insert(8);
    System.out.println("PRE ORDER TRAVERSAL");
    tree0.preOrderTraversal();
    System.out.println("IN ORDER TRAVERSAL");
    tree0.inOrderTraversal();
    System.out.println("POST ORDER TRAVERSAL");
    tree0.postOrderTraversal();
    System.out.println("BREADTH FIRST SEARCH");
    tree0.breadthFirstTraversal();
    System.out.println("FIND MIN");
    System.out.println(tree0.findMinValue());
    System.out.println("EQUALITY CHECKING");
    System.out.println(tree0.equals(tree1));
    System.out.println(tree0.equals(tree2));
    System.out.println("IS BINARY TREE");
    System.out.println(tree0.isBinarySearchTree());
    tree0.addToLastRightLeaf(3);
    System.out.println("PRE ORDER TRAVERSAL");
    tree0.preOrderTraversal();
    System.out.println(tree0.isBinarySearchTree());
    System.out.println("PRINT Kth NODES");
    ArrayList<Integer> arr = tree0.getNodesAtKDistance(3);

    for (var item : arr) {
      System.out.println(item);
    }

  }

}