import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] p, int[] q) {
        Stack<Integer> s = new Stack<>();
        int j = 0;
        for (int x : p) {
            s.push(x);
            while (!s.isEmpty() && j < q.length && s.peek() == q[j]) {
                s.pop();
                j++;
            }
        }
        return j == q.length;
    }
}
