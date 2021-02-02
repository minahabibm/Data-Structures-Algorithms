class TrieNode {
  constructor(c = ''){
    this.letter = c
    this.triNode = {}
    this.isEndOfWord = false
  }
}

class  Trie{
  constructor(){
    this.root = new TrieNode()
  }

  insert(data) {
    let curNode = this.root;
    let letter;
    for( var i = 0; i < data.length; i++ ){
      letter = data[i]
      if( curNode.triNode[letter] ){
        curNode = curNode.triNode[letter];
      }else{
        const newNode = new TrieNode(letter);
        curNode.triNode[letter] = newNode;
        curNode = newNode;
      }
    }
    curNode.isEndOfWord = true
  }
  
  search(data) {
    let curNode = this.root;
    let letter; 
    for( var i = 0; i < data.length; i++ ){
      letter = data[i]
      if( !curNode.triNode[letter] ) {
        return false
      }
      curNode = curNode.triNode[letter]
    }
    return curNode.isEndOfWord
  }

  delete(word) {
    let node= this.root;
    
    if (!word) return null;
    
    const chain = [];
    
    // traverse down trie
    for (const letter of word) {
      if (node.triNode[letter]) {
        chain.push(node)
        node = node.triNode[letter]
      } else {
        return null;
      }
    }

    if (Object.keys(node.triNode).length) {
      node.isEndOfWord = false;
      return node;
    }
    
    // Zero children in node.
    // continue until we hit a breaking condition
    let leaf = chain.length ? chain.pop() : null; // whatever node was
    let stem = chain.length ? chain.pop() : null; // if node has parent
    while (true) { 
      leaf && stem && delete stem.triNode[leaf.letter]; // remove child;
      if (Object.keys(stem.triNode).length || !chain.length) { // if more children or chain is empty, we're done!
        node.isEndOfWord = false;
        return node;
      }
      // otherwise, we have no more children for our parent and we should keep deleting nodes
      // our next parent is what we pop from the chain
      // our child is what our parent was.
      leaf = stem;
      stem = chain.pop()
    }
  } 


  
  
  /**Extras */
  print(){ return this._print(this.root)}  
  _print(node){
    const res = []
    
    if(node == null ){
      return
    }
    for (const [key, data] of Object.entries(node.triNode)) {
      console.log(key);
      this._print(data)
      
    }    
  }

}

let arr = ["hello", "hi", "teabag", "teacan"];

let trie = new Trie();
for (var i = 0; i < arr.length; i++){
  trie.insert(arr[i])
}
trie.print()
console.log(trie.search("hello"))
console.log(trie.search("helo"))
console.log(trie.search("teacan"))
trie.delete("teacan")
console.log(trie.search("teacan"))
console.log(trie.search("teabag"))
trie.print()