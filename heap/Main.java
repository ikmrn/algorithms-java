import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    MaxHeap heap = new MaxHeap(5);
    heap.insert(5);
    heap.insert(7);
    heap.insert(10);
    heap.insert(10);
    heap.insert(20);
    heap.insert(40);
    heap.insert(33);
    heap.insert(30);
    System.out.println(heap.printString());
    System.out.println(heap.tail);

    heap.remove();
    System.out.println(heap.printString());
    System.out.println(heap.tail);
    System.out.println();

    heap.remove();
    System.out.println(heap.printString());
    System.out.println(heap.tail);

    heap.remove();
    System.out.println(heap.printString());
    System.out.println(heap.tail);
    heap.remove();
    System.out.println(heap.printString());
    System.out.println(heap.tail);
    heap.remove();
    System.out.println(heap.printString());
    System.out.println(heap.tail);
    heap.remove();
    heap.remove();
    heap.remove();
    System.out.println(heap.printString());
    System.out.println(heap.tail);
    System.out.println("<<<<<< HEAPIFY >>>>>>>");
    int[] numbers = { 5, 3, 8, 4, 1, 2,  7, 1};
    System.out.println(Arrays.toString(numbers));
    Heapify.heapify(numbers);
    System.out.println(Arrays.toString(numbers));
  }

}