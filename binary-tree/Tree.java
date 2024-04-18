public class Tree {
  TreeNode root;

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

  public void preOrderTraversal() {
    if (root == null) {
      throw new IllegalStateException("Tree is empty.");
    }
    walk(root);
  }

  // Helper method for pre-order traversal
  private void walk(TreeNode curr) {
    if (curr == null)
      return;

    System.out.println(curr.value);
    walk(curr.leftChild);
    walk(curr.rightChild);
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