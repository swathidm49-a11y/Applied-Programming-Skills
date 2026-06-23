class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int MOD = 1_000_000_007;
        int M = r - l + 1;
        long[][] dp = new long[M + 1][2];
        for (int y = 1; y <= M; y++) {
            dp[y][0] = M - y; // number of elements greater than y
            dp[y][1] = y - 1; // number of elements smaller than y
        }
        for (int len = 3; len <= n; len++) {
            long[][] nextDp = new long[M + 1][2];
            long[] prefDown = new long[M + 2];
            for (int y = 1; y <= M; y++) {
                prefDown[y] = (prefDown[y - 1] + dp[y][0]) % MOD;
            }
            long[] suffUp = new long[M + 2];
            for (int y = M; y >= 1; y--) {
                suffUp[y] = (suffUp[y + 1] + dp[y][1]) % MOD;
            }
            for (int x = 1; x <= M; x++) {
                nextDp[x][0] = suffUp[x + 1];
                nextDp[x][1] = prefDown[x - 1];
            }
            
            dp = nextDp;
        }
        long totalWays = 0;
        for (int x = 1; x <= M; x++) {
            totalWays = (totalWays + dp[x][0] + dp[x][1]) % MOD;
        }
        return (int) totalWays;
    }
}