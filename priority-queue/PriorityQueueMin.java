import java.util.Arrays;

public class PriorityQueueMin{
  private int length = 0;
  private int capacity;
  private int[] arr;

  public PriorityQueueMin(int capacity){
    this.capacity = capacity;
    this.arr = new int[this.capacity];
  }

  public void insert(int item){
    if (this.length == this.capacity){
      growArray();
    }
    arr[this.length++] = item;
    heapifyUpMax();
  }

  private void growArray(){
    this.capacity *= 2;
    int[] newArr = new int[this.capacity];
    for (int i = 0; i < this.length; ++i){
      newArr[i] = arr[i];
    }
    arr = newArr;
  }

}