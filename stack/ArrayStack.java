import java.util.Arrays;

public class ArrayStack {
  private int[] arr;
  public int length = 0;
  public int capacity;

  public ArrayStack(int capacity){
    arr = new int[capacity];
    this.capacity = capacity;
  }

  public void push(int item){
    if (length >= capacity){
      doubleArray();
    }
    arr[length++] =  item;
  }

  public void doubleArray(){
    this.capacity *= 2;
    int[] newArr  = new int[this.capacity];
    for (int i = 0; i < length; ++i){
      newArr[i] = arr[i];
    }
    arr = newArr;
  }

  public int pop(){
    if (length <= 0){
      throw new IllegalStateException("Stack is empty.");
    }
    return arr[--length];
  }
  public int peek() {
    if (length == 0){
      throw new IllegalStateException();
    }
    return arr[length - 1];
  }
  public boolean isEmpty() {
    return length <= 0;
  }

  @Override
  public String toString(){
    var content = Arrays.copyOfRange(arr, 0, length);
    return Arrays.toString(content);
  }


}