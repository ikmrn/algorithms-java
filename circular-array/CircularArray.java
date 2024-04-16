import java.util.Arrays;

public class CircularArray{
  private int[] items;
  private int capacity;
  public int length = 0;
  private int head = 0, tail = 0;

  public CircularArray(int capacity){
    this.items = new int[capacity];
    this.capacity = capacity;
  }

  public void enqueue(int item){
    if (this.length == this.capacity){
      growArray();
    }
    items[this.tail++ % this.capacity] = item;
    this.length++;
  }

  public int dequeue(){
    if (this.length == 0){
      throw new IllegalStateException("The queue is empty");
    }
    int item = items[this.head % this.capacity];
    items[this.head % this.capacity] = 0;
    this.head++;
    this.length--;
    return item;
  }

  public void growArray(){
    this.capacity *= 2;
    int[] newArray = new int[this.capacity];
    for (int i = 0; i < this.length; ++i){
      newArray[i] = items[(i + this.head) % this.length];
    }
    items = newArray;
    this.head = 0;
    this.tail = this.length;
  }

  public int peek(){
    if (this.length == 0){
      throw new IllegalStateException("The queue is empty");
    }
    return items[this.head];
  }
  public boolean isEmpty(){
    return this.length == 0;
  }

  @Override
  public String toString(){
    return Arrays.toString(this.items);
  }
}