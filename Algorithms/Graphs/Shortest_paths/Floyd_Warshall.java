/** Floyd–Warshall Algorithm
*
* @SEE https://www.programiz.com/dsa/floyd-warshall-algorithm
* @SEE https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
* @SEE https://www.geeksforgeeks.org/finding-shortest-path-between-any-two-nodes-using-floyd-warshall-algorithm/?ref=rp
*
* n = no of vertices
* A = matrix of dimension n*n
* for k = 1 to n
*   for i = 1 to n
*       for j = 1 to n
*           Ak[i, j] = min (Ak-1[i, j], Ak-1[i, k] + Ak-1[k, j])
* return A
*/

import Data_Structure.NonLinear_DataStructure_Graphs.Graph.*;

class Floyd_warshall{

  final static int INF = 99999;
  
  public static void floydWarshall(int graph[][]) {
    int nV = graph.length;
    int matrix[][] = new int[nV][nV];
    int i, j, k;

    for (i = 0; i < nV; i++)
      for (j = 0; j < nV; j++)
        matrix[i][j] = graph[i][j];

    // Adding vertices individually
    for (k = 0; k < nV; k++) {
      for (i = 0; i < nV; i++) {
        for (j = 0; j < nV; j++) {
          if (matrix[i][k] + matrix[k][j] < matrix[i][j])
            matrix[i][j] = matrix[i][k] + matrix[k][j];
        }
      }
    }
    
    printSolution(matrix);
  }

  public static void printSolution(int matrix[][]) {
    int nV = matrix.length;
    for (int i = 0; i < nV; ++i) {
      for (int j = 0; j < nV; ++j) {
        if (matrix[i][j] == INF)
          System.out.print("INF ");
        else
          System.out.print(matrix[i][j] + "   ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    System.out.println("\nFloyd-Warshall Shortest path");

    int graph[][] = { 
      { 0, 3, INF, 5 }, 
      { 2, 0, INF, 4 }, 
      { INF, 1, 0, INF }, 
      { INF, INF, 2, 0 } 
    };
    floydWarshall(graph);

    int graph_[][] = { 
      {0,   5,  INF, 10},
      {INF, 0,   3, INF},
      {INF, INF, 0,   1},
      {INF, INF, INF, 0}
    };
     floydWarshall(graph_);
  }
}
