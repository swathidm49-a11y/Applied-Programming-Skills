class Solution {
    public int[] asteroidCollision(int[] a) {
        int n = a.length, k = 0;
        for (int x : a) {
            while (k > 0 && a[k - 1] > 0 && x < 0 && a[k - 1] < -x) k--;
            if (k == 0 || x > 0 || a[k - 1] < 0) a[k++] = x;
            else if (a[k - 1] == -x) k--;
        }
        return java.util.Arrays.copyOf(a, k);
    }
}
