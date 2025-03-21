import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class BucketSort {
  
  public static void bucketSort(float[] arr) {
    int n = arr.length;
    if (n <= 0) return;
    
    ArrayList<Float>[] buckets = new ArrayList[n];
    // Create empty buckets
    for (int i = 0; i < n; i++)
      buckets[i] = new ArrayList<Float>();

    // Add elements into the buckets
    for (int i = 0; i < n; i++) {
      int bucketIndex = (int) arr[i] * n;
      buckets[bucketIndex].add(arr[i]);
    }

    // Sort the elements of each bucket
    for (int i = 0; i < n; i++) 
      Collections.sort((buckets[i]));

    // Get the sorted array
    int index = 0;
    for (ArrayList<Float> bucket : buckets) {
      for (float num : bucket) {
        arr[index++] = num;
      }
    }  
  }

  // Driver code
  public static void main(String[] args) {
    System.out.println("Bucket Sort"); 
    float[] arr = { 
      (float) 0.42, (float) 0.32, (float) 0.33, (float) 0.52, (float) 0.37, (float) 0.47, (float) 0.51 
    };
    bucketSort(arr);
    System.out.println(Arrays.toString(arr)); 
  }

}