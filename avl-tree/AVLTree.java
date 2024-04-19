public class AVLTree {
  private AVLNode root;

  public void insert(int value) {
    root = insertInRightPosition(this.root, value);
  }

  private AVLNode insertInRightPosition(AVLNode root, int value) {
    if (root == null) {
      return new AVLNode(value);
    }

    if (value < root.value) {
      root.leftChild = insertInRightPosition(root.leftChild, value);

    } else {
      root.rightChild = insertInRightPosition(root.rightChild, value);
    }
    setNodeHeight(root);

    return balance(root);
  }

  private AVLNode balance(AVLNode root) {
    int balanceFactor = getBalanceFactor(root);
    if (isLeftHeavy(balanceFactor)) {
      if (getBalanceFactor(root.leftChild) < 0) {
        root.leftChild = rotateLeft(root.leftChild);
      }
      return rotateRight(root);

    } else if (isRightHeavy(balanceFactor)) {
      if (getBalanceFactor(root.rightChild) > 0) {
        root.rightChild = rotateRight(root.rightChild);
      }
      return rotateLeft(root);
    }
    return root;
  }

  private AVLNode rotateLeft(AVLNode root) {
    AVLNode newRoot = root.rightChild;
    root.rightChild = newRoot.leftChild;
    newRoot.leftChild = root;

    setNodeHeight(root);
    setNodeHeight(newRoot);
    return newRoot;
  }

  private AVLNode rotateRight(AVLNode root) {
    AVLNode newRoot = root.leftChild;
    root.leftChild = newRoot.rightChild;
    newRoot.rightChild = root;

    setNodeHeight(root);
    setNodeHeight(newRoot);
    return newRoot;
  }

  private void setNodeHeight(AVLNode node) {
    node.height = Math.max(
        getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
  }

  private int getBalanceFactor(AVLNode node) {
    return (node == null) ? 0 : getHeight(node.leftChild) - getHeight(node.rightChild);

  }

  private boolean isLeftHeavy(int balanceFactor) {
    return balanceFactor > 1;
  }

  private boolean isRightHeavy(int balanceFactor) {
    return balanceFactor < -1;
  }

  private int getHeight(AVLNode node) {
    return (node == null) ? -1 : node.height;
  }

  public void preOrderTraversal() {
    if (this.root == null) {
      throw new IllegalStateException("Tree is empty");
    }
    preOrderWalk(root);
  }

  private void preOrderWalk(AVLNode curr) {
    if (curr == null) {
      return;
    }
    System.out.println(curr.value);

    preOrderWalk(curr.leftChild);
    preOrderWalk(curr.rightChild);
  }

  private class AVLNode {
    private int value;
    private AVLNode leftChild;
    private AVLNode rightChild;
    private int height;

    public AVLNode(int val) {
      this.value = val;
      leftChild = rightChild = null;
    }

    @Override
    public String toString() {
      return "Value" + this.value;
    }
  }
}