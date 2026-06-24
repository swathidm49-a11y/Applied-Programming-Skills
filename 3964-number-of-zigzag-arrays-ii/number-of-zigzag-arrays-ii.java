class Solution {
    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        if (n == 1) return m;
        
        int size = 2 * m;
        long[][] T = new long[size][size];
        
        // Build transition matrix
        // State indices 0 to m-1: up states
        // State indices m to 2m-1: down states
        for (int x = 0; x < m; x++) {
            // up[x] comes from down[k] where k < x
            for (int k = 0; k < x; k++) {
                T[x][m + k] = 1;
            }
            // down[x] comes from up[k] where k > x
            for (int k = x + 1; k < m; k++) {
                T[m + x][k] = 1;
            }
        }
        
        // Fast matrix exponentiation: T^(n-1)
        long[][] Tn = power(T, n - 1, size);
        
        // Initial states for length 1: all configurations are 1
        long[] initial = new long[size];
        for (int i = 0; i < size; i++) {
            initial[i] = 1;
        }
        
        // Multiply Tn by initial vector and sum results
        long totalWays = 0;
        for (int i = 0; i < size; i++) {
            long ways = 0;
            for (int j = 0; j < size; j++) {
                ways = (ways + Tn[i][j] * initial[j]) % MOD;
            }
            totalWays = (totalWays + ways) % MOD;
        }
        
        return (int) totalWays;
    }

    private long[][] power(long[][] A, int p, int size) {
        long[][] res = new long[size][size];
        for (int i = 0; i < size; i++) res[i][i] = 1;
        
        long[][] base = A;
        while (p > 0) {
            if ((p & 1) == 1) res = multiply(res, base, size);
            base = multiply(base, base, size);
            p >>= 1;
        }
        return res;
    }

    private long[][] multiply(long[][] A, long[][] B, int size) {
        long[][] C = new long[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < size; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }
}