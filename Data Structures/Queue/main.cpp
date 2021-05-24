// FIFO
#include <iostream>
#include <cstdlib>
#include <queue>

using namespace std;
 
// Define the default capacity of a queue
#define SIZE 10
 
class queueImp {
  int *arr;       // array to store queue elements
  int capacity;   // maximum capacity of the queue
  int front;      // front points to the front element in the queue (if any)
  int rear;       // rear points to the last element in the queue
  int count;      // current size of the queue
 
  public:
    queueImp(int size = SIZE);     // constructor
    ~queueImp();                   // destructor

    void dequeue();
    void enqueue(int x);
    int peek();
    int size();
    bool isEmpty();
    bool isFull();
};
 
queueImp::queueImp(int size){
  arr = new int[size];
  capacity = size;
  front = 0;
  rear = -1;
  count = 0;
}
 
queueImp::~queueImp() {
  delete[] arr;
}
 
void queueImp::dequeue() {
  if (isEmpty()){
    cout << "Underflow\nProgram Terminated\n";
    exit(EXIT_FAILURE);
  }

  cout << "Removing " << arr[front] << endl;

  front = (front + 1) % capacity;
  count--;
}
 
void queueImp::enqueue(int item) {
  if (isFull()){
    cout << "Overflow\nProgram Terminated\n";
    exit(EXIT_FAILURE);
  }

  cout << "Inserting " << item << endl;

  rear = (rear + 1) % capacity;
  arr[rear] = item;
  count++;
}
 
int queueImp::peek() {
  if (isEmpty()) {
    cout << "Underflow\nProgram Terminated\n";
    exit(EXIT_FAILURE);
  }
  return arr[front];
}
 
int queueImp::size() {
  return count;
}
 
bool queueImp::isEmpty() {
  return (size() == 0);
}
 
bool queueImp::isFull() {
  return (size() == capacity);
}
 
int main() {
  queueImp q(5);

  q.enqueue(1);
  q.enqueue(2);
  q.enqueue(3);
  cout << "The front element is " << q.peek() << endl;
  q.dequeue();
  q.enqueue(4);
  cout << "The queue size is " << q.size() << endl;
  q.dequeue();
  q.dequeue();
  q.dequeue();
  if (q.isEmpty()) {
    cout << "The queue is empty\n";
  }
  else {
    cout << "The queue is not empty\n";
  }

  // STL queue
  queue<string> qu;
  
  qu.push("A");        
  qu.push("B");        
  qu.push("C");        
  qu.push("D");        
  cout << "The queue size is " << qu.size() << endl;
  cout << "The front element is " << qu.front() << endl;
  cout << "The rear element is " << qu.back() << endl;
  qu.pop();            
  qu.pop();            
  cout << "The queue size is " << qu.size() << endl;
  if (qu.empty()) {
    cout << "The queue is empty\n";
  }
  else {
    cout << "The queue is not empty\n";
  }

  return 0;
}