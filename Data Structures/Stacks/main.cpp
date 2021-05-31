// LIFO
#include <iostream>
#include <cstdlib>
#include <stack>
#include <list>

using namespace std;
 
// Define the default capacity of the stack
#define SIZE 10
 
// A class to represent a stack
class stackImp {
  int *arr;
  int top;
  int capacity;
 
  public:
    stackImp(int size = SIZE);         
    ~stackImp();                      

    void push(int);
    int pop();
    int peek();

    int size();
    bool isEmpty();
    bool isFull();
};
 
stackImp::stackImp(int size) {
  arr = new int[size];
  capacity = size;
  top = -1;
}
 
stackImp::~stackImp() {
  delete[] arr;
}
 
void stackImp::push(int x) {
  if (isFull()){
    cout << "Overflow\nProgram Terminated\n";
    exit(EXIT_FAILURE);
  }

  cout << "Inserting " << x << endl;
  arr[++top] = x;
}
 
int stackImp::pop() {
  // check for stack underflow
  if (isEmpty()) {
    cout << "Underflow\nProgram Terminated\n";
    exit(EXIT_FAILURE);
  }

  cout << "Removing " << peek() << endl;
  // decrease stack size by 1 and (optionally) return the popped element
  return arr[top--];
}
 
int stackImp::peek() {
  if (!isEmpty()) {
    return arr[top];
  }
  else {
    exit(EXIT_FAILURE);
  }
}
 
int stackImp::size() {
  return top + 1;
}
 
bool stackImp::isEmpty() {
  return top == -1;               
}
 
bool stackImp::isFull() {
  return top == capacity - 1;     
}
 
int main() {
  cout << "stack implemetation\n";
  stackImp pt(3);
  pt.push(1);
  pt.push(2);
  pt.pop();
  pt.pop();
  pt.push(3);
  cout << "The top element is " << pt.peek() << endl;
  cout << "The stack size is " << pt.size() << endl;
  pt.pop();
  if (pt.isEmpty()) {
    cout << "The stack is empty\n";
  }
  else {
    cout << "The stack is not empty\n";
  }
  cout <<"\n";

  // STL
  cout << "stack STL\n";
  stack<string> s;
  s.push("A");    
  s.push("B");    
  s.push("C");    
  s.push("D");    
  cout << "The stack size is " << s.size() << endl;
  cout << "The top element is " << s.top() << endl;
  s.pop();        
  s.pop();        
  cout << "The stack size is " << s.size() << endl;
  if (s.empty()) {
    cout << "The stack is empty\n";
  }
  else {
    cout << "The stack is not empty\n";
  }
  cout <<"\n";

  // Stack using List
  cout << "stack using List\n";
  list<string> sl;
  sl.push_front("A");        
  sl.push_front("B");        
  sl.push_front("C");        
  sl.push_front("D");        
  cout << "The stack size is " << sl.size() << endl;
  cout << "The top element is " << sl.front() << endl;

  sl.pop_front();          
  sl.pop_front();          
  cout << "The stack size is " << s.size() << endl;
  if (sl.empty()) {
    cout << "The stack is empty\n";
  }
  else {
    cout << "The stack is not empty\n";
  }

  return 0;
}