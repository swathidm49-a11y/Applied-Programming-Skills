import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> list = new ArrayList<>();
        dfs(root, 0, 0, list);
        list.sort((a,b) -> a[1]!=b[1]?a[1]-b[1]:a[0]!=b[0]?a[0]-b[0]:a[2]-b[2]);
        
        List<List<Integer>> res = new ArrayList<>();
        int col = Integer.MIN_VALUE;
        for (int[] n : list) {
            if (n[1] != col) {
                res.add(new ArrayList<>());
                col = n[1];
            }
            res.get(res.size()-1).add(n[2]);
        }
        return res;
    }
    
    void dfs(TreeNode r, int row, int col, List<int[]> l) {
        if (r == null) return;
        l.add(new int[]{row, col, r.val});
        dfs(r.left, row+1, col-1, l);
        dfs(r.right, row+1, col+1, l);
    }
}
