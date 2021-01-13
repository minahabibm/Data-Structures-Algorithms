from queue import Queue 

class Node:
  def __init__(self,data): 
    self.data = data 
    self.left = None
    self.right = None

class BinaryTree:
  def __init__(self):
    self.root= None
   
  def insert(self, key):
    if self.root == None:
      self.root = Node(key)
    else:
      current = self.root
      q = Queue()
      q.put(current)
      while (not q.empty()):
        temp = q.get_nowait()
        if (temp.left == None):
          temp.left = Node(key)
          print("node " + str(key) + " inserted to the left of " + str(temp.data))
          break 
        else:
          q.put(temp.left)
         
        if (temp.right == None): 
          temp.right = Node(key)
          print("node " + str(key) + " inserted to the right of " + str(temp.data))
          break 
        else:
          q.put(temp.right) 

  def search(self, key , roots = "Node"):
    if roots == "Node":
      root = self.root
    else:
      root = roots
      
    if root == None:
      return False

    if (root.data == key):
      return True

    res1 = self.search(key, root.left)
    if(res1): 
      return True

    res2 = self.search(key, root.right)
    return res2

  def dele(self,root,d_node): 
    q = [] 
    q.append(root) 
    while(len(q)): 
      temp = q.pop(0) 
      if temp is d_node: 
        temp = None
        return
      if temp.right: 
        if temp.right is d_node: 
          temp.right = None
          return
        else: 
          q.append(temp.right) 
      if temp.left: 
        if temp.left is d_node: 
          temp.left = None
          return
        else: 
          q.append(temp.left) 
   
  def deletion(self, key, roots = "Node" ):
    if roots == "Node":
      root = self.root
    else:
      root = roots

    if root == None : 
      return None

    if root.left == None and root.right == None: 
      if root.key == key :  
        return None 
      else : 
        return root 

    key_node = None
    q = [] 
    q.append(root) 
    while(len(q)): 
      temp = q.pop(0) 
      if temp.data == key: 
        key_node = temp 
      if temp.left: 
        q.append(temp.left) 
      if temp.right: 
        q.append(temp.right) 
    
    if key_node :  
      x = temp.data 
      self.dele(root,temp)
      key_node.data = x 
      
    return root 


if __name__=='__main__': 
  print("Hello World")
  BT = BinaryTree()
  arr = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]
  
  for i in arr:
    BT.insert(i)
  
  print(BT.search(10))
  print(BT.search(12))
  print(BT.search(3))
  print(BT.search(50))
  BT.deletion(6);
  print( BT.search(6))
  print( BT.search(5))