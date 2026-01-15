// Last updated: 16/1/2026, 2:14:34 am
1class Solution {
2    public int findMaxForm(String[] strs, int m, int n) {
3        int[][] dp = new int[m + 1][n + 1];
4
5        for (String s : strs) {
6            
7            int zeros = 0;
8            int ones = 0;
9            for (char c : s.toCharArray()) {
10                if (c == '0') zeros++;
11                else ones++;
12            }
13            for (int i = m; i >= zeros; i--) {
14                for (int j = n; j >= ones; j--) {
15                    
16                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeros][j - ones]);
17                }
18            }
19        }
20
21        return dp[m][n];
22    }
23}