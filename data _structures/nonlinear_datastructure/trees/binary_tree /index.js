class Node {
  constructor(val) {
    this.val = val;
    this.right = null;
    this.left = null;
  }
}

class BinaryTree {
  constructor() {
    //initially root is null
    this.root = null;
  };

  insert (key) {
    if (this.root == null){
      this.root = new Node(key)
    } else {
      let current = this.root;
      const q = [];
      q.unshift(current);

      while (q.length !== 0){
        let temp = q[q.length - 1];
        q.pop();

        if (temp.left == null){
          temp.left = new Node(key);
          console.log("node " + key + " inserted to the left of " + temp.val)
          break 
        }else{
          q.unshift(temp.left)
        };

        if (temp.right == null){ 
          temp.right = new Node(key)
          console.log("node " + key + " inserted to the right of " + temp.val)
          break 
        }else{
          q.unshift(temp.right)
        };

      };
    };
  };

  search(key , roots= "Node" ) {
    let root;
    if (roots == "Node"){
      root = this.root
    }else{
      root = roots
    };
    if (root == null) {
      return false
    }
    if (root.val == key){ 
      return true
    }
    let res1 = this.search(key, root.left)
    if(res1 === true){ 
      return true
    }
    let res2 = this.search(key, root.right)
    return res2
  }

  del(root, d_node) {
    const qu = [];
    let temp;
    qu.unshift(root); 
    while(qu.length !== 0){ 
      temp = qu[qu.length - 1];
      qu.pop() 
      if (temp === d_node) { 
        temp = null
        return
      }
      if (temp.right === d_node) { 
        temp.right = null
        return
      }else{ 
        qu.unshift(temp.right)
      }
      if (temp.left) { 
        if (temp.left === d_node) { 
          temp.left = null
          return
        }else{ 
          qu.unshift(temp.left) 
        }
      }
    }
  } 

  deletion (key , roots= "Node") { 
    let root;
    if (roots == "Node"){
      root = this.root
    }else{
      root = roots
    }
    
    if (root == null) { 
      return null
    }
    if ((root.left === null) && (root.right === null)){ 
      if (root.key === key) {  
        return null 
      }else { 
        return root 
      }
    }
  
    let key_node = null;
    let temp;
    const q = [] ;
    q.unshift(root); 
    while(q.length !== 0){ 
      temp = q[q.length - 1];
      q.pop();
 
      if (temp.val === key) { 
        key_node = temp;
      }
      if (temp.left) { 
        q.unshift(temp.left); 
      }
      if (temp.right) { 
        q.unshift(temp.right); 
      }
    }
    if (key_node !== null) {
      let x = temp.val;
      this.del(root,temp);
      key_node.val = x;
    } 
  }

}

let BT = new BinaryTree();
let arr = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]

for (var i = 0; i < arr.length; i++){
  BT.insert(arr[i])
}

console.log(BT.search(10));
console.log(BT.search(12));
console.log(BT.search(3));
console.log(BT.search(70));
BT.deletion(6);
console.log( BT.search(6));
console.log( BT.search(5));