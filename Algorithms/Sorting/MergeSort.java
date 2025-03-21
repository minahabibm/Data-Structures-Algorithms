import java.util.Arrays;

class MergeSort {
  public static void merge(int arr[], int l, int m, int r) {
    int n1 = m - l + 1, n2 = r - m;
    int leftArr[] = new int[n1], rightArr[] = new int[n2];

    /*Copy data to temp arrays*/
    for (int i = 0; i < n1; ++i)
      leftArr[i] = arr[l + i];
    for (int i = 0; i < n2; ++i)
      rightArr[j] = arr[m + 1 + i];
    
    /* Merge the temp arrays */
    int i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {
      if (leftArr[i] <= rightArr[j])
        arr[k++] = leftArr[i++];
      else
        arr[k++] = rightArr[j++];        
    }

    // Copy remaining elements of leftArr if any
    while (i < n1) {
      arr[k++] = leftArr[i++];
    }
    // Copy remaining elements of rightArr[] if any
    while (j < n2) {
      arr[k++] = rightArr[j++];
    }
  }
 
  public static void sort(int arr[], int l, int r) {
    if (l < r) {
      // Find the middle point
      int m =l + (r - l) / 2;
      // Sort first and second halves
      sort(arr, l, m);
      sort(arr, m + 1, r);
      // Merge the sorted halves
      merge(arr, l, m, r);
    }
  }
 
  // Driver code
  public static void main(String args[]) {
    System.out.println("Merge Sort");
    int arr[] = { 12, 15, 14, 5, 6, 7 };
    sort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }
}