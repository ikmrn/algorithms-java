import java.util.NoSuchElementException;

public class LinkList{
  private class Node {
    private int value;
    private Node next;
    private Node prev;

    public Node(int value){
      this.value = value;
    }
  }

  private Node first;
  private Node last;
  public int length;

  public void addFirst(int item){
    Node node = new Node(item);
    if (first == null){
      first = last = node;
    }
    else{
      node.next = first;
      first.prev = node;
      first = node;
    }
    length++;
  }
  
  public void addLast(int item){
    var node = new Node(item);
    if (last == null) 
      first = last = node;
    else {
      last.next = node;
      node.prev = last;
      last = node;
    }
    length++;
  }

  public void print(){
    if (length == 0) {
      System.out.println("List is empty");
      return;
    }
    Node curr = first;
    while (curr != null){
      System.out.println(curr.value);
      curr = curr.next;
    }
  }

  public int removeFirst(){
    if (first == null){
      throw new NoSuchElementException("List is empty");
    }
    int removedValue = first.value;
    length--;
    if (first.next != null){
      first.next.prev = null;
      first = first.next;
      return removedValue;
    }
    first = last = null;
    return removedValue;
  }

  public int removeLast(){
    if (last == null){
      throw new NoSuchElementException("List is empty");
    }
    int removedValue = last.value;
    length--;
    if (last.prev != null){
      last.prev.next = null;
      last = last.prev;
      return removedValue;
    }
    first = last = null;
    return removedValue;

  }


  public int indexOf(int value){
    Node curr = first;
    int idx = 0;
    while (curr != null){
      if (curr.value == value){
        return idx;
      }
      curr = curr.next;
      idx++;
    }
    return -1;
  }
  public boolean contains(int value){
    return indexOf(value) != -1;
  }

  public int[] toArray() {
    int [] array = new int[length];
    Node curr = first;
    int idx = 0;
    while (curr != null){
      array[idx++] = curr.value;
      curr = curr.next;
    }
    return array;
  }

  public void reverse(){
    if (first == null){
      throw new NoSuchElementException("List is empty.");
    }
    if (first.next == null){
      return;
    }
    // Node curr = first;
    Node nextNode = null, previous = null;
    Node curr = first;
    while(curr != null){
      nextNode = curr.next;
      curr.next = previous;
      curr.prev = nextNode;
      previous = curr;
      curr = nextNode;
    }
    last = first;
    first = previous;
  }

}