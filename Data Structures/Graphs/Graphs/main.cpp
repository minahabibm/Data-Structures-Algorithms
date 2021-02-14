//Adjacent List
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;  

struct Node {
  int id;
  vector<pair< int, int >> adj;
  Node(int i){
    this->id = i ;
  }
  void setNode(int des,int weight) {
    adj.push_back({des,weight});
  }

};

class Graph{
  unordered_map< int, Node > adjGraph;
  public: 
    Graph() {
    } 
    void addNode(int i);
    void addEdge(int dep, int des, int weight); 
    void removeNode(int vertex);
    void removeEdge(int dep, int des); 
    bool contains(int vertex);
    bool hasEdge(int dep, int des);

    void print();
}; 

void Graph::addNode(int v) {
  unordered_map<int, Node> ::iterator it;
  it = adjGraph.find(v);
  if (it != adjGraph.end()) {
    cout << "Vertex already exist"<< endl;
    return;
  } else {
    Node tmp = Node(v);
    adjGraph.insert({v, tmp});
  }
}
void Graph::addEdge(int dep,int des, int weight = 0) {
  //undirectional, weighted
  unordered_map<int, Node >::iterator i, q;
  i = adjGraph.find(dep);
  q = adjGraph.find(des);
  if (i == adjGraph.end()) {
    cout << "Vertex Doesn't exist"<< endl;
    return;
  }
  if (q == adjGraph.end()) {
    cout << "Vertex Doesn't exist"<< endl;
    return;
  }
  i->second.setNode(des, weight);
  q->second.setNode(dep, weight);
}
void Graph::removeNode(int vertex) {
  unordered_map<int, Node >::iterator i, q;
  i = adjGraph.find(vertex);
  if (i != adjGraph.end()) {
    int x = i->second.adj.size();
    while (x >= 0){
      removeEdge(vertex, i->second.adj[x].first);
      x --;
    }
    adjGraph.erase(vertex);
    cout << "Vertex "<< vertex << " removed " << endl;
  } else {
    cout << "Vertex doesn't exist"<< endl;
  }

}
void Graph::removeEdge(int dep, int des) {
  unordered_map<int, Node >::iterator i, q;
  i = adjGraph.find(dep);
  q = adjGraph.find(des);
  if (hasEdge(dep, des)){
    for(int x=0; x< i->second.adj.size(); ++x) {
      if (i->second.adj[x].first == des){
        i->second.adj.erase(i->second.adj.begin() + x); 
      }
    }
    for(int x=0; x< q->second.adj.size(); ++x) {
      if (q->second.adj[x].first == dep){
        q->second.adj.erase(q->second.adj.begin() + x); 
      }
    }
    cout << "Edge "<< dep << " to " << des << " removed"<< endl;
    return;
  }

}
bool Graph:: contains(int vertex){
  unordered_map<int, Node> ::iterator it;
  it = adjGraph.find(vertex);
  if (it != adjGraph.end()) {
    cout << "Vertex "<< vertex <<" exist"<< endl;
    return true;
  }
  cout << "Vertex doesn't exist"<< endl;
  return false;
}
bool Graph::hasEdge(int dep, int des) { 
  unordered_map<int, Node >::iterator i, q;
  i = adjGraph.find(dep);
  q = adjGraph.find(des);
  if(i != adjGraph.end() && q != adjGraph.end()){
    bool fli, flq = false;
    for(int x=0; x< i->second.adj.size(); ++x) {
      if (i->second.adj[x].first == des){
        fli = true;
        break;
      }
    }
    for(int x=0; x< q->second.adj.size(); ++x) {
      if (q->second.adj[x].first == dep){
        flq = true;
        break;
      }
    }

    if (fli && flq){
      cout << "Edge "<< dep << " to " << des << " exist"<< endl;
      return true;
    }    
  }
  cout << "Edge "<< dep << " to " << des << " doesn't exist"<< endl;
  return false;
}

void Graph::print() { 
  unordered_map<int, Node>::iterator it;
  for (auto it: adjGraph) {
    cout << it.first<<" -> ";
    for(int i=0; i<it.second.adj.size(); ++i) {
      std::cout << "{"<< it.second.adj[i].first << ":" <<it.second.adj[i].second << "}, " ;
    }
    cout << endl;
  }
}



int main() {
  cout << "Hello World!\n";

  Graph graph;
  int vertices [12] = { 0,1,2,3,4,0,1 };
  for (int i = 0; i < 7; i++){
    graph.addNode(vertices[i]);
  }

  int Edges[10][3] = { {0,1,5}, {0,2,5}, {0,3}, {2,4,7} };
  for (int i = 0; i < 4; i++){
    graph.addEdge(Edges[i][0], Edges[i][1], Edges[i][2]);
  }

  graph.print();
  graph.contains(1);
  graph.hasEdge(0,1);
  graph.hasEdge(0,2);
  graph.hasEdge(0,3);
  graph.hasEdge(8,9);
  graph.removeEdge(2,4);
  graph.print();
  graph.removeNode(0);
  graph.removeNode(11);
  graph.print();
  graph.contains(0);

  return 0; 
}
