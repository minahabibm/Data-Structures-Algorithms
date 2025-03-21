import java.io.*;
import java.util.Arrays;

class QuickSort{
  
  public void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public int partition(int[] arr, int low, int high) {
    int pivot = arr[high];                                          // Choose the pivot element
    int index = (low - 1);                                          // Index of smaller element 
    for(int j = low; j < high; j++) {                              
      if (arr[j] < pivot)                                           // If the current element is smaller than the pivot, 
        swap(arr, ++index, j);                                      // swap it with the element at 'index + 1' and increment 'index' to move the boundary of the smaller elements
    }
    swap(arr, ++index, high);                                       // Place the pivot element in its correct position by swapping it with the element at 'index + 1' After this step, all elements smaller than the pivot will be on the left side and greater elements on the right.
    return index;
  }
  
  public void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int pivotIndex = partition(arr, low, high);

      quickSort(arr, low, pivotIndex - 1);
      quickSort(arr, pivotIndex + 1, high);
    }
  }

  public static void main(String[] args) {
    System.out.println("Quick Sort");
    int[] arr = { 10, 7, 8, 9, 1, 5 };
    new QuickSort.quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }
}