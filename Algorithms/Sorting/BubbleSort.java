import java.io.*; 
import java.util.Arrays;
  
class BubbleSort {

  public static void bubbleSort(int arr[], int n) { 
    int i, j, temp; 
    boolean swapped; 
    for (i = 0; i < n - 1; i++) { 
      swapped = false;
      for (j = 0; j < n - i - 1; j++) {  
        if (arr[j] > arr[j + 1]) { 
          temp = arr[j]; 
          arr[j] = arr[j + 1]; 
          arr[j + 1] = temp; 
          swapped = true; 
        }
      }
      if (swapped == false) 
        break;
    } 
  } 
  
  public static void main(String args[]) {
    System.out.println("Bubble Sort"); 
    int arr[] = { 64, 34, 25, 12, 22, 11, 90 }; 
    int n = arr.length; 
    bubbleSort(arr, n); 
    System.out.println(Arrays.toString(arr)); 
  } 

}