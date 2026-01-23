// Last updated: 24/1/2026, 12:18:47 am
1class Solution {
2    public int calculateMinimumHP(int[][] arr) {
3        int m = arr.length;
4        int n = arr[0].length;
5        
6        int[][] dp = new int[m + 1][n + 1];
7        
8        for (int[] row : dp) {
9            Arrays.fill(row, Integer.MAX_VALUE);
10        }
11        
12        dp[m][n - 1] = 1;
13        dp[m - 1][n] = 1;
14        
15        for (int i = m - 1; i >= 0; i--) {
16            for (int j = n - 1; j >= 0; j--) {
17
18                int minFutureHealth = Math.min(dp[i + 1][j], dp[i][j + 1]);
19                int needed = minFutureHealth - arr[i][j];
20                
21                dp[i][j] = Math.max(1, needed);
22            }
23        }
24        
25        return dp[0][0];
26    }
27}