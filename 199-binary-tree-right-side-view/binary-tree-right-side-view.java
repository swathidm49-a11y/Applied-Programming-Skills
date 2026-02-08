import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode r) {
        List<Integer> a = new ArrayList<>();
        if (r == null) return a;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(r);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode t = q.poll();
                if (i == n - 1) a.add(t.val);
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
            }
        }
        return a;
    }
}
