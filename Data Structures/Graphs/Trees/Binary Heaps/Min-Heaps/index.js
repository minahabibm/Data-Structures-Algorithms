class MinHeap{

  constructor() {
    this.items = [Number.NEGATIVE_INFINITY];
  };

  left(i) { return 2 * i; }
  right(i) { return 2 * i + 1; }
  parent(i) { return Math.floor( (i) / 2 );}

  size() { return this.items.length; }

  insertKey(data) { 
    this.items.push(data);

    //heapifyUp()
    if (this.size() > 1) {
      let index = this.size() - 1 ;
      while (index != 0 && this.items[index] < this.items[this.parent(index)] ) {
        this.swap(index,this.parent(index));
        index = this.parent(index);

      }
    }
  }

  decreaseKey(index, data) {
    if (this.items[index] < data){
      return ("error")
    }
    this.items[index] = data; 
    while (index != 0 && this.items[index] < this.items[this.parent(index)] ) {
      this.swap(index,this.parent(index));
      index = this.parent(index);
    }
  } 

  extractMin() { 
    let popped = this.items[1]; 
    this.items[1] = this.items[this.size()-1];
    this.items.length -= 1;
    this.MinHeapify(1);
    return popped 
  }

  deleteKey(pos) { 
    this.decreaseKey(pos, Number.NEGATIVE_INFINITY);
    this.extractMin(); 
  } 

  getMin() {
    /* Accessing the min element at index 1 in the heap array */
    return this.items[1]
  }

  MinHeapify(pos) { 
    let l = this.left(pos); 
    let r = this.right(pos); 
    let smallest = pos; 
    if (l < this.size() && this.items[l] < this.items[pos]) {
      smallest = l; 
    }
    if (r < this.size() && this.items[r] < this.items[smallest]) {
      smallest = r; 
    }
    if (smallest != pos) { 
      this.swap(pos, smallest);
      this.MinHeapify(smallest);
    } 

  } 

  swap(indexOne, indexTwo) {
    const temp = this.items[indexOne];
    this.items[indexOne] = this.items[indexTwo];
    this.items[indexTwo] = temp;
  }

  print() { 
    console.log(this.items);
    for (let i = 1; i <= Math.floor(this.size() / 2 ); i++) { 
      process.stdout.write(" PARENT : " + this.items[i] + " LEFT CHILD : " + this.items[2 * i]  + " RIGHT CHILD :" + this.items[2 * i + 1]); 
      console.log(); 
    } 
  } 

}

let MHT = new MinHeap();
let arr = [ 12, 10, 9, 8, 15, 1, 3, 4, 6, 5, 17, 20 ]

for (var i = 0; i < arr.length; i++){
  MHT.insertKey(arr[i]);
}

MHT.print()
console.log(MHT.getMin())
MHT.decreaseKey(5, -100000)

MHT.print()
MHT.getMin()
console.log(MHT.extractMin())

MHT.print()  
MHT.deleteKey(6)
console.log(" ")
MHT.print() 