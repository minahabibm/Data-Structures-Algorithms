# Python3 implementation of Min Heap 
import sys
class MinHeap: 
  def __init__(self, maxsize): 
    self.maxsize = maxsize 
    self.size = 0
    self.Heap = [0]*(self.maxsize + 1) 
    self.Heap[0] = -1 * sys.maxsize 
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
    
  def insert(self, element): 
    if self.size >= self.maxsize : 
      return
    self.size+= 1
    self.Heap[self.size] = element 
    current = self.size 
    while self.Heap[current] < self.Heap[self.parent(current)]: 
      self.swap(current, self.parent(current)) 
      current = self.parent(current) 
  def getMin(self):
    return self.Heap[1]

  def extractMin(self): 
    popped = self.Heap[self.FRONT] 
    self.Heap[self.FRONT] = self.Heap[self.size - 1]
    self.Heap.pop(self.size - 1)
    self.size -= 1
    self.minHeapify(self.FRONT)

    return popped 
  def decreaseKey(self, index,data):
      if (self.Heap[index] < data):
        return
      
      self.Heap[index] = data 
      while (index != 0 and self.Heap[index] < self.Heap[self.parent(index)] ):
        self.swap(index,self.parent(index))
        index = self.parent(index);      
  def deleteKey(self, pos):
    self.decreaseKey(pos, -sys.maxsize - 1)
    self.extractMin()

  def minHeapify(self, pos): 
    l = self.leftChild(pos); 
    r = self.rightChild(pos); 
    smallest = pos; 
    if l < self.size and self.Heap[l] < self.Heap[pos]:
      smallest = l
    
    if r < self.size and self.Heap[r] < self.Heap[smallest]:
      smallest = r; 
    
    if smallest != pos:
      self.swap(pos, smallest)
      self.minHeapify(smallest)
  def minHeap(self): 
    for pos in range(self.size//2, 0, -1): 
      self.minHeapify(pos) 
  
  def swap(self, fpos, spos): 
    self.Heap[fpos], self.Heap[spos] = self.Heap[spos], self.Heap[fpos] 

  def Print(self): 
    print(self.Heap)

    for i in range(1, (self.size//2)):
      print(" PARENT : "+ str(self.Heap[i])+" LEFT CHILD : "+ str(self.Heap[2 * i])+" RIGHT CHILD : "+ str(self.Heap[2 * i + 1])) 
  
def main():
  def implemetation():
    print('The minHeap is ') 
    minHeap = MinHeap(14) 
    arr = [12, 10, 9, 8, 15, 1, 3, 4, 6, 5, 17, 20]
    for i in arr:
      minHeap.insert(i)

    minHeap.Print()
    print(minHeap.getMin())
    minHeap.decreaseKey(5, -10000)

    minHeap.Print()
    print(minHeap.getMin())
    print(minHeap.extractMin())

    minHeap.Print()  
    minHeap.deleteKey(6)
    print(" ")
    minHeap.Print() 

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