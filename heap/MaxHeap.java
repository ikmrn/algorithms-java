import java.util.Arrays;

public class MaxHeap {
  int[] arr;
  int capacity;
  public int tail = 0;

  public MaxHeap(int capacity) {
    this.capacity = capacity;
    this.arr = new int[this.capacity];
  }

  public void insert(int value) {
    if (this.capacity == this.tail) {
      growArray();
    }
    arr[this.tail] = value;
    bubbleUp(this.tail);
    this.tail++;
  }

  private void bubbleUp(int idx) {
    while (idx > 0) {
      int parentIdx = getParentIdx(idx);
      if (this.arr[idx] <= this.arr[parentIdx]) {
        break;
      }
      swap(arr, idx, parentIdx);
      idx = parentIdx;
    }
  }

  public int remove() {
    if (this.tail == 0) {
      throw new IllegalStateException("Heap is empty");
    }
    int out = this.arr[0];
    this.tail--;
    if (this.tail == 0) {
      return out;
    }
    this.arr[0] = this.arr[this.tail];
    bubbleDown(0);
    return out;
  }

  private void bubbleDown(int idx) {
    while (hasLeftChild(idx)) {
      int leftChildIdx = getLeftIdx(idx);
      int rightChildIdx = getRightIdx(idx);
      int largestChildIdx = leftChildIdx;
      if (hasRightChild(idx) && this.arr[rightChildIdx] > this.arr[leftChildIdx]) {
        largestChildIdx = rightChildIdx;
      }
      if (this.arr[idx] > this.arr[largestChildIdx]) {
        break;
      } else {
        swap(this.arr, idx, largestChildIdx);

      }
      idx = largestChildIdx;
    }
  }

  private int getLeftIdx(int idx) {
    return idx * 2 + 1;
  }

  private int getRightIdx(int idx) {
    return idx * 2 + 2;
  }

  private boolean hasLeftChild(int idx) {
    return getLeftIdx(idx) < this.tail;
  }

  private boolean hasRightChild(int idx) {
    return getRightIdx(idx) < this.tail;
  }

  private void swap(int[] arr, int idxA, int idxB) {
    int temp = arr[idxA];
    arr[idxA] = arr[idxB];
    arr[idxB] = temp;
  }

  private int getParentIdx(int idx) {
    return (idx - 1) / 2;
  }

  private void growArray() {
    this.capacity *= 2;
    int[] newArr = new int[this.capacity];
    System.arraycopy(arr, 0, newArr, 0, this.tail);
    arr = newArr;
  }

  @Override
  public String toString() {
    return Arrays.toString(this.arr);
  }

  public String printString() {
    int[] newArr = new int[capacity];
    for (int i = 0; i < this.tail; ++i) {
      newArr[i] = arr[i];
    
    }
    return Arrays.toString(newArr);

  }
}