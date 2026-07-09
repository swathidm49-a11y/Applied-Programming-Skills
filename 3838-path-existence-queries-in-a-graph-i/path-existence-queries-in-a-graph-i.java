class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component = new int[n];
        int compId = 0;
        component[0] = compId;
        
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                compId++;
            }
            component[i] = compId;
        }
        
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = (component[queries[i][0]] == component[queries[i][1]]);
        }
        
        return answer;
    }
}