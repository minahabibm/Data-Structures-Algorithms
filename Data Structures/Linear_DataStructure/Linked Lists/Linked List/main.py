class Node:
  def __init__(self, item):
    self.item = item
    self.next = None


class LinkedList:
  def __init__(self):
    self.head = None

  def insert(self, data):
    new_node = Node(data)

    if self.head is None:
      self.head = new_node
      return

    last = self.head
    while (last.next):
      last = last.next

    last.next = new_node

  def search(self, key):
    cur = self.head;
    while cur:
      if(cur.item == key): return True;
      cur = cur.next
    
    print( "No Node " + str(key) + " in list.")
    return False
  
  def deleteNode(self, position):

    if self.head == None:
      return

    temp_node = self.head

    if position == 0:
      self.head = temp_node.next
      temp_node = None
      return

    # Find the key to be deleted
    for i in range(position - 1):
      temp_node = temp_node.next
      if temp_node is None:
          break

    # If the key is not present
    if temp_node is None:
      return

    if temp_node.next is None:
      return

    next = temp_node.next.next
    temp_node.next = None
    temp_node.next = next

  def printList(self):
    temp_node = self.head
    while (temp_node):
      print(str(temp_node.item) + " ", end="")
      temp_node = temp_node.next
    print("\n")




if __name__ == '__main__':

  llist = LinkedList()
  llist.insert(0)
  llist.insert(1)
  llist.insert(2)
  llist.insert(3)
  llist.insert(4)
  llist.insert(5)

  print('Linked list:')
  llist.printList()

  print(llist.search(6))

  print("\nAfter deleting an element:")
  llist.deleteNode(3)
  llist.printList()