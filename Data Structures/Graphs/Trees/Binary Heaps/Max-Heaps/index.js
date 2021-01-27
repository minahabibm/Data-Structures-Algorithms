class MaxHeap{

  constructor() {
    this.items = [Number.POSITIVE_INFINITY];
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
      while (index != 0 && this.items[index] > this.items[this.parent(index)] ) {
        this.swap(index,this.parent(index));
        index = this.parent(index);

      }
    }
  }

  increaseKey(index, data) {
    if (this.items[index] > data){
      return ("error")
    }
    this.items[index] = data; 
    while (index != 0 && this.items[index] > this.items[this.parent(index)] ) {
      this.swap(index,this.parent(index));
      index = this.parent(index);
    }
  } 

  extractMax() { 
    let popped = this.items[1]; 
    this.items[1] = this.items[this.size()-1];
    this.items.length -= 1;
    this.MaxHeapify(1);
    return popped 
  }

  deleteKey(pos) { 
    this.increaseKey(pos, Number.POSITIVE_INFINITY);
    this.extractMax(); 
  } 

  getMax() {
    /* Accessing the min element at index 1 in the heap array */
    return this.items[1]
  }

  MaxHeapify(pos) { 
    let l = this.left(pos); 
    let r = this.right(pos); 
    let largest = pos; 
    if (l < this.size() && this.items[l] > this.items[pos]) {
      largest = l; 
    }
    if (r < this.size() && this.items[r] > this.items[largest]) {
      largest = r; 
    }
    if (largest != pos) { 
      this.swap(pos, largest);
      this.MaxHeapify(largest);
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

let MHT = new MaxHeap();
let arr = [ 12, 10, 9, 8, 15, 1, 3, 4, 6, 5, 17, 20 ]

for (var i = 0; i < arr.length; i++){
  MHT.insertKey(arr[i]);
}

MHT.print()
console.log(MHT.getMax())
MHT.increaseKey(5, 100000)

MHT.print()
MHT.getMax()
console.log(MHT.extractMax())

MHT.print()  
MHT.deleteKey(6)
console.log(" ")
MHT.print() 