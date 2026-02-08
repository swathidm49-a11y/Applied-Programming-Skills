class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] f = new int[26];
        for (char c : tasks) f[c - 'A']++;

        int max = 0, cnt = 0;
        for (int x : f) max = Math.max(max, x);
        for (int x : f) if (x == max) cnt++;

        return Math.max(tasks.length, (max - 1) * (n + 1) + cnt);
    }
}
