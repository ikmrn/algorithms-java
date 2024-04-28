import java.util.Arrays;

public class RingBuffer {
  int head, tail, length, capacity;
  int[] arr;

  public RingBuffer(int capacity) {
    this.capacity = capacity;
    this.head = this.tail = this.length;
    this.arr = new int[this.capacity];
  }

  public void append(int value) {
    if (this.length == this.capacity) {
      growArray();
    }
    this.arr[this.tail] = value;
    this.tail = (this.tail + 1) % this.capacity;
    this.length++;
  }

  public void prepend(int value) {
    if (this.length == this.capacity) {
      growArray();
    }
    head = ((this.head - 1) + this.capacity) % this.capacity;
    this.arr[head] = value;
    this.length++;
  }

  public int removeFirst() {
    if (this.length == 0){
      throw new IllegalStateException("Buffer is empty");
    }
    int returnValue = this.arr[this.head];
    this.arr[this.head] = 0;
    this.head = (this.head + 1) % this.capacity;
    this.length--;
    return returnValue;
  }

  public int removeLast() {
    if (this.length == 0){
      throw new IllegalStateException("Buffer is empty");
    }
    this.tail = ((this.tail - 1) + this.capacity) % this.capacity;
    int returnValue = this.arr[this.tail];
    this.arr[this.tail] = 0;
    this.length--;
    return returnValue;

  }

  private void growArray() {
    int[] newArr = new int[this.capacity * 2];
    int idx = 0;
    var curr = this.head;
    for (; idx < this.length; ++idx) {
      newArr[idx] = this.arr[curr];
      curr = (curr + 1) % this.capacity;
    }
    this.capacity *= 2;
    this.head = 0;
    this.tail = idx;
    this.arr = newArr;
  }

  @Override
  public String toString() {
    return Arrays.toString(this.arr);
  }
}