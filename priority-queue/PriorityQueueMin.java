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
    if (isQueueFull()){
      growArray();
    }
    arr[this.length++] = item;
    heapifyUpMax();
  }

  public boolean isQueueFull(){
    return this.length == this.capacity;
  }

  private void growArray(){
    this.capacity *= 2;
    int[] newArr = new int[this.capacity];
    for (int i = 0; i < this.length; ++i){
      newArr[i] = arr[i];
    }
    arr = newArr;
  }

  public void heapifyUpMax(){
    int value = this.arr[this.length-1];
    int i;
    for (i = this.length - 2; i >= 0; --i){
      if (value > this.arr[i]){
        this.arr[i + 1] = this.arr[i];
      }
      else {
        break;
      }
    }
    arr[i + 1] = value;
  }
  public int remove() {
    if (isEmpty()){
      throw new IllegalStateException("Queue is empty");
    } 
    int value = arr[--this.length];
    this.arr[this.length] = 0;
    return value;
  }

  public boolean isEmpty(){
    return this.length == 0;
  }


  @Override
  public String toString(){
    return Arrays.toString(this.arr);
  }
}