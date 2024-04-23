public class Heapify {
  public static void heapify(int[] arr) {
    // Not optimized solution more optimized to start from the deepest parent node
    // for (int i = 0, parents = arr.length / 2 - 1; i < parents; ++i) {
    // walkHeapify(arr, i);
    // }

    // Start from the deepest parent nodes to have fewer recursions
    for (int i = arr.length / 2 - 1; i >= 0; --i) {
      walkHeapify(arr, i);
    }
  }

  private static void walkHeapify(int[] arr, int idx) {
    int largerIdx = idx;
    int leftIdx = getLeftChildIdx(idx);
    int rightIdx = getRightChildIdx(idx);
    if (leftIdx < arr.length && arr[leftIdx] > arr[largerIdx]) {
      largerIdx = leftIdx;
    }
    if (rightIdx < arr.length && arr[rightIdx] > arr[largerIdx]) {
      largerIdx = rightIdx;
    }
    if (idx == largerIdx) {
      return;
    }
    swap(arr, idx, largerIdx);
    walkHeapify(arr, largerIdx);

  }

  private static void swap(int[] arr, int idxA, int idxB) {
    int temp = arr[idxA];
    arr[idxA] = arr[idxB];
    arr[idxB] = temp;
  }

  private static int getLeftChildIdx(int idx) {
    return idx * 2 + 1;
  }

  private static int getRightChildIdx(int idx) {
    return idx * 2 + 2;
  }
}