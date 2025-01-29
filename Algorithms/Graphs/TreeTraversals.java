import java.util.*;
import Data_Structure.NonLinear_DataStructure_Graphs.Trees.*;

class TreeTraversals_util{
  public static int height(Node root) {
    if (root == null)
      return 0;
    else {
      /* compute  height of each subtree */
      int lheight = height(root.left);
      int rheight = height(root.right);
  
      /* use the larger one */
      if (lheight > rheight)
        return (lheight + 1);
      else
        return (rheight + 1);
    }
  }
  public static void printCurrentLevel(Node root, int level) {
    if (root == null)
      return;
    if (level == 1)
      System.out.print(root.key + " ");
    else if (level > 1) {
      printCurrentLevel(root.left, level - 1);
      printCurrentLevel(root.right, level - 1);
    }
  }
  public static void reverse(Node from, Node to){
    if(from == to)
      return;
    Node prev = from, node = from.right;
    while(prev != to){
      Node next = node.right;
      node.right = prev;
      prev = node;
      node = next;
    }
}
}

public class TreeTraversals {
  public static void PreOrder(Node root){
    /** Algorithm Inorder(tree) - Iterative
    *  if (node = null)
    *    return
    *  s —> empty stack
    *  s.push(node)
    *  while (not s.isEmpty())
    *    node —> s.pop()
    *    visit(node)
    *    if (node.right != null)
    *      s.push(node.right)
    *    if (node.left != null)
    *      s.push(node.left)
    *  return if the tree is empty
    */
    if (root == null) 
      return;

    Stack<Node> stack = new Stack<>();
    stack.push(root);

    while (!stack.empty()){
      Node curr = stack.pop();
      System.out.print(curr.key + " ");
      // the right child must be pushed first so that is processed first (LIFO order)
      if (curr.right != null) 
        stack.push(curr.right);
      if (curr.left != null) 
        stack.push(curr.left);
    }
  }
  public static void PreOrder_Morris_Traversal(Node root) {
    /** 1.If left child is null, print the current node data. Move to right child. 
    *   ….Else, Make the right child of the inorder predecessor point to the current node. Two cases arise: 
    *     ………a) The right child of the inorder predecessor already points to the current node. Set right child to NULL. Move to right child of current node. 
    *     ………b) The right child is NULL. Set it to current node. Print current node’s data and move to left child of current node. 
    *   2.Iterate until current node is not NULL.
    */
    System.out.println();
    while (root != null) { 
      // If left child is null, print the current node data. Move to 
      // right child. 
      if (root.left == null) { 
        System.out.print(root.key + " "); 
        root = root.right; 
      } else { 
        // Find inorder predecessor 
        Node current = root.left; 
        while (current.right != null && current.right != root) { 
          current = current.right; 
        } 
        // If the right child of inorder predecessor  
        // already points to this node 
        if (current.right == root) { 
          current.right = null; 
          root = root.right; 
        } 
        // If right child doesn't point to this node, then print 
        // this node and make right child point to this node 
        else { 
          System.out.print(root.key + " "); 
          current.right = root; 
          root = root.left; 
        } 
      } 
    } 
  } 
  
