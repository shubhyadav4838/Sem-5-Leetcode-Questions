// Last updated: 3/8/2025, 11:57:51 pm
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] counts = new int[m+1][n+1];
        counts[0][0] = 1;
        for (String s : strs) {
            int zeros = 0;
            for (char c : s.toCharArray()) if (c == '0') ++zeros;
            int ones = s.length() - zeros;

            for (int i = m; i >= zeros; --i) {
                for (int j = n; j >= ones; --j) {
                    if (counts[i-zeros][j-ones] > 0) {
                        counts[i][j] = Math.max(counts[i][j], counts[i-zeros][j-ones] + 1);
                    }
                }
            }
        }
        int max = 1;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) max = Math.max(max, counts[i][j]);
        }
        return max - 1;
    }
}