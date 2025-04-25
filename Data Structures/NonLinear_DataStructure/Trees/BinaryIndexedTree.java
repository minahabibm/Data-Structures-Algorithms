// Fenwick Tree
// Change the value stored at an index i. (This is called a point update operation)
// Find the sum of a prefix of length k.  (This is called a range sum query)

public class BinaryIndexedTree{
  private int size;
  private int[] BITree;
  
  BinaryIndexedTree(){};

  BinaryIndexedTree(int inputArray[]){
    this.size = inputArray.length;  
    this.BITree = new int[this.size + 1];
    for(int i = 0; i < this.size; i++)
      update(i, inputArray[i]);
  }

  public void update(int index, int delta) {
    int idx = index + 1;                         // index in BITree[] is 1 more than the index in arr[]
    // Traverse all ancestors and add 'val'
    while(idx <= this.size) {
      this.BITree[idx] += delta;                 // Add 'val' to current node of BIT Tree
      idx += (idx & -idx);                       // Update index to that of parent in update View, isolates the least significant bit (LSB) that is set to 1 in the binary representation of idx
    }
  };
  
  public int query(int index) {
    int sum = 0;                                // Initialize result
    int idx = index + 1;                        // index in BITree[] is 1 more than the index in arr[]
    // Traverse ancestors of BITree[index]
    while(idx > 0) {
      sum += this.BITree[idx];                  // Add current element of BITree to sum
      idx -= (idx & -idx);                      // Move index to parent node in getSum View
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