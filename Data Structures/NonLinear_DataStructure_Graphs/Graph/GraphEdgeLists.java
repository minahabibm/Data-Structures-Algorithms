// Edge lists
// Weighted-Directed Edge Graph
class Edge implements Comparable<Edge>  {
  int src, dest, weight;
  
  public int compareTo(Edge compareEdge) {
    return this.weight - compareEdge.weight;
  }

  Edge() {
    src = dest = weight = 0;
  }
  
};

public class GraphEdgeLists {
  int V, E;
  Edge edge[];

  // Creates a graph with V vertices and E edges
  GraphEdgeLists(int v, int e) {
    V = v;
    E = e;
    edge = new Edge[e];
    for (int i = 0; i < e; ++i)
      edge[i] = new Edge();
  }
  
}