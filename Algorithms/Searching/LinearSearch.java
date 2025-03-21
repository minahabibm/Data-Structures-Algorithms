class LinearSearch {
  public static int linearSearch(int arr[], int x) {
    int n = arr.length;
    for (int i = 0; i < n; i++) 
      if (arr[i] == x) 
        return i;
    
    return -1;
  }
 
  public static void main(String[] args) {
    System.out.println("Linear Search");
    int arr[] = { 2, 3, 4, 10, 40 };
    int x = 10;

    // Function call
    int index = linearSearch(arr, x);
    String pos = index == -1 ? "Element not present" : "Element found at index " + index;
    System.out.println(pos);
    
  }
}