/** Depth First Search Algorithm
*   create a stack st 
*   mark v as visited and put v into st 
*   while st is non-empty 
*     remove the head u of st 
*     mark and push all (unvisited) neighbours of u    //  create a stack st 
*   mark v as visited and put v into st 
*   while st is non-empty 
*     remove the head u of st 
*     mark and push all (unvisited) neighbours of u
*/
import java.util.*;
import Data_Structure.NonLinear_DataStructure_Graphs.Graph.*;

public class DepthFirstSearch {

  public static void DFS(GraphAdjacencyList graph, int vertex) {
    Stack<Integer> stack = new Stack<Integer>();
    boolean visited[] = new boolean[graph.getV()];
    
    visited[vertex] = true;
    stack.push(vertex);
    
    while (!stack.isEmpty()) {
      vertex = stack.pop();
      System.out.print(vertex + " ");
      
      for (int dest : graph.getAdj()[vertex]) {
        if (!visited[dest]) {
          visited[dest] = true;
          stack.push(dest);
        }
      }
    }
    
  };

  public static void DFS_Recursive(GraphAdjacencyList graph, int vertex, boolean[] visited) {
    // Mark the current node as visited and print it
    // Recur for all the vertices adjacent to this vertex
    visited[vertex] = true;
    System.out.print(vertex + " ");
    
    for (int dest : graph.getAdj()[vertex])
      if (!visited[dest]) {
        DFS_Recursive(graph,dest, visited);
    }
  };

  public static void main(String[] args) {
    System.out.println("\nDepth First Search");
    GraphAdjacencyList g = new GraphAdjacencyList(5);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    g.addEdge(1, 4);
    g.addEdge(4, 2);
    System.out.println("Following is Depth First Search (starting from vertex 2)" + "\nIterative Traversal ");
    DFS(g, 2);
    System.out.println("\nRecursive Traversal ");
    DFS_Recursive(g, 2, new boolean[5]);
  }
  
}