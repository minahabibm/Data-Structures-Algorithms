//import java.util.*; 

class Main {

  public static class BinarySearchTree {
    class Node {
      int key;
      Node left;
      Node right;
  
      Node(int key) {
        this.key = key;
        right = null;
        left = null;
      }
    }
    
    Node root;
    public BinarySearchTree(){
      root = null;
    }

    public void insert(int key){
      if (root == null){
        root = new Node(key);
      }else{
        insert(root, key); 
      }
    };
    private Node insert(Node root, int key){
      if (root == null) { 
        root = new Node(key); 
        return root; 
      } 
      if (key <= root.key){
        System.out.println("node " + key + " inserted to the left of " + root.key );
        root.left = insert(root.left, key); 
      }   
      else if (key > root.key) {
        System.out.println("node " + key + " inserted to the right of " + root.key );
        root.right = insert(root.right, key); 
      }
      return root; 
    };

    public boolean search(int key){
      return search(root, key);
    };
    private boolean search(Node root, int key){
      if (root==null ){
        return false;
      } 
      if (root.key==key) {
        return true; 
      } 
      if (root.key > key) {
        return search(root.left, key); 
      } else if  (root.key < key) {
        return search(root.right, key); 
      }
      return false;
    };

    public Node deleteNode(int key) {
      return deleteNode(root, key);
    } ;
    private Node deleteNode(Node root, int key) {
      if (root == null){
        return root;
      }
            
      if (key < root.key) {
        root.left = deleteNode(root.left, key);
      } else if (key > root.key) {
        root.right = deleteNode(root.right, key);
      } else {
        if (root.left == null) {
          return root.right;
        } else if (root.right == null) {
          return root.left;
        }
        root.key = minValueNode(root.right);
        root.right = deleteNode(root.right, root.key);
      }
      return root;
    } 
    private int minValueNode(Node node) {
      int minimum = node.key;
      while (node.left != null) {
        minimum = node.left.key;
        node = node.left;
      }
      return minimum;
    };

    /**
    public void inOrder() {
      inOrder(root);
    }
    private void inOrder(Node node) {
      if (node == null) {
        return;
      } 
      inOrder(node.left);
      System.out.printf("%s ", node.key);
      inOrder(node.right);
    }
    */

  }

  public static void main(String[] args) {
    System.out.println("Hello world!");
    int intArray[] = { 7,1,2,3,4,5,6,8,9,10,11,12,13,14,15,166,165,167,600 };
    BinarySearchTree BST = new BinarySearchTree();

    for (int i = 0; i < intArray.length; i++) {
      BST.insert(intArray[i]);
    }
    //BST.inOrder();
    System.out.println( " " );

    System.out.println( BST.search(10) );
    System.out.println( BST.search(12) );
    System.out.println( BST.search(3) );
    System.out.println( BST.search(50) );

    BST.deleteNode(6);
    BST.deleteNode(166);
    BST.deleteNode(8);
    BST.deleteNode(9);
    BST.deleteNode(600);

    //BST.inOrder();
    System.out.println( " " );

    System.out.println( BST.search(6) );
    System.out.println( BST.search(5) );
    System.out.println( BST.search(166) );
    System.out.println( BST.search(8) );

    BST.insert(900);
    BST.insert(167);

    //BST.inOrder();
    System.out.println( " " );
  }
}