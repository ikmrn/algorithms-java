public class Main {
  public static void main(String[] args) {
    MinHeap minHeap = new MinHeap(5);
    minHeap.insert(5);
    minHeap.insert(10);
    minHeap.insert(20);
    minHeap.insert(15);
    minHeap.insert(17);
    minHeap.insert(23);
    minHeap.insert(8);
    System.out.println(minHeap.remove());
    System.out.println(minHeap.remove());

    System.out.println(minHeap);
  }
}