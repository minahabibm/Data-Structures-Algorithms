import java.util.*;

class MaxHeap { 
  private ArrayList<Integer> Heap;
  private int size; 
  
  private static final int FRONT = 1; 

  public MaxHeap() {
    Heap = new ArrayList<Integer>();
    this.size = 0; 
    this.Heap.add(Integer.MAX_VALUE);
  };
  public MaxHeap(Integer arr[]) {
    Heap = new ArrayList<Integer>(Arrays.asList(arr));
  };
  
  private int parent(int pos) { 
    return (int) Math.floor(pos / 2);
  } 
  private int leftChild(int pos) { 
    return (2 * pos); 
  } 
  private int rightChild(int pos) { 
    return (2 * pos) + 1; 
  } 

  public void insert(int element) { 
    this.Heap.add(element);
    ++size;
    //Heap[++size] = element; 
    // Heap[current] Heap[parent(current)]
    int current = size; 
    while (this.Heap.get(current) > this.Heap.get(parent(current))) { 
      swap(current, parent(current)); 
      current = parent(current); 
    } 
  } 
  public int getMax(){
    return this.Heap.get(FRONT);
  }

  public int extractMax() { 
    int popped = this.Heap.get(FRONT);
    this.Heap.set(FRONT , this.Heap.get(--size));
    this.Heap.remove(size);
    maxHeapify(FRONT); 
    return popped; 
  } 
  public void increaseKey(int index, int data) {
    if (this.Heap.get(index) > data){
      return;
    }
    this.Heap.set(index, data); 
    while (index != 0 && this.Heap.get(index) > this.Heap.get(parent(index)) ) {
      swap(index,parent(index));
      index = parent(index);
    }
  } 
  public void deleteKey(int pos) { 
    increaseKey(pos, Integer.MAX_VALUE);
    extractMax(); 
  } 

  private void maxHeapify(int pos) { 
    int l = this.leftChild(pos); 
    int r = this.rightChild(pos); 
    int largest = pos; 
    if ( l < this.size && this.Heap.get(l) > this.Heap.get(pos) ){
      largest = l;
    }
      
    if ( r < this.size && this.Heap.get(r) > this.Heap.get(largest) ) {
      largest = r; 
    }
    
    if (largest != pos) {
      this.swap(pos, largest);
      this.maxHeapify(largest);
    }
      
     /** 
    if (!isLeaf(pos)) { 
      if ( this.Heap.get(pos) > this.Heap.get(leftChild(pos)) || this.Heap.get(pos) > this.Heap.get(rightChild(pos)) ) { 
        if ( this.Heap.get(leftChild(pos)) < this.Heap.get(rightChild(pos)) ) { 
          swap(pos, leftChild(pos)); 
          maxHeapify(leftChild(pos)); 
        } 
        else { 
          swap(pos, rightChild(pos)); 
          maxHeapify(rightChild(pos)); 
        } 
      } 
    }
    */ 
  }
  public void maxHeap() { 
    for (int pos = (size / 2); pos >= 1; pos--) { 
      maxHeapify(pos); 
    } 
  } 

  private void swap(int fpos, int spos) { 
    int tmp; 
    tmp = this.Heap.get(fpos);//Heap[fpos]; 
    this.Heap.set(fpos ,this.Heap.get(spos) ); //Heap[fpos] = Heap[spos]; 
    this.Heap.set(spos ,tmp ); //Heap[spos] = tmp;
  } 
  
  public void print() { 
    System.out.print(this.Heap);
    System.out.print("\n");
    for (int i = 1; i <= size / 2 ; i++) { 
      int x = (2 * i + 1) <= size ? this.Heap.get(2 * i + 1) : 0 ;
      System.out.print(" PARENT : " + this.Heap.get(i) + " LEFT CHILD : " + this.Heap.get(2 * i)  + " RIGHT CHILD :" + x ); 
      System.out.println(); 
    } 
  } 

  // Driver code 
  public static void main(String[] arg) { 
    System.out.println("The Max Heap is "); 

    Integer intArray[] = { 12, 10, 9, 8, 15, 1, 3, 4, 6, 5, 16, 25};
    MaxHeap maxHeap = new MaxHeap(intArray); 
    for (int i = 0; i < intArray.length; i++) {
      maxHeap.insert(intArray[i]);
    }

    maxHeap.print(); 
    System.out.println(maxHeap.getMax());
    
    maxHeap.increaseKey(5, 1000000);
    maxHeap.print(); 

    System.out.println(maxHeap.getMax());  
    
    System.out.println("The Max val is " + maxHeap.extractMax()); 
    maxHeap.print(); 
    
    maxHeap.deleteKey(6);
    System.out.println("    "); 
    maxHeap.print();
  } 
}

