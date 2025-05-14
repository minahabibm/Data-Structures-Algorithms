
class Node:
  def __init__(self,data): 
    self.key = data 
    self.left = None
    self.right = None

class BinarySearchTree:
  def __init__(self):
    self.root= None
   
  def insert(self, key, roots = "Node"):
    if roots == "Node":
      node = self.root
    else:
      node = roots

    if node is None: 
      self.root = Node(key)
    else:
      if key > node.key: 
        if node.right is None:
          print("node " + str(key) + " inserted to the right of " + str(node.key) );
          node.right = Node(key)         
        else: 
          self.insert( key, node.right )
      else: 
        if node.left is None:
          print("node " + str(key) + " inserted to the left of " + str(node.key) );
          node.left = Node(key) 
        else: 
          self.insert(key, node.left ) 

  def search(self, key , roots = "Node"):
    if roots == "Node":
      root = self.root
    else:
      root = roots
    
    if root is None:
      return False
    if root.key == key: 
      return True
    if  key > root.key: 
      return self.search(key, root.right)   
    else:
      return self.search(key, root.left)

  def deleteNode(self, key, roots = "Node" ):
    if roots == "Node":
      root = self.root
    else:
      root = roots

    if root is None: 
      return root  
  
    if key < root.key: 
      root.left = self.deleteNode(key, root.left) 

    elif(key > root.key): 
      root.right = self.deleteNode(key, root.right) 

    else:           
      if root.left is None : 
        temp = root.right  
        root = None 
        return temp  
              
      elif root.right is None : 
        temp = root.left  
        root = None
        return temp 
       
      temp = self.minValueNode(root.right) 
      root.key = temp.key 
      root.right = self.deleteNode(temp.key, root.right)

    return root
      
  def minValueNode(self, node): 
    current = node 
    while(current.left is not None): 
      current = current.left  
    return current      

  def printInorder(self, roots = "Node" ): 
    if roots == "Node":
      root = self.root
    else:
      root = roots
    
    if root: 
      self.printInorder(root.left) 
      print(root.key, end =" " ), 
      self.printInorder(root.right) 

if __name__=='__main__': 
  print("Hello World")
  BST = BinarySearchTree()
  arr = [7,1,2,3,4,5,6,8,9,10,11,12,13,14,15,166,165,167,600]
  
  for i in arr:
    BST.insert(i)
  
  print(BST.search(10))
  print(BST.search(12))
  print(BST.search(3))
  print(BST.search(50))

  BST.printInorder()
  print( " " )

  BST.deleteNode(6)
  BST.deleteNode(166)
  BST.deleteNode(8)
  BST.deleteNode(9)
  BST.deleteNode(600)

  BST.printInorder()
  print( " " )

  print( BST.search(6) )
  print( BST.search(5) )
  print( BST.search(166) )
  print( BST.search(8) )

  BST.insert(900);
  BST.insert(167);

  BST.printInorder()
  print( " " )
