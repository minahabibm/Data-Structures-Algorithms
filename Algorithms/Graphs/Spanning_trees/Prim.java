/** Prim's Algorithm
 *
 * Prim's algorithm is a greedy algorithm that finds a minimum spanning tree for a connected weighted graph.

 * 
 * @SEE https://www.programiz.com/dsa/spanning-tree-and-minimum-spanning-tree
 * @SEE https://www.tutorialspoint.com/data_structures_algorithms/spanning_tree.htm
 * @SEE https://www.programiz.com/dsa/prim-algorithm
 * @SEE https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
 *
 * The algorithm works by maintaining a set of vertices included in the MST and repeatedly adding the smallest edge that connects a vertex in the MST to a vertex outside the MST.
 * The algorithm starts with a single vertex and grows the MST by adding edges until all vertices are included.
 * The algorithm is efficient for dense graphs and can be implemented using a priority queue to speed up the selection of the smallest edge. * 
 * 
 * T = O(E + log V) || O(V^2);
 * U = O(V);
 * 
 * while (U ≠ V)
 *     let (u, v) be the lowest cost edge such that u ∈ U and v ∈ V - U;
 *     T = T ∪ {(u, v)}
 *     U = U ∪ {v}
 */
import java.util.*;

class Prim {

  public int[] primPq(int[][] graph) {
    int V = graph.length;
    int[] key = new int[V];       // Minimum weight to connect to MST
    int[] mst = new int[V];       // Store MST
    boolean[] inMST = new boolean[V];
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

    Arrays.fill(key, Integer.MAX_VALUE);
    key[0] = 0;
    mst[0] = -1;

    pq.offer(new int[]{0, 0});
    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int u = curr[1];

      if (inMST[u]) continue;
      inMST[u] = true;

      for (int v = 0; v < V; v++) {
        if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
          key[v] = graph[u][v];
          mst[v] = u;
          pq.offer(new int[]{key[v], v});
        }
      }
    }

    return mst;  // Return the MST
  }

  public int[] primArr(int[][] graph) {
    int V = graph.length;
    boolean[] inMST = new boolean[V];
    int[] key = new int[V];       // Minimum weight to connect to MST
    int[] mst = new int[V];       // Store MST (parent of each node)

    // Initialize key values and the MST
    Arrays.fill(key, Integer.MAX_VALUE);
    key[0] = 0;
    mst[0] = -1;

    // Run Prim's algorithm to construct the MST
    for (int count = 0; count < V - 1; count++) {
      // Find the vertex with the minimum key value that is not yet in MST
      int u = selectMinVertex(key, inMST, V);

      inMST[u] = true;  // Add u to the MST

      // Update the key values for all adjacent vertices of u
      for (int v = 0; v < V; v++) {
        if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
          key[v] = graph[u][v];  // Update the key for vertex v
          mst[v] = u;            // Set u as the parent of v
        }
      }
    }

    return mst;  // Return the MST
  }

  // Function to find the vertex with the minimum key value that is not yet in MST
  private int selectMinVertex(int[] key, boolean[] inMST, int V) {
      int minimum = Integer.MAX_VALUE;
      int vertex = -1;

      for (int i = 0; i < V; i++) {
          if (!inMST[i] && key[i] < minimum) {
              minimum = key[i];
              vertex = i;
          }
      }

      return vertex;
  }

  private void printMST(int[] mst, int[][] graph) {
    System.out.println("Edge \tWeight");
    for (int i = 1; i < mst.length; i++) {
      System.out.println(mst[i] + " - " + i + "\t" + graph[i][mst[i]]);
    }
  }

  public static void main(String[] args ){
    System.out.println("\nPrim’s Minimum Spanning Tree");
    // number of vertices in grapj
    int V = 5;

    // create a 2d array of size 5x5 for adjacency matrix to represent graph
    int[][] G = { 
      { 0, 9, 75, 0, 0 }, 
      { 9, 0, 95, 19, 42 }, 
      { 75, 95, 0, 51, 66 }, 
      { 0, 19, 51, 0, 31 },
      { 0, 42, 66, 31, 0 } 
    };

    // create an object of the class
    Prim prim = new Prim();

    int[] mst = prim.primPq(G);
    prim.printMST(mst, G);
    
    mst = prim.primArr(G);
    prim.printMST(mst, G);

  } 
}
