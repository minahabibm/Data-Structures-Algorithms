class Node{
  constructor(data, next = null){
    this.data = data,
    this.next = next
  }
}

class LinkedList{
  constructor(){
    this.head = null;
  }

  insert(data) {
    let newNode = new Node(data);
    if(!this.head){
      this.head = newNode;
      return this.head;
    }
   let tail = this.head;
   while(tail.next !== null){
    tail = tail.next;
   }
   tail.next = newNode;
   return this.head;
  }

  search(key) {
    let cur = this.head;
    while (cur) {
      if(cur.data == key) { return true }
      cur = cur.next
    }
    
    console.log( "No Node " + key + " in list.")
    return false
  }

  delete(index) {
    if (!this.head){
      return;
    }

    if (index === 0) {
      this.head = this.head.next;
      return;
    }

    let node = this.head;    
    for (let i = 0; node != null && i < index - 1; i++){
      node = node.next;
    }

    if (node == null || node.next == null) {
      return;
    }

    let next = node.next.next;
    node.next = next;

  }

  display(){
    let temp = this.head;
    var string = "";
    while (temp){
      string += temp.data +  " "
      temp = temp.next
    }
    console.log(string + "\n")
  }

}


let llist = new LinkedList();
llist.insert(0);
llist.insert(1);
llist.insert(2);
llist.insert(3);
llist.insert(4);
llist.insert(5);

llist.display();

console.log(llist.search(5) + "\n");

llist.delete(0);
llist.display();
