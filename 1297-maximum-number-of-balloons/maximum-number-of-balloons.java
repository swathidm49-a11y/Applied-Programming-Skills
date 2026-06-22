class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[26];
        
        // Count frequencies of all characters
        for (char c : text.toCharArray()) {
            counts[c - 'a']++;
        }
        
        // Find the limiting character count
        int b = counts['b' - 'a'];
        int a = counts['a' - 'a'];
        int l = counts['l' - 'a'] / 2; // Requires 2 per word
        int o = counts['o' - 'a'] / 2; // Requires 2 per word
        int n = counts['n' - 'a'];
        
        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}