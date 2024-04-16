import java.util.Arrays;

public class ArrayStack{
  private int capacity;
  public int tail = 0;
  private int[] arr;

  public ArrayStack(int capacity){
    this.capacity = capacity;
    arr = new int[capacity];
  }

  public void push(int item){
    if (this.tail == this.capacity) {
      growArray();
    }
    arr[this.tail++] = item;
  }

  public void growArray() {
    this.capacity *= 2;
    int[] newArr = new int[this.capacity];
    for (int i = 0; i < this.tail; ++i){
      newArr[i] = arr[i];
    }
    arr = newArr;
  }

  public int pop(){
    if (this.tail == 0) {
      throw new IllegalStateException("The stack is empty");
    }
    return this.arr[--this.tail];

  }

  public int[] getArray(){
    int[] returnArray = new int[this.tail];
    for (int i = 0; i < this.tail; i++){
      returnArray[i] = arr[i];
    }
    return returnArray;
    }
    @Override
    public String toString(){
      int[] returnArray = getArray();
      return Arrays.toString(returnArray);
    }
}