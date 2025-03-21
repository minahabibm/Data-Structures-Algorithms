// Fenwick Tree
// Change the value stored at an index i. (This is called a point update operation)
// Find the sum of a prefix of length k.  (This is called a range sum query)

public class BinaryIndexedTree{
  final static int MAX = 1000;
  static int BITree[] = new int[MAX]; 
  
  BinaryIndexedTree(){};

  BinaryIndexedTree(int arr[]){
    // Initialize BITree[] as 0
    for(int i=1; i <= arr.length; i++)
      BITree[i] = 0;
    // Store the actual values in BITree[] using update()
    for(int i = 0; i < arr.length; i++)
      update(i, arr[i]);
  };

  public void update(int index, int delta) {
    // index in BITree[] is 1 more than the index in arr[]
    index = index + 1;
  
    // Traverse all ancestors and add 'val'
    while(index <= BITree.length) {
      BITree[index] += delta;      // Add 'val' to current node of BIT Tree
      index += index & (-index);  // Update index to that of parent in update View
    }
  };
  
  public int query(int index) {
    int sum = 0;         // Initialize result
    index = index + 1;   // index in BITree[] is 1 more than the index in arr[]
  
    // Traverse ancestors of BITree[index]
    while(index>0) {
      sum += BITree[index];       // Add current element of BITree to sum
      index -= index & (-index);  // Move index to parent node in getSum View
    }
    return sum;
  };

  public static void main(String[] args) {
    System.out.println("Binary Index Tree or Fenwick Tree");

    int freq[] = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
    BinaryIndexedTree BIT = new BinaryIndexedTree(freq); 
    System.out.println("Sum of elements in arr[0..5] is "+ BIT.query(5));
         
    // Let use test the update operation
    freq[3] += 6;
     
    // Update BIT for above change in arr[]
    BIT.update(3, 6);

    // Find sum after the value is updated
    System.out.println("Sum of elements in arr[0..5] after update is " + BIT.query(5));
  }
}