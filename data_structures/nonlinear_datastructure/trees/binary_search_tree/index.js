class Node {
  constructor(key) {
    this.key = key;
    this.right = null;
    this.left = null;
  }
}

class  BinarySearchTree{
  constructor() {
    //initially root is null
    this.root = null;
  };

  insert(data) { 
    var newNode = new Node(data);
    if(this.root === null) {
      this.root = newNode; 
    } else {
      this.insertNode(this.root, newNode); 
    }
  }
   
  insertNode(node, newNode) { 
    if (newNode.key < node.key) { 
      if(node.left === null) {
        console.log("node " + newNode.key + " inserted to the left of " + node.key)
        node.left = newNode; 
      } else {
        this.insertNode(node.left, newNode);  
      }
    } else { 
      if(node.right === null) {
        console.log("node " + newNode.key + " inserted to the right of " + node.key)
        node.right = newNode;
      } else{
        this.insertNode(node.right,newNode); 
      }
    } 
  } 

  search(data) { 
    this.searchNode(this.root, data); 
  }

  searchNode(node, data) { 
    if(node === null) {
      console.log("False")
      return null;
    } 
    
    if (data < node.key) {
      return this.searchNode(node.left, data); 
    } else if (data > node.key) {
      this.searchNode(node.right, data); 
    } else {
      console.log("True")
      return node; 
    }    
  } 

  remove(data) { 
    this.root = this.removeNode(this.root, data); 
  } 

  removeNode(node, key) { 
    if(node === null) {
      return null; 
    } else if(key < node.key) { 
      node.left = this.removeNode(node.left, key); 
      return node; 
    } else if(key > node.key) { 
      node.right = this.removeNode(node.right, key); 
      return node; 
    } else {  
      if(node.left === null) { 
        node = node.right; 
        return node; 
      } else if(node.right === null) { 
        node = node.left; 
        return node; 
      } 
      var aux = this.findMinNode(node.right); 
      node.key = aux.key; 
      node.right = this.removeNode(node.right, aux.key); 
      return node; 
    } 
  } 

  findMinNode(node) { 
    if(node.left === null){
      return node; 
    } else {
      return this.findMinNode(node.left); 
    }
  } 




  inOrder() { 
    this.printInOrder(this.root);
  } 
  printInOrder(node) { 
    if(node !== null) 
    { 
      this.printInOrder(node.left); 
      process.stdout.write(node.key.toString()+ " "); 
      this.printInOrder(node.right); 
    }  
  } 
  
  levelOrder() { 
    this.printeLevelOrder(this.root);
  } 
  printeLevelOrder(node) {
    if(!node ){
      return;
    } 
    const q = [];
    q.unshift(node);
    q.unshift(null); 

    while(q.length > 1){
      let curr = q.pop();
      if (curr === null){
        q.unshift(null); 
        process.stdout.write( "\n" );
      }else{
          if (curr.left){
            q.unshift(curr.left);
          }
          if(curr.right){
            q.unshift(curr.right);
          }
          process.stdout.write(curr.key.toString()+ " ");
        }
      }
      
      
  } 

}

let BST = new BinarySearchTree();
let arr = [7,1,2,3,4,5,6,8,9,10,11,12,13,14,15,166,165,167,600]

for (var i = 0; i < arr.length; i++){
  BST.insert(arr[i])
}

BST.levelOrder();

BST.search(10);
BST.search(12);
BST.search(3);
BST.search(50);

BST.inOrder()
console.log( " " )

BST.remove(6)
BST.remove(166)
BST.remove(8)
BST.remove(9)
BST.remove(600)

BST.inOrder()
console.log( " " )

BST.search(6)
BST.search(5) 
BST.search(166)
BST.search(8)

BST.insert(900);
BST.insert(167);

BST.inOrder()
console.log( " " )

  
