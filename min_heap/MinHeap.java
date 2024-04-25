import java.util.Arrays;

public class MinHeap {
  int[] arr;
  int capacity;
  int head;
  int tail;

  public MinHeap(int capacity) {
    this.capacity = capacity;
    this.head = this.tail = 0;
    this.arr = new int[this.capacity];
  }

  public void insert(int value) {
    if (this.tail == this.capacity) {
      growArray();
    }
    this.arr[this.tail] = value;

    heapifyUp(this.tail++);
  }

  public int remove() {
    if (this.tail == 0) {
      throw new IllegalStateException("Heap is empty");
    }
    int returnValue = this.arr[0];
    this.tail--;
    this.arr[0] = this.arr[this.tail];
    this.arr[this.tail] = 0;
    heapifyDown(0);
    return returnValue;
  }

  private void heapifyUp(int idx) {
    if (idx == 0) {
      return;
    }
    int parentIdx = getParentIdx(idx);
    if (this.arr[parentIdx] < this.arr[idx]) {
      return;
    }
    swap(this.arr, idx, parentIdx);
    heapifyUp(parentIdx);
  }

  private void heapifyDown(int idx) {
    if (!hasLeftChild(idx)) {
      return;
    }
    int leftChildIdx = getLeftChild(idx);
    int rightChildIdx = getRightChild(idx);
    int smallestChild = leftChildIdx;
    if (hasRightChild(idx) && this.arr[rightChildIdx] < this.arr[leftChildIdx]) {
      smallestChild = rightChildIdx;
    }
    if (this.arr[idx] < this.arr[smallestChild]){
      return;
    }
    swap(arr, idx, smallestChild);
    heapifyDown(smallestChild);

  }

  private int getLeftChild(int idx) {
    return idx * 2 + 1;
  }

  private int getRightChild(int idx) {
    return idx * 2 + 2;
  }

  private boolean hasLeftChild(int idx) {
    return getLeftChild(idx) < this.tail;
  }

  private boolean hasRightChild(int idx) {
    return getRightChild(idx) < this.tail;
  }

  private void growArray() {
    int[] newArr = new int[this.capacity * 2];
    for (int i = 0; i < this.capacity; ++i) {
      newArr[i] = arr[i];
    }
    this.capacity *= 2;
    arr = newArr;
  }

  private int getParentIdx(int idx) {
    return (idx - 1) / 2;
  }

  private void swap(int[] arr, int idxA, int idxB) {
    int temp = this.arr[idxA];
    this.arr[idxA] = this.arr[idxB];
    this.arr[idxB] = temp;
  }

  @Override
  public String toString() {
    return Arrays.toString(this.arr);
  }

}