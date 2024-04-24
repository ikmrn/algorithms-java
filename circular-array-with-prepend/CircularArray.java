import java.util.Arrays;

public class CircularArray {
  int capacity;
  int head;
  int tail;
  int[] arr;

  public CircularArray(int capacity) {
    this.capacity = capacity;
    this.arr = new int[capacity];
    this.head = 0;
    this.tail = 0;
  }

  public void append(int value) {
    if ((this.tail + 1) % this.capacity == this.head) {
      growArray();
    }
    arr[this.tail] = value;
    this.tail = (this.tail + 1) % this.capacity;
  }

  public void prepend(int value) {
    if ((this.head - 1) % this.capacity== this.tail) {
      growArray();
    }
    this.head = ((this.head - 1) % this.capacity + this.capacity) % this.capacity;
    arr[this.head] = value;
  }

  public int removeFirst() {
    if (this.head == this.tail) {
      throw new IllegalStateException("List is empty.");
    }
    int outputValue = this.arr[this.head];
    this.arr[this.head] = 0;
    this.head = (this.head + 1) % this.capacity;

    return outputValue;
  }

  public int removeLast() {
    this.tail = (((this.tail - 1) % this.capacity) + this.capacity) % this.capacity;
    if (this.tail == this.head) {
      throw new IllegalStateException("List is empty.");
    }
    int outputValue = this.arr[this.tail];
    arr[this.tail] = 0;

    return outputValue;
  }

  @Override
  public String toString() {
    int[] printArr = new int[this.capacity];
    for (int i = this.head; i < this.tail; i = (i + 1) % this.capacity) {
      printArr[i] = arr[i];
    }
    return Arrays.toString(printArr);
  }

  public String toStringPrint() {
    int[] printArr = new int[this.capacity];
    for (int i = 0; i < this.capacity; ++i) {
      printArr[i] = this.arr[i];
    }
    return Arrays.toString(printArr);
  }

  private void growArray() {
    int[] newArray = new int[this.capacity * 2];
    int curr = this.head;
    int newIdx = 0;
    while (curr != this.tail) {
      newArray[newIdx] = arr[curr];
      curr = (curr + 1) % (this.capacity);
      newIdx++;
    }
    this.head = 0;
    this.tail = newIdx;
    this.capacity *= 2;
    arr = newArray;
  }
}