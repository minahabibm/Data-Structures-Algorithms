#include <iostream>
#include<climits> 

using namespace std;  

class MaxHeap{
  int *harr; // pointer to array of elements in heap 
  int capacity; // maximum possible size of min heap 
  int heap_size; // Current number of elements in min heap 

  public: 
    MaxHeap(int capacity) {  // Constructor 
      heap_size = 0; 
      harr = new int[capacity];
    } 

    int parent(int i) { return (i-1)/2; } 
    int left(int i) { return (2*i + 1); } 
    int right(int i) { return (2*i + 2); }

    void insertKey(int k);
    int extractMax(); 
    int getMax() { return harr[0]; } 
    void increaseKey(int i, int new_val); 
    void deleteKey(int i);
    void MaxHeapify(int ); // to heapify a subtree with the root at given index 

    void swap(int *x, int *y);
    void print();
}; 

void MaxHeap::insertKey(int k) { 
  if (heap_size == capacity) { 
    cout << "\nOverflow: Could not insertKey\n"; 
    return; 
  } 
  
  // First insert the new key at the end 
  heap_size++; 
  int i = heap_size - 1; 
  harr[i] = k; 
  
  // Fix the min heap property if it is violated 
  while (i != 0 && harr[i] > harr[parent(i)]) { 
    swap(&harr[i], &harr[parent(i)]); 
    i = parent(i); 
  } 
} 

void MaxHeap::increaseKey(int i, int new_val) { 
  harr[i] = new_val; 
  while (i != 0 && harr[parent(i)] < harr[i]) { 
    swap(&harr[i], &harr[parent(i)]); 
    i = parent(i); 
  } 
} 
int MaxHeap::extractMax() { 
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
  
  MaxHeapify(0); 

  return root; 
} 

void MaxHeap::deleteKey(int i) { 
  increaseKey(i, INT_MAX); 
  extractMax(); 
}

void MaxHeap::MaxHeapify(int i) { 
  int l = left(i); 
  int r = right(i); 
  int largest = i; 
  if (l < heap_size && harr[l] > harr[i]) {
    largest = l; 
  }
  if (r < heap_size && harr[r] > harr[largest]) {
    largest = r; 
  }
  if (largest != i) { 
    swap(&harr[i], &harr[largest]); 
    MaxHeapify(largest); 
  } 
} 

void MaxHeap::swap(int *x, int *y) { 
  int temp = *x; 
  *x = *y; 
  *y = temp; 
} 

void MaxHeap::print() { 
  for (int i = 0; i <= heap_size ; i++) { 
    cout << harr[i] << " " ; 
  } 
  cout << endl; 
  for (int i = 0; i <= (heap_size / 2) - 1  ; i++) { 
    cout << " PARENT : " << harr[i] << " LEFT CHILD : " << harr[2 * i + 1]  << " RIGHT CHILD :" << harr[2 * i + 2] << endl; 
  } 
} 


int main() {
  std::cout << "The Max Heap is \n";

  MaxHeap maxHeap(12);
  int num[12] = { 12, 10, 9, 8, 15, 1, 3, 4, 6, 5, 17, 20 };
  for (int i = 0; i < 12; i++){
    maxHeap.insertKey(num[i]);
  }

  maxHeap.print();
  cout << maxHeap.getMax() << endl; 

  maxHeap.increaseKey(5, 1000000000);
  maxHeap.print();

  cout << maxHeap.getMax() << endl;

  cout << "The Max value is " << maxHeap.extractMax() << endl; 
  maxHeap.print();

  maxHeap.deleteKey(6);
  cout << "\n"<< endl;
  maxHeap.print();

  return 0; 
}
