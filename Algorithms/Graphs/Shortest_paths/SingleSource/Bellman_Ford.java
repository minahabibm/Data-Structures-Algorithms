/** Bellman–Ford Algorithm
  *
  * @SEE https://www.programiz.com/dsa/bellman-ford-algorithm
  * @SEE https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
  * @SEE https://www.geeksforgeeks.org/detect-negative-cycle-graph-bellman-ford/
  * @SEE https://www.geeksforgeeks.org/bellman-ford-algorithm-simple-implementation/
  * @PROS it can work with graphs in which edges can have negative weights.
  *
  * function bellmanFord(G, S)
  *   for each vertex V in G
  *     distance[V] <- infinite
  *       previous[V] <- NULL
  *   distance[S] <- 0
  *
  *   for each vertex V in G				
  *     for each edge (U,V) in G
  *       tempDistance <- distance[U] + edge_weight(U, V)
  *       if tempDistance < distance[V]
  *         distance[V] <- tempDistance
  *         previous[V] <- U
  *
  *   for each edge (U,V) in G
  *     If distance[U] + edge_weight(U, V) < distance[V}
  *       Error: Negative Cycle Exists
  *
  *   return distance[], previous[]
  */
import Data_Structure.NonLinear_DataStructure_Graphs.Graph.*;

class Bellman_Ford {
 
  public static void BellmanFord(WeightedDirectedGraph graph, int s) {
    int V = graph.V, E = graph.E;
    int dist[] = new int[V];

    // Step 1: fill the distance array and predecessor array
    for (int i = 0; i < V; ++i)
      dist[i] = Integer.MAX_VALUE;

    // Mark the source vertex
    dist[s] = 0;

    // Step 2: relax edges |V| - 1 times
    for (int i = 1; i < V; ++i) {
      for (int j = 0; j < E; ++j) {
        // Get the edge data
        int u = graph.edge[j].src;
        int v = graph.edge[j].dest;
        int w = graph.edge[j].weight;
        if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
          dist[v] = dist[u] + w;
      }
    }

    // Step 3: detect negative cycle
    // if value changes then we have a negative cycle in the graph
    // and we cannot find the shortest distances
    for (int j = 0; j < E; ++j) {
      int u = graph.edge[j].src;
      int v = graph.edge[j].dest;
      int w = graph.edge[j].weight;
      if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
        System.out.println("Graph contains a negative-weight cycle");
        return;
      }
    }

    // No negative w cycle found!
    // Print the distance and predecessor array
    printSolution(dist, V, s);
  }

  // A utility function to print the constructed distance array
  static void printSolution(int dist[], int V, int source) {
    for (int i = 0; i < dist.length; i++) {
      System.out.println(String.format("Distance from %s to %s is %s", source, i, dist[i]));
    }
    // System.out.println("Vertex \t Distance from Source");
    // for (int i = 0; i < V; i++)
    //   System.out.println(i + " \t\t " + dist[i]);
    System.out.println("");
  }

  public static void main(String[] args) {
    System.out.println("\nBellman–Ford Shortest path");
    int V = 5; // Total vertices
    int E = 8; // Total Edges
    
    WeightedDirectedGraph graph = new WeightedDirectedGraph(V, E);
    // edge 0 --> 1
    graph.edge[0].src = 0;
    graph.edge[0].dest = 1;
    graph.edge[0].weight = 5;
    // edge 0 --> 2
    graph.edge[1].src = 0;
    graph.edge[1].dest = 2;
    graph.edge[1].weight = 4;
    // edge 1 --> 3
    graph.edge[2].src = 1;
    graph.edge[2].dest = 3;
    graph.edge[2].weight = 3;
    // edge 2 --> 1
    graph.edge[3].src = 2;
    graph.edge[3].dest = 1;
    graph.edge[3].weight = 6;
    // edge 3 --> 2
    graph.edge[4].src = 3;
    graph.edge[4].dest = 2;
    graph.edge[4].weight = 2;
    BellmanFord(graph, 0); // 0 is the source vertex

    WeightedDirectedGraph graph_ = new WeightedDirectedGraph(V, E);
    // add edge 0-1 (or A-B in above figure)
    graph_.edge[0].src = 0;
    graph_.edge[0].dest = 1;
    graph_.edge[0].weight = -1;
    // add edge 0-2 (or A-C in above figure)
    graph_.edge[1].src = 0;
    graph_.edge[1].dest = 2;
    graph_.edge[1].weight = 4;
    // add edge 1-2 (or B-C in above figure)
    graph_.edge[2].src = 1;
    graph_.edge[2].dest = 2;
    graph_.edge[2].weight = 3;
    // add edge 1-3 (or B-D in above figure)
    graph_.edge[3].src = 1;
    graph_.edge[3].dest = 3;
    graph_.edge[3].weight = 2;
    // add edge 1-4 (or B-E in above figure)
    graph_.edge[4].src = 1;
    graph_.edge[4].dest = 4;
    graph_.edge[4].weight = 2;
    // add edge 3-2 (or D-C in above figure)
    graph_.edge[5].src = 3;
    graph_.edge[5].dest = 2;
    graph_.edge[5].weight = 5;
    // add edge 3-1 (or D-B in above figure)
    graph_.edge[6].src = 3;
    graph_.edge[6].dest = 1;
    graph_.edge[6].weight = 1;
    // add edge 4-3 (or E-D in above figure)
    graph_.edge[7].src = 4;
    graph_.edge[7].dest = 3;
    graph_.edge[7].weight = -3;
    BellmanFord(graph_, 0);

    WeightedDirectedGraph graph__ = new WeightedDirectedGraph(4, 4);
    // add edge 0-1 (or A-B in above figure)
    graph__.edge[0].src = 0;
    graph__.edge[0].dest = 1;
    graph__.edge[0].weight = 1;
    // add edge 0-2 (or A-C in above figure)
    graph__.edge[1].src = 1;
    graph__.edge[1].dest = 2;
    graph__.edge[1].weight = -1;
    // add edge 1-2 (or B-C in above figure)
    graph__.edge[2].src = 2;
    graph__.edge[2].dest = 3;
    graph__.edge[2].weight = -1;
    // add edge 1-3 (or B-D in above figure)
    graph__.edge[3].src = 3;
    graph__.edge[3].dest = 0;
    graph__.edge[3].weight = -1;
    BellmanFord(graph__, 0);

  }
}