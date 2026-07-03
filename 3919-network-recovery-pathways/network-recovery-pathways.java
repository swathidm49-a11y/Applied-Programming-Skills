import java.util.*;

public class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        int low = 0;
        int high = 1000000000;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(n, adj, online, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int n, List<int[]>[] adj, boolean[] online, long k, int minEdgeCost) {
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        return dfs(0, n, adj, online, minEdgeCost, dp) <= k;
    }

    private long dfs(int node, int n, List<int[]>[] adj, boolean[] online, int minEdgeCost, long[] dp) {
        if (node == n - 1) {
            return 0;
        }
        if (dp[node] != -1) {
            return dp[node];
        }

        long minCost = Long.MAX_VALUE / 2;

        for (int[] edge : adj[node]) {
            int nextNode = edge[0];
            int cost = edge[1];

            if (cost >= minEdgeCost && (nextNode == n - 1 || online[nextNode])) {
                long restCost = dfs(nextNode, n, adj, online, minEdgeCost, dp);
                if (restCost < Long.MAX_VALUE / 2) {
                    minCost = Math.min(minCost, cost + restCost);
                }
            }
        }

        return dp[node] = minCost;
    }
}