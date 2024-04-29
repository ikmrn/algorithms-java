public class QuickSort {
  public void sort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  private void quickSort(int[] arr, int leftIdx, int rightIdx) {
    if (leftIdx >= rightIdx)
      return;

    int pivotIdx = partition(arr, leftIdx, rightIdx);

    quickSort(arr, leftIdx, pivotIdx - 1);
    quickSort(arr, pivotIdx + 1, rightIdx);
  }

  private int partition(int[] arr, int leftIdx, int rightIdx) {
    int pivotIdx = leftIdx + (rightIdx - leftIdx) / 2;
    int pivotValue = arr[pivotIdx];
    int pointer = leftIdx - 1;

    swap(arr, pivotIdx, rightIdx);

    for (int i = leftIdx; i < rightIdx; ++i)
      if (arr[i] < pivotValue)
        swap(arr, ++pointer, i);

    pointer++;
    swap(arr, pointer, rightIdx);
    return pointer;

  }

  private void swap(int[] arr, int idxA, int idxB) {
    int temp = arr[idxA];
    arr[idxA] = arr[idxB];
    arr[idxB] = temp;
  }
}