#include <iostream>
#include <queue> 


using namespace std; 

struct Node { 
  int key; 
  Node *left; 
  Node *right; 
  Node (int x) 
  { 
    key = x; 
    left = NULL; 
    right = NULL; 
  }
}; 

class BSTree{
  Node *root;
  public:
    BSTree(){
      root= NULL;
    }
    void insert(int key);
    bool search(int key);      
    void deleteNode(int key);
    void inOrder();
    void levelOrder();
  private:
    void insert(int key, Node *root);
    bool search(int key, Node *root);
    void deleteNode(int Key, Node*& root);
    struct Node* minValueNode(struct Node* node);
    void inOrder(Node* root);
    void levelOrder(Node* root);

};

void BSTree::insert(int key) {
  if (root == NULL){
    root = new Node(key);
  }else{
    insert(key, root); 
  }
};
void BSTree::insert(int key, Node *temp) {
  /** based on Definition ofBST if it allows duplicate keys
  if (key == temp->key){
    return false;
  }
  */
      
  if(key <= temp->key ){
    if(temp->left == NULL){
      temp->left = new Node(key);
      cout << "node " << key << " inserted to the left of " << temp->key<<endl;
      //return true;
    }else{
      return insert(key,temp->left);
    }

  }else if(key > temp->key ){
    if(temp->right == NULL){
      temp->right = new Node(key);
      cout << "node " << key << " inserted to the right of " << temp->key<<endl;
      //return true;
    }else{
      return insert(key,temp->right);
    }

  }
  //return false;
} 

bool BSTree::search(int key){
  return search(key,root);
};
bool BSTree::search(int key, Node *root){ 
  //traverse the tree in preorder
  if (root == NULL){
    return false; 
  }
  if (root->key == key){
    return true; 
  }
  if(key <= root->key){
    return search(key,root->left);
  }else if(key > root->key){
    return search(key,root->right);
  }
  return false;
}

void BSTree::deleteNode(int key){
  deleteNode(key, root);
}
struct Node* BSTree::minValueNode(Node* node) { 
  Node* current = node; 
  /* loop down to find the leftmost leaf */
  while (current && current->left != NULL) {
    current = current->left; 
  }
  return current; 
} 
void BSTree::deleteNode(int key, Node*& node){
  if(node == NULL){
    return ;
  }
  if(key < node->key){
    return deleteNode(key, node->left);
  }else if(key > node->key){
    return deleteNode(key, node->right);
  }else{
    Node *temp = nullptr;
    if (node->left == NULL) {
      temp = node;
      node = node->right;
    }else if (node->right == NULL) {
      temp = node;
      node = node->left; 
    }else{
      temp = minValueNode(node->right); 
      node->key = temp->key; 
      deleteNode(temp->key, node->right); 
    }

    if(temp != nullptr){
      delete temp;
    };
        
  } 
  return; 
};



///**
void BSTree:: inOrder() {
  inOrder(root);
}
void BSTree:: inOrder(Node* root) {
        // Base case
  if (root == NULL) {
    return;
  }
        // Travel the left sub-tree first.
  inOrder(root->left);
        // Print the current node value
  printf("%d ", root->key);
  //cout<< root->key<<endl;;
        // Travel the right sub-tree next.
  inOrder(root->right);
}
void BSTree:: levelOrder(){
  levelOrder(root);
}
void BSTree:: levelOrder(Node* root){
  if (root == NULL) {
    return; 
  }
  
  queue<Node *> q; 
  Node *curr; 
  
  q.push(root); 
  q.push(NULL); 
  
  while (q.size() > 1) { 
    curr = q.front(); 
    q.pop();
    
    if (curr == NULL) { 
      q.push(NULL); 
      cout << "\n"; 
    } else { 
      if(curr->left){
        q.push(curr->left);
      } 
      if(curr->right) {
        q.push(curr->right); 
      }      
      cout << curr->key << " "; 
    } 
  } 
}
//*/


int main() {
  std::cout << "Hello World!\n";
  BSTree test;
  int num[19] = { 7,1,2,3,4,5,6,8,9,10,11,12,13,14,15,166,165,167,600};
  for (int i = 0; i < 19; i++){
    test.insert(num[i]);
  }

  test.levelOrder();


  cout << test.search(10)<<endl;
  cout << test.search(12)<<endl;
  cout << test.search(3)<<endl;
  cout << test.search(50)<<endl;

  test.inOrder();
  cout << "     "<<endl;

  test.deleteNode(6);
  test.deleteNode(166);
  test.deleteNode(8);
  test.deleteNode(9);
  test.deleteNode(600);

  cout << test.search(6)<<endl;
  cout << test.search(5)<<endl;
  cout << test.search(166)<<endl;
  cout << test.search(8)<<endl;

  test.inOrder();
  cout << "     "<<endl;

  test.insert(900);
  test.insert(167);

  test.inOrder();
  cout << "     "<<endl;


  

}