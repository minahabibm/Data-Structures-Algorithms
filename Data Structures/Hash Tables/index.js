/** Collision resolution techniques:
Separate chaining (open hashing)
Linear probing (open addressing or closed hashing)
Quadratic Probing
*Double hashing
*/

class HashTable {
  constructor() {
    this.values = {};
    this.length =  0;
    this.size = 15;
  }

  calculateHash1(key) {
    return key.toString().length % this.size;
  }

  calculateHash2(key) {
    const PRIMENU = 7;
    return (PRIMENU - (key.toString().length % PRIMENU)); 
  }
  
  addElement(key, value) {
    if (this.length === this.size) {
      console.log("hashtable is full");
      return false
    }

    const hash1 = this.calculateHash1(key);
    const hash2 = this.calculateHash2(key); 
    let i = 0;
    while(true) {
      let newhash1 = (hash1 + hash2 * i ) % this.size;
      if (this.values.hasOwnProperty(newhash1)){
        if (Object.keys(this.values[newhash1])[0] === key){
          this.values[newhash1] = { [key] : value }
          return true
        } 
      } else {
        this.values[newhash1] = {};
        this.values[newhash1][key] = value;
        this.length++;
        return true
      }
      
      i ++
      i += i*5;
    }

    return true
  }

  searchElement(key) {
    if(this.length === 0) {
      console.log("item not found")
      return [false, -1];
    }
    const hash1 = this.calculateHash1(key);
    const hash2 = this.calculateHash2(key); 
    let i = 0;
    while(true) {
      let newhash1 = (hash1 + hash2 * i ) % this.size;
      if (this.values.hasOwnProperty(newhash1)){
        if (Object.keys(this.values[newhash1])[0] === key){
          return [true, newhash1];
        } else {
          i ++
          i += i*5;
        } 
      } else {
        return [false, -1];
      }
    }
  }

  deleteElement(key){
    if(this.length === 0) {
      return false;
    }
    let index = this.searchElement(key);
 
    if(index[0] === false) {
      return false;
    } else {
      delete this.values[index[1]];
      this.length --;
      return true;
    }
  }

  displayHash() { 
    console.log("Number of Items =",this.length);
    console.log("Size of Hash Table =", this.size);
    for (const [key, value] of Object.entries(this.values)) {
      console.log(key, "-->", value);
    }
  } 

}

//create object of type hash table of size bigger than the prime number 
console.log("Double hashing Hash Table");
const hashTable = new HashTable();

const dicPair = [ ["a", "1"], ["b", "2"], ["c", "3"], ["d", "4"], ["e", "5"], ["f", "6"], ["g", "7"], ["h", "8"], ["i", "9"], ["j", "10"], ["I", "XV"], ["V", "I"], ["I", "VI"], ["IIV", "V"], ["IVI","I"] ];

for (let i = 0; i< dicPair.length; i++) {
  hashTable.addElement(dicPair[i][0], dicPair[i][1]);
}
hashTable.displayHash();

hashTable.addElement(1, "dicPair[i][1]");
hashTable.addElement(1, "a");
hashTable.displayHash();

console.log(hashTable.searchElement("a"));
console.log(hashTable.searchElement(1));

console.log(hashTable.deleteElement("f"));
console.log(hashTable.searchElement("f"));
hashTable.displayHash();

hashTable.addElement("g", "7");
hashTable.addElement("j", "7");
hashTable.displayHash();
