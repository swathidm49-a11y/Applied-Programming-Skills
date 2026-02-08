import java.util.*;

class Solution {
    public int longestSubarray(int[] a, int limit) {
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();
        int l = 0, ans = 0;

        for (int r = 0; r < a.length; r++) {
            while (!max.isEmpty() && a[max.peekLast()] < a[r]) max.pollLast();
            while (!min.isEmpty() && a[min.peekLast()] > a[r]) min.pollLast();

            max.offer(r);
            min.offer(r);

            while (a[max.peek()] - a[min.peek()] > limit) {
                if (max.peek() == l) max.poll();
                if (min.peek() == l) min.poll();
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
