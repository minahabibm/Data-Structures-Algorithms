 /** Kosaraju's Algorithm
*
*  @SEE https://www.programiz.com/dsa/strongly-connected-components
*  @SEE https://www.geeksforgeeks.org/strongly-connected-components/
*  @SEE https://www.topcoder.com/thrive/articles/kosarajus-algorithm-for-strongly-connected-components
*
*  Perform DFS traversal of the graph. Push node to stack before returning.
*  Find the transpose graph by reversing the edges.
*  Pop nodes one by one from the stack and again to DFS on the modified graph.
*/

class Kosaraju {

  public static void main(String[] args) {
    System.out.println("\nKosaraju's Strongly Connnected Components");
  }
}