  public static void InOrder(Node root){
    /** Algorithm Inorder(tree) - Recursive
    *     1. Traverse the left subtree, i.e., call Inorder(left-subtree)
    *     2. Visit the root.
    *     3. Traverse the right subtree, i.e., call Inorder(right-subtree)
    */
    if (root == null)
      return;

    InOrder(root.left);
    System.out.print(root.key + " ");
    InOrder(root.right);   
  }
  public static void InOrder_Traversal(Node root) {
    System.out.println();
    if (root == null)
      return;
    
    Stack<Node> treeStack = new Stack<Node>();
    Node curr = root;
    while (curr != null || treeStack.size() > 0) {
      /* Reach the left most Node of the curr Node */
      while (curr !=  null) {
      /* place pointer to a tree node on
         the stack before traversing
        the node's left subtree */
        treeStack.push(curr);
        curr = curr.left;
      }
      /* Current must be NULL at this point */
      curr = treeStack.pop();
      System.out.print(curr.key + " ");
      /* we have visited the node and its
         left subtree.  Now, it's right
         subtree's turn */
      curr = curr.right;
    }
  }
  public static void InOrder_Morris_Traversal(Node root) {
    /** 1. Initialize current as root 
    * 2. While current is not NULL
    *    If the current does not have left child
    *       a) Print current’s data
    *       b) Go to the right, i.e., current = current->right
    *    Else
    *       a) Find rightmost node in current left subtree OR
    *               node whose right child == current.
    *          If we found right child == current
    *              a) Update the right child as NULL of that node whose right child is current
    *              b) Print current’s data
    *              c) Go to the right, i.e. current = current->right
    *          Else
    *              a) Make current as the right child of that rightmost 
    *                 node we found; and 
    *              b) Go to this left child, i.e., current = current->left
    */
    System.out.println();
    Node current, pre;
    if (root == null)
      return;
    current = root;
    while (current != null) {
      if (current.left == null) {
        System.out.print(current.key + " ");
        current = current.right;
      } else {
        /* Find the inorder
            predecessor of current
         */
        pre = current.left;
        while (pre.right != null && pre.right != current)
          pre = pre.right;

        /* Make current as right
           child of its
         * inorder predecessor */
        if (pre.right == null) {
          pre.right = current;
          current = current.left;
        }
        /* Revert the changes made
           in the 'if' part
           to restore the original
           tree i.e., fix
           the right child of predecessor*/
        else{
          pre.right = null;
          System.out.print(current.key + " ");
          current = current.right;
        } /* End of if condition pre->right == NULL
           */
      } /* End of if condition current->left == NULL*/
    } /* End of while */
  }
  
