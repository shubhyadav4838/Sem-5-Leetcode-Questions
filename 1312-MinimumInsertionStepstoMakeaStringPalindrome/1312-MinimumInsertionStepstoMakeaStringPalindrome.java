// Last updated: 19/1/2026, 1:15:24 am
1class Solution {
2    public int minDistance(String word1, String word2) {
3        int m = word1.length();
4        int n = word2.length();
5        
6        int[][] dp = new int[m + 1][n + 1];
7
8        for (int j = 0; j <= n; j++) {
9            dp[0][j] = j;
10        }
11
12        for (int i = 0; i <= m; i++) {
13            dp[i][0] = i;
14        }
15
16        for (int i = 1; i <= m; i++) {
17            for (int j = 1; j <= n; j++) {
18
19                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
20                    dp[i][j] = dp[i - 1][j - 1];
21                } else {
22                    
23                    int replace = dp[i - 1][j - 1]; 
24                    int delete  = dp[i - 1][j];    
25                    int insert  = dp[i][j - 1];     
26                    
27                    dp[i][j] = 1 + Math.min(replace, Math.min(delete, insert));
28                }
29            }
30        }
31        
32        return dp[m][n];
33    }
34}