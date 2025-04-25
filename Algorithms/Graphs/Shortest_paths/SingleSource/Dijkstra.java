/** Dijkstra's Algorithm
*
* @SEE https://www.programiz.com/dsa/dijkstra-algorithm
* @SEE https://www.freecodecamp.org/news/dijkstras-shortest-path-algorithm-visual-introduction/
* @SEE https://stackabuse.com/courses/graphs-in-python-theory-and-implementation/lessons/dijkstras-algorithm/
* @SEE https://www.geeksforgeeks.org/dijkstras-algorithm-for-adjacency-list-representation-greedy-algo-8/
* @SEE https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
* @SEE https://www.geeksforgeeks.org/printing-paths-dijkstras-shortest-path-algorithm/
*
* function dijkstra(G, S)
*   for each vertex V in G
*     distance[V] <- infinite
*     previous[V] <- NULL
*     If V != S, add V to Priority Queue Q
*   distance[S] <- 0
*
* while Q IS NOT EMPTY
*   U <- Extract MIN from Q
*   for each unvisited neighbour V of U
*     tempDistance <- distance[U] + edge_weight(U, V)
*     if tempDistance < distance[V]
*       distance[V] <- tempDistance
*       previous[V] <- U
* return distance[], previous[]
*/
import Data_Structure.NonLinear_DataStructure_Graphs.Graph.*;
import java.util.*;

public class Dijkstra {

  public static void dijkstra(GraphAdjacencyMatrix graph, int start_vertex) {
    int count = graph.getSize();
    
    int[] distances = new int[count];
    for (int i = 0; i < count; i++) 
      distances[i] = Integer.MAX_VALUE;
    distances[start_vertex] = 0;
    
    PriorityQueue<int[]>  pqueue = new PriorityQueue<int[]>((x,y) -> x[1] - y[1]); // 0->vertex, 1->weight 
    pqueue.add(new int[]{start_vertex, 0});

    while(!pqueue.isEmpty()) {
      int[] nodeArr = pqueue.poll();
      int current_vertex  = nodeArr[0];
      int weight = nodeArr[1];
      // graph.visited.append(current_vertex)

      for(int neighbor = 0; neighbor < count; neighbor++) {
        if(graph.isEdge(current_vertex, neighbor)){
          int dist = graph.getEdge(current_vertex, neighbor);
          // if neighbor not in graph.visited:
          int old_cost = distances[neighbor];
          int new_cost = distances[current_vertex] + dist;
          if (new_cost < old_cost){
            pqueue.add(new int[]{neighbor, new_cost});
            distances[neighbor] = new_cost;
          }
        }
      }

    }

    printSolution(distances, count, start_vertex);
    // return distance;
    
  }
  
