import java.util.*; 

public class BinaryTree {
  Node root;
  public BinaryTree(){
    root = null;
  }

  public void insert(int key){
    if (root == null){
      root = new Node(key);
    }else{
      insert(key, root); 
    }
  };
  public boolean search(int key){
    return search(key,root);
  };
  public Node del(int key){
    return dele(key, root);
  };

  private void insert(int key, Node root){
    Queue<Node> q = new LinkedList<>(); 
    q.add(root); 

    // Do level order traversal until we find 
    // an empty place.  
    while (!q.isEmpty()) { 
      Node temp = q.peek(); 
      q.remove(); 
    
      if (temp.left == null) { 
        temp.left = new Node(key);
        // System.out.println("node " + key + " inserted to the left of " + temp.key );
        break; 
      } else {
        q.add(temp.left);
      } 
      if (temp.right == null) { 
        temp.right = new Node(key);
        // System.out.println("node " + key + " inserted to the right of " + temp.key );
        break; 
      } else
        q.add(temp.right); 
    } 
  };
  private boolean search(int key,  Node root){
    if (root == null){
      return false; 
    }
    if (root.key == key){
      return true; 
    }
      /* then recur on left sutree */
    boolean res1 = search(key, root.left ); 
    
    if(res1){ 
      return true;
    } // node found, no need to look further 
    
      /* node is not found in left, so recur on right subtree */
    boolean res2 = search(key, root.right); 
    
    return res2; 
  };
  private Node dele(int key, Node root){
    if (root == null) {
      return null; 
    }
    
    if (root.left == null && root.right == null) { 
      if (root.key == key){
        return null; 
      }else{
        return root; 
      }
    } 
  
    Queue<Node> q = new LinkedList<>(); 
    q.add(root); 
  
    Node temp = null; 
    Node key_node = null; 
  
    // Do level order traversal to find deepest 
    // node(temp) and node to be deleted (key_node) 
    while (!q.isEmpty()) { 
      temp = q.peek(); 
      q.remove(); 
  
      if (temp.key == key){
        key_node = temp; 
      }

      if (temp.left != null) {
        q.add(temp.left); 
      }
  
      if (temp.right != null ){
        q.add(temp.right); 
      }
            
    } 

    if (key_node != null) {
      int x = temp.key; 
      del(root, temp); 
      key_node.key = x; 
    } 
    return root;
  };
  
  private void del(Node root, Node dNode){
    Queue<Node> q = new LinkedList<>(); 
    q.add(root); 
    
    // Do level order traversal until last node 
    Node temp; 
    while (!q.isEmpty()) { 
      temp = q.peek(); 
      q.remove(); 
      if (temp == dNode) { 
        temp = null; 
        return; 
      } 
      if (temp.right != null ) { 
        if (temp.right == dNode) { 
          temp.right = null; 
          return; 
        }else{
          q.add(temp.right); 
        } 
    
        if (temp.left != null) { 
          if (temp.left == dNode) { 
            temp.left = null; 
            return; 
          }else{
            q.add(temp.left);
          } 
        } 
      } 
    }
  };


  public static void main(String[] args) {
    System.out.println("Binary Tree!");
    int intArray[] = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15 };
    BinaryTree BT = new BinaryTree();
  
    for (int i = 0; i < intArray.length; i++) 
      BT.insert(intArray[i]);
    
    System.out.println( BT.search(10) );
    System.out.println( BT.search(12) );
    System.out.println( BT.search(3) );
    System.out.println( BT.search(50) );
    BT.del(6);
    System.out.println( BT.search(6) );
    System.out.println( BT.search(5) );
  }

}