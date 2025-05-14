// Adjacency List
// Unweighted-Directed Edge Graph
import java.util.*;

public class GraphAdjacencyList {
  private int V;
  private LinkedList<Integer> adj[];

  // Create a graph
  public GraphAdjacencyList(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i)
      adj[i] = new LinkedList<Integer>();
  }

  // Add edges to the graph
  public void addEdge(int v, int w) {
    adj[v].add(w);
  }

  public int getV() {
    return (int)V;
  }

  public LinkedList<Integer>[] getAdj() {
    return adj;
  }  
}