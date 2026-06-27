import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put((long) num, countMap.getOrDefault((long) num, 0) + 1);
        }

        int maxLen = 0;

        // Handle the special case for 1
        if (countMap.containsKey(1L)) {
            int countOne = countMap.get(1L);
            // If count is even, we can only take an odd subset size: countOne - 1
            if (countOne % 2 == 0) {
                maxLen = countOne - 1;
            } else {
                maxLen = countOne;
            }
        }

        // Check for patterns starting with x > 1
        for (long x : countMap.keySet()) {
            if (x == 1) continue;

            int currentLen = 0;
            long current = x;

            // Keep climbing the power chain as long as we have at least 2 elements
            while (countMap.getOrDefault(current, 0) >= 2) {
                currentLen += 2;
                current = current * current;
            }

            // If the peak element exists at least once, it completes the peak structure
            if (countMap.getOrDefault(current, 0) >= 1) {
                currentLen += 1;
            } else {
                // If it doesn't exist, the last element we counted 2 of must act as the peak
                currentLen -= 1;
            }

            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }
}