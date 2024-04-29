public class AVLTree {
  AvlNode root;

  public void insert(int value) {
    this.root = insertAtRightPosition(this.root, value);
  }

  public void breadthTraversal() {
    MyQueue<AvlNode> queue = new MyQueue<>();
    queue.enqueue(this.root);

    while (!queue.isEmpty()) {
      AvlNode node = queue.dequeue();
      System.out.println(node.value);

      if (node.leftChild != null) {
        queue.enqueue(node.leftChild);
      }
      if (node.rightChild != null) {
        queue.enqueue(node.rightChild);
      }
    }
  }

  public void preOrderTraversal() {
    preOrderWalk(this.root);
  }

  private void preOrderWalk(AvlNode node) {
    if (node == null) {
      return;
    }
    System.out.println(node.value);
    preOrderWalk(node.leftChild);
    preOrderWalk(node.rightChild);
  }

  private AvlNode insertAtRightPosition(AvlNode node, int value) {
    if (node == null) {
      return new AvlNode(value);
    }
    if (value < node.value) {
      node.leftChild = insertAtRightPosition(node.leftChild, value);
    } else {
      node.rightChild = insertAtRightPosition(node.rightChild, value);
    }

    setHeight(node);
    return balance(node);
  }

  private AvlNode balance(AvlNode node) {
    int balanceFactor = getBalanceFactor(node);
    if (isLeftHeavy(balanceFactor)) {
      if (getBalanceFactor(node.leftChild) < 0)
        node.leftChild = rotateLeft(node.leftChild);
      return rotateRight(node);
    }
    if (isRightHeavy(balanceFactor)) {
      if (getBalanceFactor(node.rightChild) > 0)
        node.rightChild = rotateRight(node.rightChild);
      return rotateLeft(node);
    }

    return node;
  }

  private AvlNode rotateLeft(AvlNode node) {
    AvlNode newNode = node.rightChild;
    node.rightChild = newNode.leftChild;
    newNode.leftChild = node;

    setHeight(node);
    setHeight(newNode);
    return newNode;
  }

  private AvlNode rotateRight(AvlNode node) {
    AvlNode newNode = node.leftChild;
    node.leftChild = newNode.rightChild;
    newNode.rightChild = node;

    setHeight(node);
    setHeight(newNode);
    return newNode;
  }

  private int getBalanceFactor(AvlNode node) {
    return getHeight(node.leftChild) - getHeight(node.rightChild);
  }

  private boolean isLeftHeavy(int value) {
    return value > 1;
  }

  private boolean isRightHeavy(int value) {
    return value < -1;
  }

  private void setHeight(AvlNode node) {
    node.height = maxHeight(
        getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
  }

  private int maxHeight(int a, int b) {
    return (a > b) ? a : b;
  }

  private int getHeight(AvlNode node) {
    return (node == null) ? 0 : node.height;
  }

  private class AvlNode {
    int value, height;
    AvlNode leftChild;
    AvlNode rightChild;

    public AvlNode(int value) {
      this.value = value;
      this.height = 1;
    }
  }

  private class MyQueue<E> {
    QueueNode<E> head;
    QueueNode<E> tail;

    public void enqueue(E node) {
      QueueNode<E> newNode = new QueueNode<>(node);
      if (this.tail == null) {
        this.head = this.tail = newNode;
      } else {
        this.tail.next = newNode;
        this.tail = newNode;
      }
    }

    public E dequeue() {
      if (this.tail == null) {
        throw new IllegalStateException("Queue is empty.");
      }
      E returnValue = this.head.item;
      if (this.head.next == null) {
        this.head = this.tail = null;
        return returnValue;
      }
      this.head = this.head.next;
      return returnValue;
    }

    public boolean isEmpty() {
      return this.head == null;
    }
  }

  private class QueueNode<T> {
    T item;
    QueueNode<T> next;

    public QueueNode(T item) {
      this.item = item;
      this.next = null;
    }
  }
}