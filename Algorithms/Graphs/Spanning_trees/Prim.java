/** Prim's Algorithm
*
* @SEE https://www.programiz.com/dsa/spanning-tree-and-minimum-spanning-tree
* @SEE https://www.tutorialspoint.com/data_structures_algorithms/spanning_tree.htm
* @SEE https://www.programiz.com/dsa/prim-algorithm
* @SEE https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
* T = ∅;
* U = { 1 };
* while (U ≠ V)
*     let (u, v) be the lowest cost edge such that u ∈ U and v ∈ V - U;
*     T = T ∪ {(u, v)}
*     U = U ∪ {v}
*/
import java.util.*;

class Prim {

  public static void prim(int G[][], int V) {

    int INF = 9999999;
    int no_edge = 0; // number of edge

    // create a array to track selected vertex, selected will become true otherwise false
    boolean[] selected = new boolean[V];
    Arrays.fill(selected, false);
    selected[0] = true;
    
    // the number of egde in minimum spanning tree will be always less than (V -1), where V is number of vertices in graph print for edge and weight
    System.out.println("Edge : Weight");

    while (no_edge < V - 1) {
      // For every vertex in the set S, find the all adjacent vertices, calculate the distance from the vertex selected at step 1.
      // if the vertex is already in the set S, discard it otherwise choose another vertex nearest to selected vertex at step 1.

      int min = INF;
      int x = 0; // row number
      int y = 0; // col number

      for (int i = 0; i < V; i++) {
        if (selected[i] == true) {
          for (int j = 0; j < V; j++) {
            // not in selected and there is an edge
            if (!selected[j] && G[i][j] != 0) {
              if (min > G[i][j]) {
                min = G[i][j];
                x = i;
                y = j;
              }
            }
          }
        }
      }
      selected[y] = true;
      no_edge++;

      System.out.println(x + " - " + y + " :  " + G[x][y]);
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

    prim(G, V);
  }
}