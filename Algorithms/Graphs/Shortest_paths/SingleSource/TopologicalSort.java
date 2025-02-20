package Algorithms.Graphs.Shortest_paths;
/** Topological Sorting
*
* @SEE https://www.geeksforgeeks.org/topological-sorting/
*
* Helps in scheduling tasks or events based on dependencies, Detects cycles in a directed graph, and Efficient for solving problems with precedence constraints.
* Only applicable to directed acyclic graphs (DAGs), not suitable for cyclic graphs. and May not be unique, multiple valid topological orderings can exist.
*
* Time Complexity: O(V+E)
* Space Complexity: O(V)
*/

import java.util.*;

public class TopologicalSort {

    // DFS Approach is useful when exploring dependencies dynamically.
    public void dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    dfs(neighbor, graph, visited, stack);
                }
            }
        }
        // Push the current node to the stack after visiting all its neighbors
        stack.push(node);
    }
    public List<Integer> TopologicalSort_DFS(int[][] edges, int vertices) {
        // Find the number of vertices dynamically or pass it as a parameter
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];
        Map<Integer, List<Integer>> adj = new HashMap<>();

        // Create adjacency list
        for(int[] edge: edges) {
            adj.putIfAbsent(edge[0], new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
        }
        
        // Perform DFS for each unvisited node
        for(int i = 0; i < vertices; i++) {
            if(!visited[i]) 
                dfs(i, adj, visited, stack);
        }

        // Extract topological order from stack
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    // Kahn’s Algorithm is better when dependencies are known upfront.
    public List<Integer> TopologicalSort_BFS(int[][] edges, int vertices) {
        // Find the number of vertices dynamically or pass it as a parameter
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[vertices];
        
        // Create adjacency list and in-degree array
        for(int i = 0; i < vertices; i++)
            adj.add(new ArrayList<>());
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        // Initialize queue with nodes having in-degree 0
        for(int i = 0; i < vertices; i++) {
            if(inDegree[i] == 0) 
                queue.offer(i);
        }

        // Process nodes with in-degree 0
        while(!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for(int neighbor: adj.get(node)) {
                if(--inDegree[neighbor] == 0) 
                    queue.offer(neighbor);
            }
        }

        return result.size() == vertices ? result : new ArrayList<>();
    }

    public static void main(String[] args) {


        int[][] edges = {
            {5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}
        };

        System.out.println("Graph:");
        System.out.println("   5 -> 2 -> 3");      
        System.out.println("             |");
        System.out.println("             v");
        System.out.println("   0 <- 4 -> 1");
        
        TopologicalSort ts = new TopologicalSort();

        List<Integer> result = ts.TopologicalSort_DFS(edges, 6);
        System.out.println("Topological Sort: " + result);
        
        result = ts.TopologicalSort_BFS(edges, 6);
        System.out.println("Topological Sort: " + result);
    }
    
}

