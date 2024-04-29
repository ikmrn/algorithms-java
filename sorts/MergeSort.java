public class MergeSort {
  public void sort(int[] arr) {
    mergeSort(0, arr.length - 1, arr);
  }

  private void mergeSort(int leftIdx, int rightIdx, int[] arr) {
    if (leftIdx < rightIdx) {
      int midIdx = ((rightIdx - leftIdx) / 2) + leftIdx;
      mergeSort(leftIdx, midIdx, arr);
      mergeSort(midIdx + 1, rightIdx, arr);

      merge(leftIdx, rightIdx, midIdx, arr);
    }
  }

  private void merge(int leftIdx, int rightIdx, int midIdx, int[] arr) {
    int leftSize = midIdx - leftIdx + 1;
    int rightSize = rightIdx - midIdx;
    int[] leftArr = new int[leftSize];
    int[] rightArr = new int[rightSize];

    copyArray(arr, leftArr, leftIdx);
    copyArray(arr, rightArr, midIdx + 1);

    int rPointer = 0, lPointer = 0;
    int pointer = leftIdx;

    while (lPointer < leftSize && rPointer < rightSize) {
      if (leftArr[lPointer] < rightArr[rPointer]) {
        arr[pointer] = leftArr[lPointer];
        lPointer++;
      } else {
        arr[pointer] = rightArr[rPointer];
        rPointer++;
      }
      pointer++;
    }
    while (lPointer < leftSize) {
      arr[pointer] = leftArr[lPointer];
      lPointer++;
      pointer++;
    }
    while (rPointer < rightSize) {
      arr[pointer] = rightArr[rPointer];
      rPointer++;
      pointer++;
    }

  }

  private void copyArray(int[] arr, int[] emptyArr, int startIdx) {
    for (int i = 0; i < emptyArr.length; ++i) {
      emptyArr[i] = arr[startIdx];
      startIdx++;
    }
  }
}