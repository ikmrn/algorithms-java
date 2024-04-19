public class MaxHeap {
  int[] arr;
  int capacity;
  int tail;

  public MaxHeap(int capacity) {
    this.arr = new int[capacity];
  }

  public void insert(int value) {

  }

  private void growArray() {
    this.capacity *= 2;
    int[] newArr = new int[this.capacity];
    for (int i = 0; i < this.tail; ++i) {
      newArr[i] = arr[i];
    }
    arr = newArr;
  }
}