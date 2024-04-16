import java.util.Arrays;

public class ArrayQueue{
  private int[] items;
  private int capacity;
  public int rear = 0;
  public int front = 0;

  public ArrayQueue(int capacity){
    this.items = new int[capacity];
    this.capacity = capacity;
  }

  public void enqueue(int item){
    if (rear == capacity){
      growArray();
    }
    items[rear++] = item;
  }

  public void growArray(){
    this.capacity *= 2;
    int[] newArray = new int[this.capacity];
    for (int i = 0; i < this.rear; ++i){
      newArray[i] = items[i];
    }
    items = newArray;
  }

  public int dequeue(){
    if (this.front >= this.rear){
      throw new IllegalStateException("The queue is empty");
    }
    return items[this.front++]; 
  }

  @Override
  public String toString(){
    int size = this.rear - this.front;
    int[] printArray = new int[size];
    for (int i = 0; i < size; ++i){
      printArray[i] = this.items[i + this.front];
    }
    return Arrays.toString(printArray);
  }
}