  public static void PostOrder(Node root){
    /** 1.1 Create an empty stack
    *   2.1 Do following while root is not NULL
    *      a) Push root's right child and then root to stack.
    *      b) Set root as root's left child.
    *   2.2 Pop an item from stack and set it as root.
    *      a) If the popped item has a right child and the right child 
    *         is at top of stack, then remove the right child from stack,
    *         push the root back and set root as root's right child.
    *      b) Else print root's data and set root as NULL.
    *   2.3 Repeat steps 2.1 and 2.2 while stack is not empty.
    *   Check for empty tree
    */
    if (root == null)
      return;
    Stack<Node> treeStack = new Stack<Node>();
    
    treeStack.push(root);
    Node prev = null;
    while (!treeStack.isEmpty()) {
      Node current = treeStack.peek();
      /* go down the tree in search of a leaf an if so
      process it and pop stack otherwise move down */
      if (prev == null || prev.left == current || prev.right == current) {
        if (current.left != null)
          treeStack.push(current.left);
        else if (current.right != null)
          treeStack.push(current.right);
        else {
          treeStack.pop();
          System.out.print(current.key + " ");
        }
      /* go up the tree from left node, if the
      child is right push it onto stack otherwise
      process parent and pop stack */
      }else if (current.left == prev) {
        if (current.right != null)
          treeStack.push(current.right);
        else {
          treeStack.pop();
          System.out.print(current.key + " ");
        }
      /* go up the tree from right node and after
      coming back from right node process parent
      and pop stack */
      }else if (current.right == prev) {
        treeStack.pop();
        System.out.print(current.key + " ");
      }
      prev = current;
    }
 
  }
  public static void PostOrder_2Stacks(Node root){
    /** 1. Push root to first stack.
    *   2. Loop while first stack is not empty
    *    2.1 Pop a node from first stack and push it to second stack
    *    2.2 Push left and right children of the popped node to first stack
    *   3. Print contents of second stack
    */
    System.out.println();
    if (root == null)
      return;
    
    // Create two stacks
    Stack<Node> s1 = new Stack<>();
    Stack<Node> s2 = new Stack<>();

    // push root to first stack
    s1.push(root);

    // Run while first stack is not empty
    while (!s1.isEmpty()) {
      // Pop an item from s1 and push it to s2
      Node temp = s1.pop();
      s2.push(temp);
      
      // Push left and right children of
      // removed item to s1
      if (temp.left != null)
        s1.push(temp.left);
      if (temp.right != null)
        s1.push(temp.right);
    }

    // Print all elements of second stack
    while (!s2.isEmpty()) {
      Node temp = s2.pop();
      System.out.print(temp.key + " ");
    }
  }    
  public static void PostOrder_Morris_Traversal(Node root){
    /**   Create a dummy node and make dummy.left = root.
    *    root = dummy
    *    Iterate till root is null.
    *      If root has a left child.
    *        Find the inorder predecessor => pre. (Inorder predecessor of root is the right most child of its left child)
    *         pre.right = root (Make it point to root).
    *          root = root.left.
    *      If its already pointing to root (which means we have traversed it already and are on our way up.)
    *        Reverse from root.left to pre.
    *        Traverse from pre to root.left and print the nodes.
    *        Re-reverse it back to normal.
    *        pre.right = null.
    *        root = root.right.
    *      If left child is null
    *        root = root.right. (We are climbing up our link.)
    */
    System.out.println();
    //List<Integer> out = new ArrayList<Integer>();
  	if(root == null)
  		return;
  	Node dummy = new Node(-1), pre = null;
  	dummy.left = root; root = dummy;
  	while(root != null){
  		if(root.left != null){
  			pre = root.left;
  			while(pre.right != null && pre.right != root)
  				pre=pre.right;
  			if(pre.right == null){
  				pre.right = root;
  				root = root.left;
  			} else{
  				Node node = pre;
  				TreeTraversals_util.reverse(root.left,pre);
  				while(node != root.left){
  					//out.add(node.key);
            System.out.print(node.key + " ");
  					node = node.right;
  				}
  				//out.add(node.key);          // Print again since we are stopping at node=root.left
          System.out.print(node.key + " ");
  				TreeTraversals_util.reverse(pre,root.left);
  				pre.right = null;
  				root = root.right;
  			}
  		} else {
  			root = root.right;
  		}
  	}
  }

  public static void LevelOrder(Node root){
    int h = TreeTraversals_util.height(root);
    for (int i = 1; i <= h; i++)
      TreeTraversals_util.printCurrentLevel(root, i);
  }
  public static void LevelOrder_BFS(Node root){
    System.out.println();
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node tempNode = queue.poll();
      System.out.print(tempNode.key + " ");

      /*Enqueue left child */
      if (tempNode.left != null) 
        queue.add(tempNode.left);
      
      /*Enqueue right child */
      if (tempNode.right != null) 
        queue.add(tempNode.right);
    }
  }

  public static void main(String args[]) {
    System.out.println("Tree Traversals!");
    
    int intArray[] = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15 };
    BinaryTree BT = new BinaryTree();
    
    for (int i = 0; i < intArray.length; i++) 
      BT.insert(intArray[i]);
    
    System.out.println("Pre-Order Traversals!");
    PreOrder(BT.root);
    PreOrder_Morris_Traversal(BT.root);
    System.out.println("\nIn-Order Traversals!");
    InOrder(BT.root);
    InOrder_Traversal(BT.root);
    InOrder_Morris_Traversal(BT.root);
    System.out.println("\nPost-Order Traversals!");
    PostOrder(BT.root);
    PostOrder_2Stacks(BT.root);
    PostOrder_Morris_Traversal(BT.root);
    System.out.println("\nLevel Order Traversals!");
    LevelOrder(BT.root);
    LevelOrder_BFS(BT.root);

  }
  
}
