public class CountingSort {
  public void sort(int[] arr) {
    if (arr.length == 0)
      return;

    int maxValue = getMaxValue(arr);

    if (maxValue < 0)
      throw new IllegalArgumentException("Array contains negative values");

    int[] counterArr = new int[maxValue + 1];
    count(arr, counterArr);
    populateArr(arr, counterArr);

  }

  private void populateArr(int[] arr, int[] counterArr) {
    int pointer = 0;
    for (int i = 0; i < counterArr.length; ++i) {
      int occurrences = counterArr[i];
      for (int j = 0; j < occurrences; ++j) {
        arr[pointer++] = i;
      }
    }
  }

  private void count(int[] arr, int[] counterArr) {
    for (int num : arr)
      counterArr[num]++;
  }

  private int getMaxValue(int[] arr) {

    int maxValue = arr[0];
    for (int i = 1; i < arr.length; ++i)
      if (arr[i] < 0)
        return -1;
      else if (maxValue < arr[i])
        maxValue = arr[i];

    return maxValue;
  }

}