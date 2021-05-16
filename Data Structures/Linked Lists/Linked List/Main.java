class Main {
  public static class LinkedList {
    Node head;

    public class Node {
      int item;
      Node next;

      Node(int d) {
        item = d;
        next = null;
      }
    }

    private void insert(int data) {
      Node new_node = new Node(data);

      if (head == null) {
        head = new Node(data);
        return;
      }

      new_node.next = null;

      Node last = head;
      while (last.next != null)
        last = last.next;

      last.next = new_node;
      return;
    }

    private boolean search(int key){
      Node cur = head;
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

      Node temp = head, prev = null;
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
      Node node = head;
      while (node != null) {
        System.out.print(node.item + " ");
        node = node.next;
      }
      System.out.print("\n");
    }

  }
  

  public static void main(String[] args) {
    LinkedList llist = new LinkedList();

    llist.insert(0);
    llist.insert(1);
    llist.insert(2);
    llist.insert(3);
    llist.insert(4);
    llist.insert(5);

    System.out.println("Linked list: ");
    llist.printList();

    System.out.println(llist.search(1));

    System.out.println("\nAfter deleting an element: ");
    llist.deleteNode(0);
    llist.printList();
  }
}