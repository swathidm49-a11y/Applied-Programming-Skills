import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // Step 1: Sort the array to process elements greedily
        Arrays.sort(arr);
        
        // Step 2: The first element must be 1
        arr[0] = 1;
        
        // Step 3: Enforce the adjacent difference constraint
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        
        // Step 4: The last element will be the maximum achievable value
        return arr[arr.length - 1];
    }
}