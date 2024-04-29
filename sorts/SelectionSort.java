public class SelectionSort {
  public void sort(int[] arr) {
    for (int i = 0; i < arr.length; ++i) {
      int smallestIdx = i;
      int smallestValue = arr[i];
      for (int j = 1 + i; j < arr.length; ++j) {
        if (smallestValue > arr[j]) {
          smallestIdx = j;
          smallestValue = arr[j];
        }
      }
      swap(i, smallestIdx, arr);

    }
  }

  private void swap(int idxA, int idxB, int[] arr) {
    int temp = arr[idxA];
    arr[idxA] = arr[idxB];
    arr[idxB] = temp;
  }
}