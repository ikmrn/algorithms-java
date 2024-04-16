import java.util.NoSuchElementException;

public class Stack {
  private class Node {
    int value;
    Node prev;

    public Node(int value) {
      this.value = value;
    }
  }

  public int length = 0;
  private Node tail;

  public void push(int item) {
    Node node = new Node(item);
    length++;
    if (tail == null) {
      tail = node;
      return;
    }
    node.prev = tail;
    tail = node;
  }

  public int pop() {
    if (tail == null){
      throw new NoSuchElementException("The list is empty");
    }
    int popValue = tail.value;
    if (tail.prev == null){
      tail = null;
    }
    else {
      Node temp = tail.prev;
      tail = null;
      tail = temp;
    }
    length--;
    return popValue;
  }

  public int peek() {
    return tail.value;
  }

  public boolean isEmpty() {
    return tail == null;
  }

}
