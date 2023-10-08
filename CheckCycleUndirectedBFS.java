package Graph.cycledetection;

import java.util.*;

public class CheckcycleundirectedBFS {
    public static String detectCycle(int nodes, ArrayList<ArrayList<Integer>> edges) {
        List<List<Integer>> adjList = getAdjacencyList(edges, nodes);
        int sourceVertex = 1;
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> parentMap = new HashMap<>();
        q.offer(sourceVertex);
        parentMap.put(sourceVertex, -1);
        while (!q.isEmpty()) {
            int currVertex = q.poll();
            for (int neighbour : adjList.get(currVertex)) {
                if (parentMap.get(currVertex) == neighbour)
                    continue;
                else if (parentMap.containsKey(neighbour))
                    return "Yes";
                else {
                    parentMap.put(neighbour, currVertex);
                }
            }
        }
        return "No";
    }

    public static List<List<Integer>> getAdjacencyList(ArrayList<ArrayList<Integer>> edges, int n) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());
        for (ArrayList<Integer> edge : edges) {
            int source = edge.get(0);
            int destination = edge.get(1);
            adjList.get(source).add(destination);
            adjList.get(destination).add(source);
        }
        return adjList;
    }

    public boolean isCycle(int V, List<List<Integer>> adj) {
        Map<Integer, Integer> visited = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (!visited.containsKey(i)) {
                if (bfs(visited, i, queue, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean bfs(Map<Integer, Integer> visited, int start, Queue<Integer> queue, List<List<Integer>> adj) {
        queue.offer(start);
        visited.put(start, -1);
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            for (int neighbor : adj.get(currNode)) {
                if (!visited.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    visited.put(neighbor, currNode);
                } else if (visited.get(currNode) != neighbor) {
                    return true;
                }
            }
        }
        return false;
    }
}
