// Binary search works only on a sorted set of elements.
class BinarySearch {

  // Binary search recursively
  public static int  binarySearch(int arr[], int target, int l, int r) { 
    if (r >= l) { 
      int mid = l + (r - l) / 2; 
      if (arr[mid] == target) 
        return mid; 
      
      if (arr[mid] > x) 
        return binarySearch(arr, target, mid - 1); 
               
      return binarySearch(arr, target, mid + 1, r); 
    } 
    return -1; 
  }

  // Binary search iteratively
  public static int binarySearch(int arr[], int target) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] == target)
        return mid;
      else if (arr[mid] < target)
        low = mid + 1;
      else
        high = mid - 1;    
    }
    return -1;
  }


  public static void main(String[] args) {
    System.out.println("Binary Search"); 
    int arr[] = { 2, 3, 4, 10, 40 }; 
    int n = arr.length; 
    int x = 10; 
    int index = binarySearch(arr, x, 0, n - 1);
    String pos = index == -1 ? "Element not present" : "Element found at index " + index;  
    System.out.println(pos); 
    
  } 
}
