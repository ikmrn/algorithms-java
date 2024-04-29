public class InsertionSort {
  public void sort(int[] arr) {
    for (int i = 1; i < arr.length; ++i) {
      int valueJ = arr[i];
      int j = i - 1;
      while (j >= 0 && valueJ < arr[j]) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = valueJ;

    }
  }
}
