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

class BTree{
  Node *root;
  public:
    BTree(){
      root= NULL;
    }
    void insert(int key);
    bool search(int key);      
    Node* del(int key);
  private:
    void insert(int key, Node *root);
    bool search(int key, Node *root);
    Node* dele(int Key, Node *root);     
    void del(Node *root, Node *temp);
    

       
};

void BTree::insert(int key) {
  if (root == NULL){
    root = new Node(key);
  }else{
    insert(key, root); 
  }
};

void BTree::insert(int key, Node *temp) { 
  queue<Node*> q; 
  q.push(temp); 
  
  // Do level order traversal until we find 
  // an empty place.  
  while (!q.empty()) { 
    Node* temp = q.front();
    q.pop(); 
  
    if (!temp->left) { 
      temp->left = new Node(key); 
      cout << "node " << key << " inserted to the left of " << temp->key<<endl;
      break; 
    } else {
      q.push(temp->left);
    } 
    if (!temp->right) { 
      temp->right = new Node(key);
      cout << "node " << key << " inserted to the right of " << temp->key<<endl;
        break; 
    } else
      q.push(temp->right); 
  } 
} 

bool BTree::search(int key){
  return search(key,root);
};

bool BTree::search(int key, Node *node){ //traverse the tree in preorder
  if (node == NULL){
    return false; 
  }
  if (node->key == key){
    return true; 
  }
    /* then recur on left sutree */
  bool res1 = search(key, node->left ); 
  
  if(res1){ 
    return true;
  } // node found, no need to look further 
  
    /* node is not found in left, so recur on right subtree */
  bool res2 = search(key, node->right); 
  
  return res2; 
}

Node* BTree::del(int key){
  return dele(key, root);
}

Node* BTree::dele(int key, Node *root){
  if (root == NULL) 
        return NULL; 
  
    if (root->left == NULL && root->right == NULL) { 
        if (root->key == key) 
            return NULL; 
        else
            return root; 
    } 
  
    queue<struct Node*> q; 
    q.push(root); 
  
    struct Node* temp; 
    struct Node* key_node = NULL; 
  
    // Do level order traversal to find deepest 
    // node(temp) and node to be deleted (key_node) 
    while (!q.empty()) { 
        temp = q.front(); 
        q.pop(); 
  
        if (temp->key == key) 
            key_node = temp; 
  
        if (temp->left) 
            q.push(temp->left); 
  
        if (temp->right) 
            q.push(temp->right); 
    } 
  
    if (key_node != NULL) { 
        int x = temp->key; 
        del(root, temp); 
        key_node->key = x; 
    } 
    return root; 
};

void BTree::del( Node *node,  Node *dNode){
  queue<Node*> q; 
  q.push(root); 
  
    // Do level order traversal until last node 
  Node* temp; 
  while (!q.empty()) { 
    temp = q.front(); 
    q.pop(); 
    if (temp == dNode) { 
      temp = NULL; 
      delete (dNode); 
      return; 
    } 
    if (temp->right) { 
      if (temp->right == dNode) { 
        temp->right = NULL; 
        delete (dNode); 
        return; 
      }else{
        q.push(temp->right); 
      } 
  
      if (temp->left) { 
        if (temp->left == dNode) { 
          temp->left = NULL; 
          delete (dNode); 
          return; 
        }else{
          q.push(temp->left);
        } 
      } 
    } 
  }
}

int main() {
  std::cout << "Hello World!\n";
  BTree test;
  test.insert(1);
  test.insert(2);
  test.insert(3);
  test.insert(4);
  test.insert(5);
  test.insert(6);
  test.insert(7);
  test.insert(8);
  test.insert(9);
  test.insert(10);
  test.insert(11);
  test.insert(12);
  test.insert(13);
  test.insert(14);
  test.insert(15);
  cout << test.search(10)<<endl;
  cout << test.search(12)<<endl;
  cout << test.search(3)<<endl;
  cout << test.search(50)<<endl;
  test.del(6);
  cout << test.search(6)<<endl;
  cout << test.search(5)<<endl;
  
}