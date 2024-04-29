public class BubbleSort {
  public void sort(int[] arr) {
    boolean isSorted;
    for (int i = 0; i < arr.length - 1; ++i) {
      isSorted = true;
      for (int j = 0; j < arr.length - 1 - i; ++j) {
        if (arr[j] > arr[j + 1]) {
          swap(j, j + 1, arr);
          isSorted = false;
        }
      }
      if (isSorted) {
        return;
      }
    }
  }

  private void swap(int idxA, int idxB, int[] arr) {
    int temp = arr[idxA];
    arr[idxA] = arr[idxB];
    arr[idxB] = temp;
  }
}