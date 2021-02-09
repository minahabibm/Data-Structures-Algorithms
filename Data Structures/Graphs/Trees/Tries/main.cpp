#include <iostream>

using namespace std;  

const int ALPHABET_SIZE = 26;

struct TrieNode { 
  struct TrieNode *ptrArr[ALPHABET_SIZE]; 
  char data ;
  bool isEndOfWord;
}; 
struct TrieNode *getNode(char c) { 
  struct TrieNode *pNode =  new TrieNode; 
  pNode->isEndOfWord = false;
  pNode->data = c;
  for (int i = 0; i < ALPHABET_SIZE; i++){
    pNode->ptrArr[i] = NULL; 
  } 
  return pNode; 
} 

class Trie{
  TrieNode* root;
  public:
    Trie(){
      root = getNode('\0');
    }
    void insert(string s);
    bool search(string s);
    TrieNode* remove(TrieNode* root, string key, int depth = 0);
    bool remove(string s){ return remove(root, s ); };
    bool isEmpty(TrieNode* root);
    
    void print_trie(){ print_trie(root); };
    void print_trie(TrieNode* root);
}; 

void Trie::insert(string s) { 
  TrieNode* p = root; 
   //cout<< root->data;
  for(int i=0; i<s.length(); i++){
    int index = s[i] - 'a'; 
    if ( p->ptrArr[index] == NULL) {
      p->ptrArr[index] = getNode(s[i]);
    }
    p = p->ptrArr[index];
  }
  p->isEndOfWord = true;
}
bool Trie::search(string s){
  struct TrieNode *pCrawl = root; 
  
  for (int i = 0; i < s.length(); i++) { 
    int index = s[i] - 'a'; 
    if (pCrawl->ptrArr[index] == NULL) {
      return false; 
    }
    pCrawl = pCrawl->ptrArr[index]; 
  } 
  return (pCrawl != NULL && pCrawl->isEndOfWord); 
};

TrieNode* Trie::remove(TrieNode* root, string key, int depth) { 
  // If tree is empty 
  if (!root){
    return NULL; 
  } 
  // If last character of key is being processed 
  if (depth == key.size()) { 
      // This node is no more end of word after 
      // removal of given key 
    if (root->isEndOfWord) {
      root->isEndOfWord = false; 
    }
      // If given is not prefix of any other word 
    if (isEmpty(root)) { 
      delete (root); 
      root = NULL; 
    } 
    return root; 
  }
  // If not last character, recur for the child 
  // obtained using ASCII value 
  int index = key[depth] - 'a'; 
  root->ptrArr[index] = remove(root->ptrArr[index], key, depth + 1); 
  
    // If root does not have any child (its only child got  
    // deleted), and it is not end of another word. 
  if (isEmpty(root) && root->isEndOfWord == false) { 
    delete (root); 
    root = NULL; 
  } 
  return root;
};

bool Trie::isEmpty(TrieNode* root){ 
  for (int i = 0; i < ALPHABET_SIZE; i++) {
    if (root->ptrArr[i]) {
      return false; 
    }        
  }   
  return true; 
} 

void Trie::print_trie(TrieNode* root) {
  if (!root)
    return;
  TrieNode* temp = root;
  printf("%c -> ", temp->data);
  for (int i=0; i<ALPHABET_SIZE; i++) {
    print_trie(temp->ptrArr[i]); 
  }
}

int main() {
  //std::cout << "Trie \n";

  string strings[4] = { "hello", "hi", "teabag", "teacan"};

  Trie trie;
  cout<<trie.search("hello")<<endl;
  for (int i = 0; i < 4; i++){
    trie.insert(strings[i]);
  }

  cout<<trie.search("hello")<<endl;
  cout<<trie.search("helo")<<endl;
  cout<<trie.search("teabag")<<endl;

  trie.remove("teacan");
  cout<<trie.search("teacan")<<endl;
  cout<<trie.search("teabag")<<endl;
  trie.remove("teabag");

  trie.print_trie();

  return 0; 
}
