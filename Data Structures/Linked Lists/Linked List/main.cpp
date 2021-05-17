#include <iostream>

using namespace std;

struct Node{
  int data;
  Node *next;
};

class linkedList {
  private:
    Node *head,*tail;
  public:
    linkedList(){
      head = NULL;
      tail = NULL;
    }
    void addNode(int data);
    bool search(int key);      
    bool deleteNode(int key);
    void display();
};

void linkedList::addNode(int data){
  Node *tmp = new Node;
  tmp->data = data;
  tmp->next = NULL;

  if(head == NULL){
    head = tmp;
    tail = tmp;
  }else{
    tail->next = tmp;
    tail = tail->next;
  }
}

bool linkedList::search(int key){
  Node *cur = head;
  while(cur) {
    if(cur->data == key) return true;
    cur = cur->next;
  }
  cout << "No Node " << key << " in list.\n";
  return false;
}

bool linkedList::deleteNode( int key) {
  Node *temp = head, *prev;

  if (temp != NULL && temp->data == key) {
    head = temp->next;
    free(temp);
    return true;
  }
  // Find the key to be deleted
  while (temp != NULL && temp->data != key) {
    prev = temp;
    temp = temp->next;
  }

  // If the key is not present
  if (temp == NULL) return false;

  // Remove the node
  prev->next = temp->next;

  free(temp);
  return true;
}

void linkedList::display(){
 if (head == NULL) {
    cout << "List is empty!" << endl;
  }
  else {
    Node* temp = head;
    while (temp != NULL) {
      cout << temp->data << " ";
      temp = temp->next;
    }
    cout << endl;
  }
}

int main()
{
  linkedList a;
  a.addNode(0);
  a.addNode(1);
  a.addNode(2);
  a.addNode(3);
  a.addNode(4);
  a.addNode(5);
  a.display();
  cout << a.search(1) << endl;
  a.deleteNode(0);
  a.display();
  return 0;
}