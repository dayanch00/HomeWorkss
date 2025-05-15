package Хеширование;

class Solution {
    public int findSubstringInWraproundString(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[26];
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            int currentCharIndex = s.charAt(i) - 'a';
            int currentLength = 1;

            if (i > 0) {
                int prevCharIndex = s.charAt(i - 1) - 'a';
                if ((currentCharIndex - prevCharIndex == 1) || (prevCharIndex - currentCharIndex == 25)) {
                    currentLength = dp[prevCharIndex] + 1;
                }
            }

            dp[currentCharIndex] = Math.max(dp[currentCharIndex], currentLength);

            maxLength = Math.max(maxLength, currentLength);
        }

        int totalUniqueSubstrings = 0;
        for (int length : dp) {
            totalUniqueSubstrings += length;
        }

        return totalUniqueSubstrings;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}
