import java.util.Arrays;

public class PriorityQueueMax{
  private int[] arr;
  private int capacity;
  private int length = 0;

  public PriorityQueueMax(int capacity){
    this.capacity = capacity;
    this.arr = new int[this.capacity];
  }
  public void insert(int item){
    if (this.length == this.capacity){
      growArray();
    }
    arr[this.length++] = item;
    heapifyUp();
  }

  public void growArray() {
    this.capacity *= 2;
    int[] newArr = new int[this.capacity];
    for (int i = 0; i < this.length; ++i){
      newArr[i] = arr[i];
    }
    arr = newArr;
  }

  private void heapifyUp(){
    int value = this.arr[this.length - 1];
    int i;
    for (i = this.length - 2; i >= 0; --i){
      if (this.arr[i] > value){
        this.arr[i + 1] = this.arr[i]; 
      }
      else {
        break;
      }
    }
    this.arr[i + 1] = value; 
  }
  public int remove(){
    if (isEmpty()){
      throw new IllegalStateException("Queue is empty");
    }
    this.length--;
    int returnValue = arr[this.length];
    this.arr[this.length] = 0;
    return returnValue;
  }
  public boolean isEmpty(){
    return this.length == 0;
  }

@Override
public String toString(){
  return Arrays.toString(this.arr);
}

}