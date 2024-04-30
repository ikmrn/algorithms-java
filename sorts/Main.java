import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] arr = { 7, 3, 1, 4, 6, 2, 3 };
    int[] arrBubble = { 7, 3, 1, 4, 6, 2, 3 };
    int[] arrSelection = { 7, 3, 1, 4, 6, 2, 3 };
    int[] arrInsertion = { 7, 3, 1, 4, 6, 2, 3 };
    int[] arrMerge = { 7, 3, 1, 4, 6, 2, 3 };
    int[] arrQuick = { 7, 3, 1, 4, 6, 2, 3 };
    int[] arrCounting = { 7, 3, 1, 4, 6, 2, 3 };
    int[] arrBucket = { 7, 3, 1, 4, 6, 2, 323, 3 };
    System.out.println("Original array:  " + Arrays.toString(arr));

    BubbleSort bubbleSorter = new BubbleSort();
    bubbleSorter.sort(arrBubble);
    System.out.println("Bubble sort:     " + Arrays.toString(arrBubble));

    SelectionSort selectionSorter = new SelectionSort();
    selectionSorter.sort(arrSelection);
    System.out.println("Selection sort:  " + Arrays.toString(arrSelection));

    InsertionSort insertionSorter = new InsertionSort();
    insertionSorter.sort(arrInsertion);
    System.out.println("Insertion sort:  " + Arrays.toString(arrInsertion));

    MergeSort MergeSorter = new MergeSort();
    MergeSorter.sort(arrMerge);
    System.out.println("Merge sort:      " + Arrays.toString(arrMerge));

    QuickSort QuickSorter = new QuickSort();
    QuickSorter.sort(arrQuick);
    System.out.println("Quick sort:      " + Arrays.toString(arrQuick));

    CountingSort CountingSorter = new CountingSort();
    CountingSorter.sort(arrCounting);
    System.out.println("Counting sort:   " + Arrays.toString(arrCounting));

    BucketSort BucketSorter = new BucketSort();
    BucketSorter.sort(arrBucket, 3);
    System.out.println("Bucket sort:     " + Arrays.toString(arrBucket));

  }
}