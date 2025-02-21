class Linked_List_Node {
  int item;
  Linked_List_Node next;

  Linked_List_Node(int d) {
    item = d;
    next = null;
  }
} 

public class LinkedList_ {
  Linked_List_Node head;

  private void insert(int data) {
    Linked_List_Node new_node = new Linked_List_Node(data);

    if (head == null) {
      head = new Linked_List_Node(data);
      return;
    }

    new_node.next = null;

    Linked_List_Node last = head;
    while (last.next != null)
      last = last.next;

    last.next = new_node;
    return;
  }

  private boolean search(int key){
    Linked_List_Node cur = head;
    while(cur != null) {
      if(cur.item == key) return true;
      cur = cur.next;
    }
    System.out.print("No Node "  + key + " in list.\n");
    return false;
  }

  private boolean deleteNode(int key) {
    if (head == null)
      return false;

    Linked_List_Node temp = head, prev = null;
    if (temp != null && temp.item == key) {
      head = temp.next;
      return true;
    }

    while (temp != null && temp.item != key) {
      prev = temp;
      temp = temp.next;
    }

    // If the key is not present
    if (temp == null) return false;

    // Remove the node
    prev.next = temp.next;
    return true;
  }

  private void printList() {
    Linked_List_Node node = head;
    while (node != null) {
      System.out.print(node.item + " ");
      node = node.next;
    }
    System.out.print("\n");
  }

  public static void main(String[] args) {
    LinkedList_ llist = new LinkedList_();

    llist.insert(0);
    llist.insert(1);
    llist.insert(2);
    llist.insert(3);
    llist.insert(4);
    llist.insert(5);

    System.out.println("Linked list: ");
    llist.printList();

    System.out.println(llist.search(6));

    System.out.println("\nAfter deleting an element: ");
    llist.deleteNode(0);
    llist.printList();
  }
}