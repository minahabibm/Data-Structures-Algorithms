class Queue_ {
  private int[] arr;      
  private int front;      
  private int rear;       
  private int capacity;   
  private int count;      

  Queue_() {}
  Queue_(int size) {
    arr = new int[size];
    capacity = size;
    front = 0;
    rear = -1;
    count = 0;
  }

  public void dequeue() {
    if (isEmpty()) {
      System.out.println("Underflow\nProgram Terminated");
      System.exit(1);
    }

    System.out.println("Removing " + arr[front]);

    front = (front + 1) % capacity;
    count--;
  }

  public void enqueue(int item) {
    if (isFull()) {
      System.out.println("Overflow\nProgram Terminated");
      System.exit(1);
    }

    System.out.println("Inserting " + item);

    rear = (rear + 1) % capacity;
    arr[rear] = item;
    count++;
  }

  public int peek() {
    if (isEmpty()) {
      System.out.println("Underflow\nProgram Terminated");
      System.exit(1);
    }
    return arr[front];
  }

  public int size() {
    return count;
  }

  public Boolean isEmpty() {
    return (size() == 0);
  }

  public Boolean isFull() {
    return (size() == capacity);
  }
 
  public static void main (String[] args) {
    Queue_ q = new Queue_(5);

    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    System.out.println("The front element is " + q.peek());
    q.dequeue();
    System.out.println("The front element is " + q.peek());
    System.out.println("The queue size is " + q.size());
    q.dequeue();
    q.dequeue();
    if (q.isEmpty()) {
      System.out.println("The queue is empty");
    }
    else {
      System.out.println("The queue is not empty");
    } 
  }
}