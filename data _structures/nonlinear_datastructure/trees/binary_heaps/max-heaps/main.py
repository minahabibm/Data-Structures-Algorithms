# Python3 implementation of Min Heap 
import sys
class MaxHeap: 
  def __init__(self, maxsize): 
    self.maxsize = maxsize 
    self.size = 0
    self.Heap = [0]*(self.maxsize + 1) 
    self.Heap[0] = 1 * sys.maxsize 
    self.FRONT = 1

  def parent(self, pos): 
    return pos//2 
  def leftChild(self, pos): 
    return 2 * pos   
  def rightChild(self, pos): 
    return (2 * pos) + 1 
  def isLeaf(self, pos): 
    if pos >= (self.size//2) and pos <= self.size: 
      return True
    return False
  
    # Function to swap two nodes of the heap 
  
  def insert(self, element): 
    if self.size >= self.maxsize : 
      return
    self.size+= 1
    self.Heap[self.size] = element 
    current = self.size 
    while self.Heap[current] > self.Heap[self.parent(current)]: 
      self.swap(current, self.parent(current)) 
      current = self.parent(current) 
  def getMax(self):
    return self.Heap[1]

  def extractMax(self): 
    popped = self.Heap[self.FRONT] 
    self.Heap[self.FRONT] = self.Heap[self.size - 1]
    self.Heap.pop(self.size - 1)
    self.size -= 1
    self.maxHeapify(self.FRONT)
    return popped 
  def increaseKey(self, index,data):
      if (self.Heap[index] > data):
        return
      
      self.Heap[index] = data 
      while (index != 0 and self.Heap[index] > self.Heap[self.parent(index)] ):
        self.swap(index,self.parent(index))
        index = self.parent(index);      
  def deleteKey(self, pos):
    self.increaseKey(pos, sys.maxsize)
    self.extractMax()

  def maxHeapify(self, pos): 
    l = self.leftChild(pos); 
    r = self.rightChild(pos); 
    largest = pos; 
    if l < self.size and self.Heap[l] > self.Heap[pos]:
      largest = l
    
    if r < self.size and self.Heap[r] > self.Heap[largest]:
      largest = r; 
    
    if largest != pos:
      self.swap(pos, largest)
      self.maxHeapify(largest)
  def maxHeap(self): 
    for pos in range(self.size//2, 0, -1): 
      self.maxHeapify(pos) 
  
  def swap(self, fpos, spos): 
    self.Heap[fpos], self.Heap[spos] = self.Heap[spos], self.Heap[fpos] 

  def Print(self): 
    print(self.Heap)

    for i in range(1, (self.size//2) + 1):
      print(" PARENT : "+ str(self.Heap[i])+" LEFT CHILD : "+ str(self.Heap[2 * i])+" RIGHT CHILD : "+ str(self.Heap[2 * i + 1])) 
  
def main():
  def implemetation():
    print('The maxHeap is ') 
    maxHeap = MaxHeap(14) 
    arr = [12, 10, 9, 8, 15, 1, 3, 4, 6, 5, 17, 20]
    for i in arr:
      maxHeap.insert(i)

    maxHeap.Print()
    print(maxHeap.getMax())

    maxHeap.increaseKey(5, 10000)
    maxHeap.Print()

    print(maxHeap.getMax())
    print(maxHeap.extractMax())
    maxHeap.Print()

    maxHeap.deleteKey(6)
    print(" ")
    maxHeap.Print() 

  def libraryfun():
    #Using Library functions
    from heapq import heapify, heappush, heappop 
    # Creating empty heap 
    heap = [] 
    heapify(heap) 
    # Adding items to the heap using heappush function 
    heappush(heap, 10) 
    heappush(heap, 30) 
    heappush(heap, 20) 
    heappush(heap, 400) 
    # printing the value of minimum element 
    print("Head value of heap : "+str(heap[0])) 
      
    # printing the elements of the heap 
    print("The heap elements : ") 
    for i in heap: 
      print(i, end = ' ') 

    print("\n") 
    element = heappop(heap) 

    # printing the elements of the heap 
    print("The heap elements : ") 
    for i in heap: 
      print(i, end = ' ') 

  implemetation()
  #libraryfun()

# Driver Code 
if __name__ == "__main__":   
  main()