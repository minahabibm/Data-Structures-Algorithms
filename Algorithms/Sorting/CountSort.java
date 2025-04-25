import java.util.Arrays;

class CountSort {
  
  public static void countSort(int[] array) {
    int size = array.length;
    
    if (size == 0) return;

    int[] output = new int[size + 1];

    // Find max and min elements
    int min = array[0], max = array[0];
    for (int i = 1; i < size; i++) {
      if (array[i] > max) max = array[i];
      if (array[i] < min) min = array[i];
    }

    // range= (max−min) + 1
    int range = max - min + 1;                     // Range of elements
    int[] count = new int[range];

    // Populate count array
    for (int num : array) 
      count[num - min]++;                         // Shift values by subtracting min

    // Convert count to prefix sum
    for (int i = 1; i < range; i++) 
      count[i] += count[i - 1];

    // Build sorted array using count array
    for (int i = size - 1; i >= 0; i--) {
      int index = count[array[i] - min] - 1;      // Store the computed index
      output[index] = array[i];                   // Place the element at correct position
      count[array[i] - min]--;                    // Decrement count for stability
    }

    System.arraycopy(output, 0, array, 0, size);
  }

  // Driver code
  public static void main(String args[]) {
    System.out.println("Count Sort");
    int[] arr = { 4, 2, 2, 8, 3, 3, 1 };
    countSort(arr);
    System.out.println(Arrays.toString(arr)); 
  }
}