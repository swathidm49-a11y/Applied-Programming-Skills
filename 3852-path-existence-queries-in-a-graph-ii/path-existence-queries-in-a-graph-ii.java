import java.util.Arrays;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // 1. Pair each node with its original index and sort by value
        int[][] nodes = new int[n][2];
        for (int i = 0; i < n; i++) {
            nodes[i][0] = nums[i];
            nodes[i][1] = i;
        }
        Arrays.sort(nodes, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Map original index to its sorted position
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[nodes[i][1]] = i;
        }
        
        // 2. Compute greedy jumps to the right (furthest reachable node within maxDiff)
        // up[i][j] stores the 2^j-th ancestor/jump from sorted index i
        int LOG = 18; // 2^17 = 131072 > 10^5
        int[][] up = new int[n][LOG];
        
        int right = 0;
        for (int i = 0; i < n; i++) {
            while (right < n && nodes[right][0] - nodes[i][0] <= maxDiff) {
                right++;
            }
            // right - 1 is the furthest reachable node from i moving right
            up[i][0] = right - 1;
        }
        
        // Fill the sparse table for binary lifting
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }
        
        // 3. Process queries
        int[] answer = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int u = queries[q][0];
            int v = queries[q][1];
            
            if (u == v) {
                answer[q] = 0;
                continue;
            }
            
            // Get their positions in the sorted array
            int p1 = pos[u];
            int p2 = pos[v];
            
            // Ensure p1 is always to the left of p2
            if (p1 > p2) {
                int temp = p1;
                p1 = p2;
                p2 = temp;
            }
            
            // Count the minimum number of greedy jumps from p1 to reach or cross p2
            int steps = 0;
            for (int j = LOG - 1; j >= 0; j--) {
                if (up[p1][j] < p2) {
                    steps += (1 << j);
                    p1 = up[p1][j];
                }
            }
            
            // Take one final jump to see if we can reach or cross p2
            steps++;
            p1 = up[p1][0];
            
            if (p1 >= p2) {
                answer[q] = steps;
            } else {
                answer[q] = -1; // Unable to reach
            }
        }
        
        return answer;
    }
}