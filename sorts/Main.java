import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] arr = { 7, 3, 1, 4, 6, 2, 3 };
    int[] arrBubble = { 7, 3, 1, 4, 6, 2, 3 };
    int[] arrSelection = { 7, 3, 1, 4, 6, 2, 3 };
    int[] arrInsertion = { 7, 3, 1, 4, 6, 2, 3 };
    int[] arrMerge = { 7, 3, 1, 4, 6, 2, 3 };
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

  }
}