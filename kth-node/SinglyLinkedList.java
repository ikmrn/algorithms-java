import java.util.NoSuchElementException;

public class SinglyLinkedList{

    private class Node{
      private int value;
      private Node next;

      public Node(int value){
        this.value = value;
      }
    }

      private Node head;
      public int length;

      public void addFirst(int item){
        Node node = new Node(item);
        if (head == null){
          head = node;
        }
        else{
          node.next = head;
          head = node;
        }    
        length++;
      }

      public int removeFirst(){
        if (head == null){
          throw new NoSuchElementException("The list is empty");
        }
        int removedValue = head.value; 
        if (head.next == null){
          head = null;
        }
        else {
          Node temp = head.next;
          head = null;
          head = temp;
        }
        length--;
        return removedValue;
      }

      public void print(){
        Node curr = head;
        while(curr != null){
          System.out.println(curr.value);
          curr = curr.next;
        }
      }

      public int getKthFromTheEnd(int k) {
        if (k > length) {
          throw new IndexOutOfBoundsException("k is greater than the list");
        }
        int counter = 0;
        Node curr = head, Kth = head;
        while (curr != null){
          if (counter < k){
            curr = curr.next;
            counter++;
          }
          else {
            curr = curr.next;
            Kth = Kth.next;
            counter++;
          }
          
        }
      return Kth.value;
      }
}