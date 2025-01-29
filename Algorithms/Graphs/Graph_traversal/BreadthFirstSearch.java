/** Breadth First Search Algorithm
*   create a queue Q 
*   mark v as visited and put v into Q 
*   while Q is non-empty 
*     remove the head u of Q 
*     mark and enqueue all (unvisited) neighbours of u  //  create a queue Q 
*   mark v as visited and put v into Q 
*   while Q is non-empty 
*     remove the head u of Q 
*     mark and enqueue all (unvisited) neighbours of u
*/
import java.util.*;
import Data_Structure.NonLinear_DataStructure_Graphs.Graph.*;

public class BreadthFirstSearch {

  public static void BFS(GraphAdjacencyList graph, int vertex) {
    LinkedList<Integer> queue = new LinkedList<Integer>();
    boolean visited[] = new boolean[graph.getV()];

    visited[vertex] = true;
    queue.add(vertex);
    
    while (!queue.isEmpty()) {
      vertex = queue.poll();
      System.out.print(vertex + " ");
      
      for (int dest: graph.getAdj()[vertex]){
        if (!visited[dest]){
          visited[dest] = true;
          queue.add(dest);
        }
      }
    }
    
  };

  public static void main(String[] args) {
    System.out.println("\nBreadth First Search");
    GraphAdjacencyList g = new GraphAdjacencyList(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
    BFS(g, 2);
  }
  
}
