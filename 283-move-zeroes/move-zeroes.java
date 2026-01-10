class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0; // next non-zero position

        // Step 1: Move all non-zero elements to front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        // Step 2: Fill remaining positions with zero
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}
