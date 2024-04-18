public class Tree {
  TreeNode root;

  /**
   * Inserts a new node with the given value into the binary tree.
   *
   * @param value the value to insert
   */

  public void insert(int value) {
    TreeNode node = new TreeNode(value);
    if (root == null) {
      root = node;
      return;
    }
    TreeNode curr = root;
    while (true) {
      if (value < curr.value) {
        if (curr.leftChild == null) {
          curr.leftChild = node;
          break;
        }
        curr = curr.leftChild;
      } else {
        if (curr.rightChild == null) {
          curr.rightChild = node;
          break;
        }
        curr = curr.rightChild;
      }
    }
  }

  /**
   * Checks if the given value exists in the binary tree.
   *
   * @param value the value to find
   * @return true if the value exists, false otherwise
   */
  public boolean find(int value) {
    if (root == null) {
      throw new IllegalStateException("Tree is empty.");
    }
    TreeNode curr = root;
    while (curr != null) {
      if (curr.value == value) {
        return true;
      }
      if (value < curr.value) {
        curr = curr.leftChild;
      } else
        curr = curr.rightChild;
    }
    return false;
  }

  // Traversal types
  public enum TraversalType {
    PRE_ORDER,
    POST_ORDER,
    IN_ORDER
  }

  /**
   * Performs a pre-order traversal of the binary tree.
   */
  public void preOrderTraversal() {
    if (root == null) {
      throw new IllegalStateException("Tree is empty.");
    }
    walk(root, TraversalType.PRE_ORDER);
  }

  /**
   * Performs a in-order traversal of the binary tree.
   */
  public void inOrderTraversal() {
    if (root == null) {
      throw new IllegalStateException("Tree is empty.");
    }
    walk(root, TraversalType.IN_ORDER);
  }

  /**
   * Performs a post-order traversal of the binary tree.
   */
  public void postOrderTraversal() {
    if (root == null) {
      throw new IllegalStateException("Tree is empty.");
    }
    walk(root, TraversalType.POST_ORDER);
  }

  // Helper method for pre-order traversal
  private void walk(TreeNode curr, TraversalType type) {
    if (curr == null)
      return;

    if (isPreOrder(type)) {
      System.out.println(curr.value);
    }

    walk(curr.leftChild, type);

    if (isInOrder(type)) {
      System.out.println(curr.value);
    }

    walk(curr.rightChild, type);

    if (isPostOrder(type)) {
      System.out.println(curr.value);
    }
  }

  private boolean isPreOrder(TraversalType type){
    return type == TraversalType.PRE_ORDER;
  }
  private boolean isInOrder(TraversalType type){
    return type == TraversalType.IN_ORDER;
  }
  private boolean isPostOrder(TraversalType type){
    return type == TraversalType.POST_ORDER;
  }

  private class TreeNode {
    int value;
    TreeNode rightChild;
    TreeNode leftChild;

    public TreeNode(int value) {
      this.value = value;
      this.rightChild = this.leftChild = null;
    }
  }
}