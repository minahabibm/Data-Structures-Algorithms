/**Collision resolution techniques:
Separate chaining (open hashing)
*Linear probing (open addressing or closed hashing)
Quadratic Probing
Double hashing
*/
public class HashTable_ {
  private int currentSize, maxSize;       
  private Object[] keys;   
  private Object[] vals;

  public HashTable_() {}
  public HashTable_(int capacity) {
    currentSize = 0;
    maxSize = capacity;
    keys = new Object[maxSize];
    vals = new Object[maxSize];
  }

  private <T> int getHash(T key){
    return key.toString().hashCode() % maxSize;
  }
  public <T> void insertElement(T key, T val){
    int hash = getHash(key);
    int i = hash;
    do {
      if (keys[i] == null) {
        keys[i] = key;
        vals[i] = val;
        currentSize++;
        return;
      }
      if (keys[i].equals(key)) { 
        vals[i] = val; 
        return; 
      }
      if (!keys[i].equals(key) && currentSize == maxSize ) { 
        System.out.println("array size");
        return; 
      }              
      i = (i + 1) % maxSize;            
    } while (i != hash);   
  }
  public <T> boolean searchElement(T key){
    int i = getHash(key);
    boolean ite = false;
    while (keys[i] != null && ite == false){
      if (keys[i].equals(key)){
        System.out.println(vals[i]);
        return true;
      }
      if (i == maxSize - 1){
        ite = true;
      }else{
        i = (i + 1) % maxSize;
      }
    }
    System.out.println("!!!");
    return false;
  }
  public <T> void removeElement(T key){
    if (!searchElement(key)) {
      return;
    }
      
    int i = getHash(key);
    while (!key.equals(keys[i])) {
      i = (i + 1) % maxSize;
    }      
    keys[i] = vals[i] = null;
    for (i = (i + 1) % maxSize; keys[i] != null; i = (i + 1) % maxSize) {
      Object tmp1 = keys[i];
      Object tmp2 = vals[i];
      keys[i] = vals[i] = null;
      currentSize--;  
      insertElement(tmp1, tmp2);            
    }
    currentSize--;        
  }

  /** Extras*/
  public void print(){
    for(int i = 0; i < maxSize; i ++){
      System.out.println(keys[i] + " : " + vals[i]);
    }
  }


  public static void main(String[] args) {

    System.out.println("Linear probing Hash Table");
    HashTable_ hashTable = new HashTable_(7);

    Object[][] dicPair = {{1,"a"}, {2,"b"}, {3,"c"}, {4,"d"}, {"5","e"}, {6,"f"},{7,"g"}, {8,"h"}};
    for (int i = 0; i < dicPair.length; i++){
      hashTable.insertElement(dicPair[i][0], dicPair[i][1]);
    }

    hashTable.print();
    System.out.println("------------");
    hashTable.insertElement(1, "dicPair[i][1]");
    hashTable.print();
    System.out.println("------------");

    hashTable.searchElement(1);    
    hashTable.searchElement("5");

    hashTable.removeElement(6);
    hashTable.searchElement(6);    
    System.out.println("------------");

    hashTable.print();
    System.out.println("------------");

    hashTable.insertElement("g", "7");
    hashTable.insertElement("j", "7");
    hashTable.print();
    System.out.println("------------");
    
  }
  
}