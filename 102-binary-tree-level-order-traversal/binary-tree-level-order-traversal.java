import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode r) {
        List<List<Integer>> a = new ArrayList<>();
        if (r == null) return a;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(r);

        while (!q.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            for (int i = q.size(); i > 0; i--) {
                TreeNode n = q.poll();
                l.add(n.val);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            a.add(l);
        }
        return a;
    }
}
