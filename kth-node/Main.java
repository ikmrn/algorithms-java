
public class Main {
  public static void main(String[] args) {
    var list = new SinglyLinkedList();
    list.addFirst(5);
    list.addFirst(6);
    list.addFirst(4);
    list.addFirst(2);
    list.addFirst(12);
    list.print();
    System.out.println("Kth");
    int val = list.getKthFromTheEnd(3);
    System.out.println(val);
  }
}
