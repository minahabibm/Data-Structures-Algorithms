import java.util.Arrays;

class SelectionSort {
  
  public static void selectionSort(int arr[]) {
    int n = arr.length;  
    for (int i = 0; i < n-1; i++) {
      int min_idx = i;
      for (int j = i+1; j < n; j++)
        if (arr[j] < arr[min_idx])
          min_idx = j;
      int temp = arr[min_idx];
      arr[min_idx] = arr[i];
      arr[i] = temp;
    }
  }
  
  public static void main(String args[]) {
    System.out.println("selection Sort");
    int arr[] = {64,25,12,22,11};
    selectionSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}