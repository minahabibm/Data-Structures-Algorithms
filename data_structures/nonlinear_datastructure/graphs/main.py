class Graph(object):
  #weighted undirected Graph
  def __init__(self, graph_dict=None):
    if graph_dict == None:
      graph_dict = {}
    self.__graph_dict = graph_dict
  
  def vertices(self):
    return list(self.__graph_dict.keys())

  def edges(self):
    return self.__generate_edges()
  
  def add_vertex(self, vertex):
    if vertex not in self.__graph_dict:
      self.__graph_dict[vertex] = []

  def add_edge(self, edge):
    edge = tuple(edge)
    vertex1 = edge[0]
    vertex2 = edge[1]
    weight = edge[2] if (len(edge) == 3) else 0
    
    #(vertex1, vertex2) = tuple(edge)
    if vertex1 in self.__graph_dict and vertex2 in self.__graph_dict:
      self.__graph_dict[vertex1].append({vertex2:weight})
      self.__graph_dict[vertex2].append({vertex1:weight})
    else:
      if vertex1 in self.__graph_dict and vertex2 not in self.__graph_dict:
        self.__graph_dict[vertex1].append({vertex2:weight})
        self.__graph_dict[vertex2] = [{vertex1:weight}]
      elif vertex2 in self.__graph_dict and vertex1 not in self.__graph_dict: 
        self.__graph_dict[vertex1] = [{vertex2:weight}]
        self.__graph_dict[vertex2].append({vertex1:weight})
      else:
        self.__graph_dict[vertex1] = [{vertex2:weight}]
        self.__graph_dict[vertex2]= [{vertex1:weight}]

  def contains(self, vertex):
    vertices = self.vertices()
    if vertex in vertices:
      print("Vertex " + str(vertex) +" exist")
      return True
    else:
      print("Vertex doesn't exist")
      return False

  def hasEdge(self, dep, des):
    vertices = self.vertices()
    if dep in vertices and des in vertices:
      for i in self.__graph_dict[dep]:
        tmp = list(i.keys())
        if tmp[0] == des:  
          print("Edge " + str(dep) + " to " + str(des) + " exist")
      return True
    else:
      print("Edge " + str(dep) + " to " + str(des) + " doesn't exist")
      return False
    print("Edge " + str(dep) + " to " + str(des) + " doesn't exist")
    return False

  def removeVertex(self,vertex):
    vertices = self.vertices()
    if vertex in vertices:

      for i in self.__graph_dict[vertex]:
        tmp = list(i)
        for j in range(0, len(self.__graph_dict[tmp[0]])):
          tmp0 = list(self.__graph_dict[tmp[0]][j])
          if vertex == tmp0[0]:
            self.__graph_dict[tmp[0]].pop(j)
            break
      self.__graph_dict.pop(vertex)

      print( "Vertex " + str(vertex) + " removed " )
    else:
      print("Vertex doesn't exist")
    
  def removeEdge(self, dep, des):
    vertices = self.vertices()
    if dep in vertices and des in vertices:
      for i in range(0, len(self.__graph_dict[dep])):
        tmp = list(self.__graph_dict[dep][i])
        if tmp[0] == des:
          self.__graph_dict[dep].pop(i)
      for i in range(0, len(self.__graph_dict[des])):
        tmp = list(self.__graph_dict[des][i])
        if tmp[0] == dep:
          self.__graph_dict[des].pop(i)
      print("Edge " + str(dep) + " to " + str(des) + " removed")
    else:
      print("Edge doesn't exist")


  def __generate_edges(self):
    edges = []
    for vertex in self.__graph_dict:
      for neighbour in self.__graph_dict[vertex]:
          if {neighbour, vertex} not in edges:
            edges.append({vertex, neighbour})
    return edges
  
  def __str__(self):
    #res = "vertices: "
    for k in self.__graph_dict:
      print(str(k) + " -> " + str(self.__graph_dict[k]))
      #res += str(k) + " "
    #res += "\nedges: "
    #for edge in self.__generate_edges():
     # res += str(edge) + " "
    #return res

if __name__=='__main__': 
  print("Hello World")
  graph = Graph()
  vertices = [ 0,1,2,3,4,0,1,7 ];
  edges = [ {0,1,5}, {0,2,5}, {0,3}, {2,4,7}, {0,6},{5,7,5}, {1,5,7} ]
  
  for i in range(0,len(vertices)):
    graph.add_vertex(vertices[i]);

  for i in range(0,len(edges)):
    graph.add_edge(edges[i]);
    
  graph.__str__()
  graph.contains(1)
  graph.hasEdge(0,1)
  graph.hasEdge(0,2)
  graph.hasEdge(0,3)
  graph.hasEdge(8,9)
  graph.removeEdge(0,6)
  graph.__str__()
  graph.removeVertex(0)
  graph.removeVertex(6)
  graph.removeVertex(11)
  graph.__str__()
  graph.contains(6)