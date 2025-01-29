// Matrices List
// Weighted-Undirected Edge Graph
import java.util.*; 

public class GraphAdjacencyMatrix {

  private  int[][] adjMatrixGraph;
  private int size;
  private int numVertices;
  private int numEdges;

  public GraphAdjacencyMatrix (){};
  public GraphAdjacencyMatrix (int size){
    this.size = size;
    this.numVertices = 0;
    this.numEdges = 0;
    this.adjMatrixGraph = new int[size][size];
    for(int[] node : adjMatrixGraph){
      Arrays.fill(node, -1);//Integer.MIN_VALUE);
    }
  }
  public GraphAdjacencyMatrix (int size, boolean addNodesSeq){
    if(addNodesSeq) {
      this.size = size;
      this.numVertices = size;
      this.numEdges = 0;
      this.adjMatrixGraph = new int[size][size];
      for(int[] node : adjMatrixGraph){
        Arrays.fill(node, 0);//Integer.MIN_VALUE);
      }
    }
  }

  public int[][] getAdjMatrixGraph() {
    return adjMatrixGraph;
  }
  public int getSize() {
    return size;
  }
  public int getNumVertices() {
    return numVertices;
  }
  public int getNumEdges() {
    return numEdges;
  }
  
  public void addNode(int vertex){
    int numV = this.numVertices;
    if (numV > 0.5 * size || vertex > 0.5 * size ) {
      System.out.println( "Doubling the size" );
      this.size = 2*this.size;

      int[][] newAdjMatrixgraph = new int[size][size];
      for (int i = 0; i < adjMatrixGraph.length; i++) {
        for (int j = 0; j < adjMatrixGraph[0].length; j++) {
          newAdjMatrixgraph[i][j] = adjMatrixGraph[i][j];
        }
      }

      this.adjMatrixGraph = newAdjMatrixgraph;
    }

    for(int i= 0; i <= vertex ; i++) {
      for(int j=0; j <= vertex ; j++) {
        if ( i == vertex ){
          this.adjMatrixGraph[i][j] = 0;
        }
        if ( j == vertex ){
          this.adjMatrixGraph[i][j] = 0;
        }
      }
    }

    this.numVertices = this.numVertices + 1;
    
  }
  public boolean contains(int vertex) { 
    if (this.adjMatrixGraph[vertex][vertex] >= 0 ) {
     return true;
    }
    return false;
  }
  public void removeNode(int vertex){
    int numV = this.numVertices;
    if (numV == 0) {
      System.out.print("Node doesnt exist");
      System.out.println();
      return;
    }

    for(int i= 0; i <= numV - 1; i++) {
      for(int j=0; j <= numV - 1; j++) {
        if ( i == vertex ){
          this.adjMatrixGraph[i][j] = -1;
        }
        if ( j == vertex ){
          this.adjMatrixGraph[i][j] = -1;
        }
      }
    }

    this.numVertices --;
    /**
    if (this.size < 0.5 * numV) {
      this.size = (int) 0.5 * this.size;
      int[][] newAdjMatrixgraph = new int[this.size][this.size];
      for (int i = 0; i < this.size; i++) {
        for (int j = 0; j < this.size; j++) {
          newAdjMatrixgraph[i][j] = adjMatrixGraph[i][j];
        }
      }
      adjMatrixGraph = newAdjMatrixgraph;
    }
    
    for(int i= vertex; i <= numV-1; i++) {
      for(int j=1; j <= numV; j++) {
        this.adjMatrixGraph[j][i] = this.adjMatrixGraph[j][i+1];  // Shift columns left 
        this.adjMatrixGraph[i][j] = this.adjMatrixGraph[i+1][j];  // Shift rows up 
      }
    }
    */
    
  }

  public void addEdge(int dep, int des, int weight) {
    int numV = this.numVertices;
    if (this.adjMatrixGraph[dep][des] == 0 ) {
      this.adjMatrixGraph[dep][des] = weight;
      this.adjMatrixGraph[des][dep] = weight;
    } else if (dep >= numV || des >= numV) {
      System.out.print("add Node to add Edge");
      System.out.println();
      return;
    } 
    this.numEdges ++;     
  }
  public int getEdge(int dep, int des){
    return this.adjMatrixGraph[dep][des];
  }
  public boolean isEdge(int dep, int des) {
    if((this.adjMatrixGraph[dep][des] >= 1) && (this.adjMatrixGraph[des][dep] >= 1)){
      return true;
    }
    return false;
  }
  private void removeEdge(int dep, int des) {
    int numV = this.numVertices;
    if (dep >= numV || des >= numV) {
      System.out.print("Node doesn't Exist");
      System.out.println();
      return;
    }
    System.out.print("removing Edge");
    System.out.println();
    this.adjMatrixGraph[dep][des] = -1;
    this.adjMatrixGraph[des][dep] = -1;
    this.numEdges -= 1;
  }

  public void print(){
    for (int i = 0; i < adjMatrixGraph.length; i++) {
      for (int j = 0; j < adjMatrixGraph[0].length; j++) {
        System.out.print(adjMatrixGraph[i][j] + " ");
      }
      System.out.println();
    }
  }

  
  public static void main(String[] args) {
    System.out.println("Graph");
    GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(5);

    int vertices[] = { 0,1,2,3,4 };
    for (int i = 0; i < 5; i++) {
      graph.addNode(vertices[i]);
    };

    int[][] Edges = { {0,1,5}, {0,2,5}, {0,3,5}, {2,4,7}, {2,8,7} };
    for (int i = 0; i < Edges.length; i++){
      graph.addEdge(Edges[i][0], Edges[i][1], Edges[i][2]);
    }

    graph.print();
    graph.removeNode(4);
    graph.removeEdge(2,4);
    graph.print();
    System.out.println(graph.isEdge(0,1));
    System.out.println(graph.isEdge(2,8));
    graph.addNode(5);
    graph.addNode(7);
    graph.addEdge(5, 7, 7);
    graph.print();
    System.out.println(graph.contains(5));
    System.out.println(graph.contains(6));
  }
 
}
  