  public static void dijkstra_(int[][] graph, int source) {
    int count = graph.length;
    boolean[] visitedVertex = new boolean[count];
    int[] distances = new int[count];

    // Parent array to store shortest path tree
    int[] parents = new int[count];
    parents[source] = -1 ;
    
    for (int i = 0; i < count; i++) {
      visitedVertex[i] = false;
      distances[i] = Integer.MAX_VALUE;
    }

    // Distance of self loop is zero
    distances[source] = 0;
    for (int i = 0; i < count; i++) {

      // Update the distance between neighbouring vertex and source vertex
      int u = findMinDistance(distances, visitedVertex);
      visitedVertex[u] = true;

      // Update all the neighbouring vertex distances
      for (int v = 0; v < count; v++) {
        if (!visitedVertex[v] && graph[u][v] != 0 && (distances[u] + graph[u][v] < distances[v])) {
          distances[v] = distances[u] + graph[u][v];
          parents[v] = u;
        }
      }
    }
    
    // printSolution(distances, count, source);
    printSolution(distances, source, parents);

  }
  // Finding the minimum distance
  private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
    int minDistance = Integer.MAX_VALUE;
    int minDistanceVertex = -1;
    for (int i = 0; i < distance.length; i++) {
      if (!visitedVertex[i] && distance[i] < minDistance) {
        minDistance = distance[i];
        minDistanceVertex = i;
      }
    }
    return minDistanceVertex;
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
  // A utility function to print the constructed distances array and shortest paths
  private static void printSolution(int[] distances, int startVertex, int[] parents) {
    int nVertices = distances.length;
    System.out.print("Vertex\t Distance\tPath");
    for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
      if (vertexIndex != startVertex){
        System.out.print("\n" + startVertex + " -> ");
        System.out.print(vertexIndex + " \t\t ");
        System.out.print(distances[vertexIndex] + "\t\t");
        printPath(vertexIndex, parents);
      }
    }
    System.out.println("");
  }
  // Function to print shortest path from source to j usingparent array
  static void printPath(int currentVertex, int[] parents ) {         
    // Base case : Source node has been processed
    if (currentVertex == -1){
      return;
    }
    printPath(parents[currentVertex], parents);
    System.out.print(currentVertex + " ");
    }

  public static void main(String[] args) {
    System.out.println("\nDijkstra Shortest path");

    GraphAdjacencyMatrix GraphMxLst =  new GraphAdjacencyMatrix(10, true);
    GraphMxLst.addEdge(0, 1, 4);
    GraphMxLst.addEdge(0, 6, 7);
    GraphMxLst.addEdge(1, 6, 11);
    GraphMxLst.addEdge(1, 7, 20);
    GraphMxLst.addEdge(1, 2, 9);
    GraphMxLst.addEdge(2, 3, 6);
    GraphMxLst.addEdge(2, 4, 2);
    GraphMxLst.addEdge(3, 4, 10);
    GraphMxLst.addEdge(3, 5, 5);
    GraphMxLst.addEdge(4, 5, 15);
    GraphMxLst.addEdge(4, 7, 1);
    GraphMxLst.addEdge(4, 8, 5);
    GraphMxLst.addEdge(5, 8, 12);
    GraphMxLst.addEdge(6, 7, 1);
    GraphMxLst.addEdge(7, 8, 3);
    dijkstra(GraphMxLst, 0);

    GraphAdjacencyMatrix GraphMxLst_ =  new GraphAdjacencyMatrix(10, true);
    GraphMxLst_.addEdge(0, 1, 4);
    GraphMxLst_.addEdge(0, 7, 8);
    GraphMxLst_.addEdge(1, 2, 8);
    GraphMxLst_.addEdge(1, 7, 11);
    GraphMxLst_.addEdge(1, 0, 7);
    GraphMxLst_.addEdge(2, 1, 8);
    GraphMxLst_.addEdge(2, 3, 7);
    GraphMxLst_.addEdge(2, 8, 2);
    GraphMxLst_.addEdge(2, 5, 4);
    GraphMxLst_.addEdge(3, 2, 7);
    GraphMxLst_.addEdge(3, 4, 9);
    GraphMxLst_.addEdge(3, 5, 14);
    GraphMxLst_.addEdge(4, 3, 9);
    GraphMxLst_.addEdge(4, 5, 10);
    GraphMxLst_.addEdge(5, 4, 10);
    GraphMxLst_.addEdge(5, 6, 2);
    GraphMxLst_.addEdge(6, 5, 2);
    GraphMxLst_.addEdge(6, 7, 1);
    GraphMxLst_.addEdge(6, 8, 6);
    GraphMxLst_.addEdge(7, 0, 8);
    GraphMxLst_.addEdge(7, 1, 11);
    GraphMxLst_.addEdge(7, 6, 1);
    GraphMxLst_.addEdge(7, 8, 7);
    GraphMxLst_.addEdge(8, 2, 2);
    GraphMxLst_.addEdge(8, 6, 6);
    GraphMxLst_.addEdge(8, 7, 1);
    dijkstra(GraphMxLst_, 0);


    int graph[][] = new int[][] { 
      { 0, 0, 1, 2, 0, 0, 0 }, 
      { 0, 0, 2, 0, 0, 3, 0 }, 
      { 1, 2, 0, 1, 3, 0, 0 },
      { 2, 0, 1, 0, 0, 0, 1 }, 
      { 0, 0, 3, 0, 0, 2, 0 }, 
      { 0, 3, 0, 0, 2, 0, 1 }, 
      { 0, 0, 0, 1, 0, 1, 0 } 
    };
    dijkstra_(graph, 0);

    int graph_[][] = new int[][] { 
      { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } 
    };
    dijkstra_(graph_, 0);


  }
}