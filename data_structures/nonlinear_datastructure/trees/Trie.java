import java.util.*; 

class TrieNode {
  Map<Character, TrieNode> triNode;
  boolean isEndOfWord;

  public TrieNode(){
    this.triNode = new HashMap<>();
    this.isEndOfWord = false;
  }
}

public class Trie {

  private TrieNode root;

  public Trie(){
    this.root = new TrieNode();
  }
  
  public void insert(String word){
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++){
      char letter = word.charAt(i);
      if(!current.triNode.containsKey(letter)){
        TrieNode node = new TrieNode();
        current.triNode.put(word.charAt(i),node);
      }
      current = current.triNode.get(word.charAt(i));
    }
    current.isEndOfWord = true;       
  }

  public boolean search(String word) {
    TrieNode current = root;
    for(int i=0;i<word.length();i++){
      char c = word.charAt(i);
      if(current.triNode.containsKey(c))
        current = current.triNode.get(c);
      else 
        return false;
    }
    if(current.isEndOfWord==true) 
      return true;
    
    return false;
  }

  // public boolean startsWith(String prefix) {
  //   TrieNode currNode = trieNode;
  //   for (char ch : prefix.toCharArray()) {
  //       if (currNode.nodes[ch - 'a'] == null)
  //           return false;
  //       currNode = currNode.nodes[ch - 'a'];
  //   }
  //   return true;
  // }

  public void delete(String word){ delete(root, word, 0);}
  private boolean delete(TrieNode current, String word, int index) {
    // Return true if parent should delete the mapping
    if(index == word.length()){
      //when end of word is reached only delete if current.endOfWord is true
      if(!current.isEndOfWord){
        return false;
      }
      current.isEndOfWord = false;
      // if current has no other mapping then return true
      return current.triNode.size() == 0;
    }

    char ch = word.charAt(index);
    TrieNode node = current.triNode.get(ch);
    if(node == null){
      return false;
    }
    
    boolean shouldDeleteCurrentNode = delete(node, word, index+1);
    // if true is returned then delete the mapping of character and trienode reference of the map
    if(shouldDeleteCurrentNode){
      current.triNode.remove(ch);
      // return true if no mapping are left in the map
      return current.triNode.size() == 0;
    } 
    return false;
  }

  public void print(){ print( this.root );}
  public void print(TrieNode node){
    if (node == null){
      return;
    }
    for (char key : node.triNode.keySet()) {
      System.out.printf("-> ");
      System.out.print(key);
      print( node.triNode.get(key) );
    }
  }

  public static void main(String[] args) {
  
    System.out.println("Trie");
    String strArray[] = { "hello", "hi", "teabag", "teacan" };
  
    Trie trie = new Trie();
    System.out.println(trie.search("hello"));
    for (int i = 0; i < strArray.length; i++) {
      trie.insert(strArray[i]);
    }
    trie.print();
    System.out.println( " " );
    System.out.println(trie.search("hello"));
    System.out.println(trie.search("helo"));
    System.out.println(trie.search("teabag"));
    trie.delete("teabag");
    System.out.println(trie.search("teabag"));
    trie.print();
  }
  
}
