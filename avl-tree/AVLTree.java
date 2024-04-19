public class AVLTree {
  private AVLNode root;


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