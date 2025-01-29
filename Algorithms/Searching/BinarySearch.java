class BinarySearch {
  // Binary search works only on a sorted set of elements.
  public static int  binarySearch(int arr[], int l, int r, int x) { 
    if (r >= l) { 
      int mid = l + (r - l) / 2; 
      if (arr[mid] == x) 
        return mid; 
      
      if (arr[mid] > x) 
        return binarySearch(arr, l, mid - 1, x); 
               
      return binarySearch(arr, mid + 1, r, x); 
    } 
    return -1; 
  }

  public static void main(String[] args) {
    System.out.println("Binary Search"); 
    int arr[] = { 2, 3, 4, 10, 40 }; 
    int n = arr.length; 
    int x = 10; 
    int index = binarySearch(arr, 0, n - 1, x);
    String pos = index == -1 ? "Element not present" : "Element found at index " + index;  
    System.out.println(pos); 
    
  } 
}
