class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int prefixSum = 0;

        for (int i = 0; i < n; i++) {
            int leftSum = nums[i] * i - prefixSum;
            int rightSum = (totalSum - prefixSum - nums[i]) 
                           - nums[i] * (n - i - 1);

            result[i] = leftSum + rightSum;
            prefixSum += nums[i];
        }

        return result;
    }
}
