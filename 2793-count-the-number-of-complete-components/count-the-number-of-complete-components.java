import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Step 1: Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponentsCount = 0;

        // Step 2: Iterate through all nodes to find components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] counts = new int[2]; // counts[0] = vertex count, counts[1] = total degree count
                dfs(i, adj, visited, counts);
                
                int v = counts[0];
                int totalEdgesInComponent = counts[1];

                // A component is complete if the total degrees equal V * (V - 1)
                if (totalEdgesInComponent == v * (v - 1)) {
                    completeComponentsCount++;
                }
            }
        }

        return completeComponentsCount;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, int[] counts) {
        visited[node] = true;
        counts[0]++; // Increment vertex count
        counts[1] += adj.get(node).size(); // Add the degree of this node

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, counts);
            }
        }
    }
}