class MinHeap { 
  private ArrayList<Integer> Heap;
  private int size; 
  
  private static final int FRONT = 1; 

  public MinHeap() {
    Heap = new ArrayList<Integer>();
    this.size = 0; 
    this.Heap.add(Integer.MIN_VALUE); 
  };
  public MinHeap(Integer arr[]) { 
    Heap = new ArrayList<Integer>(Arrays.asList(arr));
  } 

  private int parent(int pos) { 
    return (int) Math.floor(pos / 2);
  } 
  private int leftChild(int pos) { 
    return (2 * pos); 
  } 
  private int rightChild(int pos) { 
    return (2 * pos) + 1; 
  } 

  public void insert(int element) {  
    this.Heap.add(element);
    ++size;
    //Heap[++size] = element; 
    // Heap[current] Heap[parent(current)]
    int current = size; 
    while (this.Heap.get(current) < this.Heap.get(parent(current))) { 
      swap(current, parent(current)); 
      current = parent(current); 
    } 
  } 
  public int getMin(){
    return this.Heap.get(FRONT);
  }

  public int extractMin() { 
    int popped = this.Heap.get(FRONT);
    this.Heap.set(FRONT , this.Heap.get(--size));
    this.Heap.remove(size);
    minHeapify(FRONT); 
    return popped; 
  } 
  public void decreaseKey(int index, int data) {
    if (this.Heap.get(index) < data){
      return;
    }
    this.Heap.set(index, data); 
    while (index != 0 && this.Heap.get(index) < this.Heap.get(parent(index)) ) {
      swap(index,parent(index));
      index = parent(index);
    }
  } 
  public void deleteKey(int pos) { 
    decreaseKey(pos, -Integer.MIN_VALUE);
    extractMin(); 
  } 

  private void minHeapify(int pos) { 
    int l = this.leftChild(pos); 
    int r = this.rightChild(pos); 
    int smallest = pos; 
    if ( l < this.size && this.Heap.get(l) < this.Heap.get(pos) ){
      smallest = l;
    }
      
    if ( r < this.size && this.Heap.get(r) < this.Heap.get(smallest) ) {
      smallest = r; 
    }
    
    if (smallest != pos) {
      this.swap(pos, smallest);
      this.minHeapify(smallest);
    }
      
     /** 
    if (!isLeaf(pos)) { 
      if ( this.Heap.get(pos) > this.Heap.get(leftChild(pos)) || this.Heap.get(pos) > this.Heap.get(rightChild(pos)) ) { 
        if ( this.Heap.get(leftChild(pos)) < this.Heap.get(rightChild(pos)) ) { 
          swap(pos, leftChild(pos)); 
          minHeapify(leftChild(pos)); 
        } 
        else { 
          swap(pos, rightChild(pos)); 
          minHeapify(rightChild(pos)); 
        } 
      } 
    }
    */ 
  } 
  public void minHeap() { 
    for (int pos = (size / 2); pos >= 1; pos--) { 
      minHeapify(pos); 
    } 
  } 

  private void swap(int fpos, int spos) { 
    int tmp; 
    tmp = this.Heap.get(fpos);//Heap[fpos]; 
    this.Heap.set(fpos ,this.Heap.get(spos) ); //Heap[fpos] = Heap[spos]; 
    this.Heap.set(spos ,tmp ); //Heap[spos] = tmp;
  } 
  
  public void print() { 
    System.out.print(this.Heap);
    System.out.print("\n");
    for (int i = 1; i <= size / 2 ; i++) { 
      int x = (2 * i + 1) <= size ? this.Heap.get(2 * i + 1) : 0 ;
      System.out.print(" PARENT : " + this.Heap.get(i) + " LEFT CHILD : " + this.Heap.get(2 * i)  + " RIGHT CHILD :" + x ); 
      System.out.println(); 
    } 
  } 

  // Driver code 
  public static void main(String[] arg) { 
    System.out.println("The Min Heap is "); 

    int intArray[] = { 12, 10, 9, 8, 15, 1, 3, 4, 6, 5, 17, 20};
    MinHeap minHeap = new MinHeap(); 
    for (int i = 0; i < intArray.length; i++) {
      minHeap.insert(intArray[i]);
    }

    minHeap.print(); 
    System.out.println(minHeap.getMin());
    
    minHeap.decreaseKey(5, -1000000);
    minHeap.print(); 

    System.out.println(minHeap.getMin());  
    
    System.out.println("The Min val is " + minHeap.extractMin()); 
    minHeap.print(); 
    
    minHeap.deleteKey(6);
    System.out.println("    "); 
    minHeap.print();
  } 
}

public class BinaryHeaps { 
  // Driver code
  public static void main(String[] args) {
    new MaxHeap().main(args);
    new MinHeap().main(args);
  } 
}