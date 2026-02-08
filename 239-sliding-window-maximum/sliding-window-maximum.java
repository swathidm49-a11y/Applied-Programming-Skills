import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length, idx = 0;
        int[] r = new int[n - k + 1];
        Deque<Integer> d = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!d.isEmpty() && d.peek() == i - k) d.poll();
            while (!d.isEmpty() && a[d.peekLast()] < a[i]) d.pollLast();
            d.offer(i);
            if (i >= k - 1) r[idx++] = a[d.peek()];
        }
        return r;
    }
}
