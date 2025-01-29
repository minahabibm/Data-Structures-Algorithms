import java.util.Arrays;

class ShellSort {

  // Rearrange elements at each n/2, n/4, n/8, ... intervals
  public static void shellSort(int array[]) {
    int n  = array.length;
    for (int interval = n / 2; interval > 0; interval /= 2) {
      for (int i = interval; i < n; i += 1) {
        int temp = array[i];
        int j;
        for (j = i; j >= interval && array[j - interval] > temp; j -= interval) {
          array[j] = array[j - interval];
        }
        array[j] = temp;
      }
    }
  }

  // Driver code
  public static void main(String args[]) {
    System.out.println("Shell Sort");
    int[] arr = { 9, 8, 3, 7, 5, 6, 4, 1 };
    shellSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}