import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
  public void sort(int[] array, int numberOfBuckets) {
    int maxValue = getMaxValue(array);
    var i = 0;
    for (var bucket : createBuckets(array, numberOfBuckets, maxValue)) {
      Collections.sort(bucket);
      for (var item : bucket)
        array[i++] = item;
    }
  }

  private List<List<Integer>> createBuckets(
      int[] array, int numberOfBuckets, int maxValue) {
    List<List<Integer>> buckets = new ArrayList<>();
    for (var i = 0; i < numberOfBuckets; i++)
      buckets.add(new ArrayList<>());

    for (var item : array)
      buckets.get(item * numberOfBuckets / (maxValue + 1)).add(item);

    return buckets;
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
