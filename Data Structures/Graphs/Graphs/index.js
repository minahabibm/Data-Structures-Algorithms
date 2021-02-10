class  Graph{
  constructor(){
    this.graph_dict = new Map()
  }
  addVertex(vertex){
    this.graph_dict.set(vertex,[])
  }
  addEdge(edge){
    var source = edge[0];
    var destination = edge[1];
    var weight = edge.length == 3 ? edge[2] : 0

    if (typeof this.graph_dict.get(source) === 'undefined'){
      this.addVertex(source)
    }
    if (typeof this.graph_dict.get(destination) === 'undefined'){
      this.addVertex(destination);
    }

    this.graph_dict.get(source).push({
      key: destination,
      value: weight 
    });
    this.graph_dict.get(destination).push({
      key: source,
      value: weight 
    });
  }
  hasVertex(vertex){
    if (typeof this.graph_dict.get(vertex) === 'undefined'){
      return false;
    }else{
      return true;
    }
  }
  hasEdge(sou,des){
    if (this.hasVertex(sou) && this.hasVertex(des)){
      var souArr = this.graph_dict.get(sou);
      var desArr = this.graph_dict.get(des);
      var souF = false;
      var desF = false;
      for(var i = 0; i < souArr.length; i++ ){
        if (souArr[i].key === des){
          souF = true
        }
      }
      for(var i = 0; i < desArr.length; i++ ){
        if (desArr[i].key === sou){
          desF = true
        }
      }
      if (souF && desF ){
        return true
      }else{
        return false
      }
    }else{
      return false
    }
  }
  removeVertex(vertex){
    if (this.hasVertex(vertex)){
      var verArr = this.graph_dict.get(vertex);
      while (verArr.length !== 0){
        this.removeEdge(vertex,verArr[0].key);
      }
      this.graph_dict.delete(vertex);
      return true;
    }else{
      return false;
    }
  }
  removeEdge(sou,des){
    if (this.hasEdge(sou,des)) {
      var souArr = this.graph_dict.get(sou);
      var desArr = this.graph_dict.get(des);
      for(var i = 0; i < souArr.length; i++ ){
        if (souArr[i].key === des){
          this.graph_dict.get(sou).splice(i,1);
        }
      }
      for(var i = 0; i < desArr.length; i++ ){
        if (desArr[i].key === sou){
          this.graph_dict.get(des).splice(i,1);
        }
      }
      return true;

    }else{
      return false;
    }
  }

  display(){
    for (let [node, adjacencyList] of this.graph_dict) {
      console.log(`${node} =>`);
      console.log(adjacencyList);
      console.log(" ")
    }
  }
  
}

let graph = new Graph();
let vertices = ["A", "B", "C", "D"]
let edges = [ ["A","B",5], ["A","C",5], ["A","D"], ["C","E",7], ["A","G"],["F","H",5], ["B","F",7] ]

for (var i = 0; i < vertices.length; i++){
  graph.addVertex(vertices[i])
}

for (var i = 0; i < edges.length; i++){
  graph.addEdge(edges[i]);
}

graph.display();
console.log(graph.hasVertex("A"));
console.log(graph.hasEdge("A","B"));
console.log(graph.hasEdge("A","C"));
console.log(graph.hasEdge("A","D"));
console.log(graph.hasEdge("J","K"));
console.log(graph.removeEdge("F","H"));
graph.display();
console.log(graph.removeVertex("F"));
console.log(graph.removeVertex("G"));
console.log(graph.removeVertex("E"));
console.log(graph.hasVertex("A"));
graph.display();



  
