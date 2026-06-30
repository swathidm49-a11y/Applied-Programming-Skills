class Solution {
    public int numberOfSubstrings(String s) {
        int[] counts = new int[3];
        int left = 0;
        int totalSubstrings = 0;
        int n = s.length();

        for (int right = 0; right < n; right++) {
            counts[s.charAt(right) - 'a']++;

            while (counts[0] > 0 && counts[1] > 0 && counts[2] > 0) {
                counts[s.charAt(left) - 'a']--;
                left++;
            }
            
            totalSubstrings += left;
        }

        return totalSubstrings;
    }
}