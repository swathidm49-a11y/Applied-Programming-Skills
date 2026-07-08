 class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        long MOD = 1_000_000_007;

        int[] nzCount = new int[m + 1];
        long[] digitSum = new long[m + 1];
        long[] prefixVal = new long[m + 1];
        long[] pow10 = new long[m + 1];

        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            int digit = c - '0';

            nzCount[i + 1] = nzCount[i];
            digitSum[i + 1] = digitSum[i];
            prefixVal[i + 1] = prefixVal[i];

            if (digit != 0) {
                nzCount[i + 1]++;
                digitSum[i + 1] += digit;
                prefixVal[i + 1] = (prefixVal[i] * 10 + digit) % MOD;
            }
        }

        int[] firstNz = new int[m];
        int last = m;
        for (int i = m - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                last = i;
            }
            firstNz[i] = last;
        }

        int[] lastNz = new int[m];
        last = -1;
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != '0') {
                last = i;
            }
            lastNz[i] = last;
        }

        int n = queries.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int actualL = firstNz[l];
            int actualR = lastNz[r];

            if (actualL > actualR) {
                answer[i] = 0;
                continue;
            }

            long sum = digitSum[actualR + 1] - digitSum[actualL];
            int countR = nzCount[actualR + 1];
            int countL = nzCount[actualL];
            int len = countR - countL;

            long x = (prefixVal[actualR + 1] - (prefixVal[actualL] * pow10[len]) % MOD + MOD) % MOD;
            long queryAns = (x * (sum % MOD)) % MOD;
            answer[i] = (int) queryAns;
        }

        return answer;
    }
}