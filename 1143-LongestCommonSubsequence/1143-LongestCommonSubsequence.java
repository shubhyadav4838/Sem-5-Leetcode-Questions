// Last updated: 17/1/2026, 3:38:39 pm
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        return lps(s, 0, n - 1, dp);
    }

    int lps(String s, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        } else if (i > j) {
            return 0;
        } else if (i == j) {
            return 1;
        }

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = lps(s, i + 1, j - 1, dp) + 2;
        } else {
            dp[i][j] = Math.max(lps(s, i + 1, j, dp), lps(s, i, j - 1, dp));
        }

        return dp[i][j];
    }


}