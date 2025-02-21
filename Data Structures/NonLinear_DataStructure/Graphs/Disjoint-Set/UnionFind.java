/** Disjoint set
*
*   @SEE https://www.cs.cmu.edu/~avrim/451f13/lectures/lect0912.pdf
*   @SEE https://www.techiedelight.com/disjoint-set-data-structure-union-find-algorithm/
*   @SEE https://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/
*   @SEE https://www.geeksforgeeks.org/disjoint-set-data-structures/
*   
*/
class Subset {
  int parent, rank;
  Subset(int v, int rank) {
    this.parent = v;
    this.rank = rank;
  }
 };
class DisjointUnionSetsGraph {
  Subset[] subsets;

  public DisjointUnionSetsGraph() {};

  public DisjointUnionSetsGraph(int vertices) {
    subsets = new Subset[vertices];
    makeSet();
  }

  void makeSet() {
    for(int v=0; v<subsets.length; v++) {
      Subset subsetV = new Subset(v,0);
      subsets[v] = subsetV;
    } 
  }
  
  // A utility function to find set of an element i (uses path compression technique)
  int Find(Subset[] subsets, int i) {
    if (subsets[i].parent != i)
      subsets[i].parent = Find(subsets, subsets[i].parent);
    return subsets[i].parent;
  }
 
  // A function that does union of two sets of x and y (uses union by rank)
  void Union(Subset[] subsets, int x, int y) {
    int xroot = Find(subsets, x);
    int yroot = Find(subsets, y);
  
    if (subsets[xroot].rank < subsets[yroot].rank)
      subsets[xroot].parent = yroot;
    else if (subsets[yroot].rank < subsets[xroot].rank)
      subsets[yroot].parent = xroot;
    else {
      subsets[xroot].parent = yroot;
      subsets[yroot].rank++;
    }
  }

  public void printSets(int[] forest) {
    for (int i: forest)
      System.out.print(Find(subsets, i) + " ");
    System.out.println();
  }
  
  public static void main(String[] args) {
    // universe of items
    int[] forest = { 1, 2, 3, 4, 5 };

    // initialize `DisjointSet` class
    DisjointUnionSets ds = new DisjointUnionSets(6);
    ds.printSets(forest);

    ds.Union(ds.subsets, 4, 3);        // 4 and 3 are in the same set
    ds.printSets(forest);

    ds.Union(ds.subsets, 2, 1);        // 1 and 2 are in the same set
    ds.printSets(forest);
    
    ds.Union(ds.subsets, 1, 3);        // 1, 2, 3, 4 are in the same set
    ds.printSets(forest);
  }
  
}

class DisjointSetUnion{
  // Declaring two arrays to hold information about the parent and rank of each node. 
  private int parent[], rank[];
  // Constructor
  DisjointSetUnion(int n){
    // Defining size of the arrays.
    parent=new int[n];
    rank=new int[n];
    // Initializing their values by is and 0s.
    for(int i=0;i<n;i++) {
      parent[i]=i;
      rank[i]=0;
    }
  }
  // Find function
  public int find(int node){
    // If the node is the parent of itself then it is the leader of the tree. 
    if(node==parent[node]) return node;
    //Else, finding parent and also compressing the paths.
    return parent[node]=find(parent[node]);
  }
  // Union function 
  public void union(int u,int v){
    // Make u as a leader of its tree.
    u=find(u);
    // Make v as a leader of its tree.
    v=find(v);
    // If u and v are not equal, because if they are equal then 
    // it means they are already in same tree and it does not make sense to perform union operation.
    if(u!=v) {
      // Checking tree with smaller depth/height.
      if(rank[u]<rank[v]) {
        int temp=u;
        u=v;
        v=temp;
      }
      // Attaching lower rank tree to the higher one. 
      parent[v]=u;
      // If now ranks are equal increasing rank of u. 
      if(rank[u]==rank[v])
        rank[u]++;
    }
  }
}

public class UnionFind {
  public static void main(String[] args) {
    System.out.println("\nDisjoint Union-find set Graph");
    new DisjointUnionSetsGraph().main(args);

    System.out.println("\nDisjoint Set \ Union-find ");
    // new DisjointSetUnion().main(args);
    int n = 5;
    DisjointSetUnion dsu = new DisjointSetUnion(n);

    dsu.union(0, 2);
    dsu.union(4, 2);  
    dsu.union(3, 1);

    // Check if 4 is a friend of 0
    if (dsu.find(4) == dsu.find(0))
      System.out.println("\nYes");
    else
      System.out.println("\nNo");

    // Check if 1 is a friend of 0
    if (dsu.find(1) == dsu.find(0))
      System.out.println("Yes");
    else
      System.out.println("No");
  }
}
