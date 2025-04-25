/** Kruskal's Algorithm
 * 
 * A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight.
 * 
 * @SEE https://www.programiz.com/dsa/kruskal-algorithm
 * @SEE https://www.tutorialspoint.com/data_structures_algorithms/spanning_tree.htm
 * @SEE https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/
 *
 * Kruskal's algorithm is a greedy algorithm that finds a minimum spanning tree for a connected weighted graph.
 * The algorithm works by sorting the edges of the graph in non-decreasing order of their weight.  
 * It then picks the smallest edge and checks if it forms a cycle with the spanning tree formed so far. Uses Union-Find (Disjoint Set) to detect cycles.
 * If it doesn't, it adds it to the spanning tree. This process is repeated until there are (V-1) edges in the spanning tree. 
 *
 * T = O(E log E);
 * U = O(E);
 *  
 * KRUSKAL(G):
 * A = ∅
 * For each vertex v ∈ G.V:
 *    MAKE-SET(v)
 * For each edge (u, v) ∈ G.E ordered by increasing order by weight(u, v):
 *    if FIND-SET(u) ≠ FIND-SET(v):       
 *    A = A ∪ {(u, v)}
 *    UNION(u, v)
 *  return A
 */
import java.util.*;
import Data_Structure.NonLinear_DataStructure_Graphs.Graph.*;

class Kruskal {

  public static void kruskal(GraphEdgeLists graph, int vertices) {
    int edge = 0, index = 0;
    Edge result[] = new Edge[vertices];
    DisjointUnionSets DUFS = new DisjointUnionSets(vertices); 
    
    Arrays.fill(result,  new Edge());   // Adding the Edges
    Arrays.sort(graph.edge);            // Sorting the edges

    while (edge < vertices - 1) {
      Edge next_edge = graph.edge[index++];
      int x = DUFS.Find(DUFS.subsets, next_edge.src);
      int y = DUFS.Find(DUFS.subsets, next_edge.dest);
      if (x != y) {
        result[edge++] = next_edge;
        DUFS.Union(DUFS.subsets, x, y);
      }
    }
    
    for (int i = 0; i < edge; ++i)
      System.out.println(result[i].src + " - " + result[i].dest + ": " + result[i].weight);
    
  }

  public static void main(String[] args) {
    System.out.println("\nKruskal’s Minimum Spanning Tree");
    int V = 6; // Number of vertices
    int E = 8; // Number of edges
    GraphEdgeLists G = new GraphEdgeLists(V, E);

    G.edge[0].src = 0;
    G.edge[0].dest = 1;
    G.edge[0].weight = 4;
    // add edge
    G.edge[1].src = 0;
    G.edge[1].dest = 2;
    G.edge[1].weight = 4;
    // add edge
    G.edge[2].src = 1;
    G.edge[2].dest = 2;
    G.edge[2].weight = 2;
    // add edge
    G.edge[3].src = 2;
    G.edge[3].dest = 3;
    G.edge[3].weight = 3;
    // add edge
    G.edge[4].src = 2;
    G.edge[4].dest = 5;
    G.edge[4].weight = 2;
    // add edge
    G.edge[5].src = 2;
    G.edge[5].dest = 4;
    G.edge[5].weight = 4;
    // add edge
    G.edge[6].src = 3;
    G.edge[6].dest = 4;
    G.edge[6].weight = 3;
    // add edge
    G.edge[7].src = 5;
    G.edge[7].dest = 4;
    G.edge[7].weight = 3;
    // Function call
    kruskal(G ,V);

    System.out.println();

    V = 4; // Number of vertices in graph
    E = 5; // Number of edges in graph
    GraphEdgeLists G_ = new GraphEdgeLists(V, E);
  
    // add edge 0-1
    G_.edge[0].src = 0;
    G_.edge[0].dest = 1;
    G_.edge[0].weight = 10;
    // add edge 0-2
    G_.edge[1].src = 0;
    G_.edge[1].dest = 2;
    G_.edge[1].weight = 6;
    // add edge 0-3
    G_.edge[2].src = 0;
    G_.edge[2].dest = 3;
    G_.edge[2].weight = 5;
    // add edge 1-3
    G_.edge[3].src = 1;
    G_.edge[3].dest = 3;
    G_.edge[3].weight = 15;
    // add edge 2-3
    G_.edge[4].src = 2;
    G_.edge[4].dest = 3;
    G_.edge[4].weight = 4;
    // Function call
    kruskal(G_ ,V);
    
  }
  
}