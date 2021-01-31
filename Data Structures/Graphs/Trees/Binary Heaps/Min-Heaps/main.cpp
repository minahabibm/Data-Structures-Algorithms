#include <iostream>
#include<climits> 

using namespace std;  

class MinHeap{
  int *harr; // pointer to array of elements in heap 
  int capacity; // maximum possible size of min heap 
  int heap_size; // Current number of elements in min heap 

  public: 
    MinHeap(int capacity) {  // Constructor 
      heap_size = 0; 
      harr = new int[capacity];
    } 

    int parent(int i) { return (i-1)/2; } 
    int left(int i) { return (2*i + 1); } 
    int right(int i) { return (2*i + 2); }

    void insertKey(int k);
    int extractMin(); 
    int getMin() { return harr[0]; } 
    void decreaseKey(int i, int new_val); 
    void deleteKey(int i);
    void MinHeapify(int ); // to heapify a subtree with the root at given index 

    void swap(int *x, int *y);
    void print();
}; 

// Inserts a new key 'k' 
void MinHeap::insertKey(int k) { 
  if (heap_size == capacity) { 
    cout << "\nOverflow: Could not insertKey\n"; 
    return; 
  } 
  
  // First insert the new key at the end 
  heap_size++; 
  int i = heap_size - 1; 
  harr[i] = k; 
  
  // Fix the min heap property if it is violated 
  while (i != 0 && harr[i] < harr[parent(i)]) { 
    swap(&harr[i], &harr[parent(i)]); 
    i = parent(i); 
  } 
} 

// Decreases value of key at index 'i' to new_val.  It is assumed that 
// new_val is smaller than harr[i]. 
void MinHeap::decreaseKey(int i, int new_val) { 
  harr[i] = new_val; 
  while (i != 0 && harr[parent(i)] > harr[i]) { 
    swap(&harr[i], &harr[parent(i)]); 
    i = parent(i); 
  } 
} 
// Method to remove minimum element (or root) from min heap 
int MinHeap::extractMin() { 
  if (heap_size <= 0){
    return INT_MAX; 
  } 
    
  if (heap_size == 1) { 
    heap_size--; 
    return harr[0]; 
  } 
  
  // Store the minimum value, and remove it from heap 
  int root = harr[0]; 
  harr[0] = harr[heap_size-1]; 
  harr[heap_size-1] = 0;
  heap_size--; 
  
  MinHeapify(0); 

  return root; 
} 
// This function deletes key at index i. It first reduced value to minus 
// infinite, then calls extractMin() 
void MinHeap::deleteKey(int i) { 
  decreaseKey(i, INT_MIN); 
  extractMin(); 
}

// A recursive method to heapify a subtree with the root at given index 
// This method assumes that the subtrees are already heapified 
void MinHeap::MinHeapify(int i) { 
  int l = left(i); 
  int r = right(i); 
  int smallest = i; 
  if (l < heap_size && harr[l] < harr[i]) {
    smallest = l; 
  }
  if (r < heap_size && harr[r] < harr[smallest]) {
    smallest = r; 
  }
  if (smallest != i) { 
    swap(&harr[i], &harr[smallest]); 
    MinHeapify(smallest); 
  } 
} 

void MinHeap::swap(int *x, int *y) { 
  int temp = *x; 
  *x = *y; 
  *y = temp; 
} 

void MinHeap::print() { 
  for (int i = 0; i <= heap_size ; i++) { 
    cout << harr[i] << " " ; 
  } 
  cout << endl; 
  for (int i = 0; i <= (heap_size / 2) - 1 ; i++) { 
    cout << " PARENT : " << harr[i] << " LEFT CHILD : " << harr[2 * i + 1]  << " RIGHT CHILD :" << harr[2 * i + 2] << endl; 
  } 
} 


int main() {
  std::cout << "Hello World!\n";

  MinHeap minHeap(12);
  int num[12] = { 12, 10, 9, 8, 15, 1, 3, 4, 6, 5, 17, 20 };
  for (int i = 0; i < 12; i++){
    minHeap.insertKey(num[i]);
  }

  minHeap.print();
  cout << minHeap.getMin() << endl; 

  minHeap.decreaseKey(5, -1000000000);
  minHeap.print();

  cout << minHeap.getMin() << endl;

  cout << minHeap.extractMin() << endl; 
  minHeap.print();

  minHeap.deleteKey(6);
  cout << "\n"<< endl;
  minHeap.print();

  return 0; 
}
