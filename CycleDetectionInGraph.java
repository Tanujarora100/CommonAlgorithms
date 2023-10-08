package Graph.cycledetection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cycledetectiondfs {
    public boolean isCycle(int V, List<List<Integer>> adj) {
        Map<Integer, Boolean> vis = new HashMap<>();
        for (int i = 0; i < V; i++) {
            vis.put(i, false);
        }

        for (int i = 0; i < V; i++) {
            if (Boolean.FALSE.equals(vis.get(i))) {
                if (dfs(adj, vis, i, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(List<List<Integer>> adj, Map<Integer, Boolean> vis, int start, int parent) {
        vis.put(start, true);
        for (int node : adj.get(start)) {
            if (Boolean.FALSE.equals(vis.get(node))) {
                if (dfs(adj, vis, node, start)) {
                    return true;
                }
            } else if (node != parent) {
                return true;
            }
        }
        return false;
    }
}
