
public class Main{
  public static void main(String[] args) {
    PriorityQueueMax minHeap = new PriorityQueueMax(5);
    minHeap.insert(5);
    minHeap.insert(3);
    minHeap.insert(7);
    minHeap.insert(1);
    minHeap.insert(5);
    minHeap.insert(0);
    minHeap.insert(1);
    minHeap.insert(4);
    minHeap.insert(-2);
    System.out.println(minHeap.remove());
    System.out.println(minHeap);
  
    ;
  }
}