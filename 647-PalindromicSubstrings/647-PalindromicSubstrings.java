// Last updated: 30/12/2025, 1:21:20 am
1class Solution {
2    public int countSubstrings(String s) {
3        int n = s.length();
4        boolean[][] dp = new boolean[n][n];
5        int count = 0;
6        for (int i = n - 1; i >= 0; i--) {
7            for (int j = i; j < n; j++) {
8                
9                if (s.charAt(i) == s.charAt(j)) {
10                    
11                    if ((j - i < 2) || dp[i+1][j-1]) {
12                        dp[i][j] = true;
13                        count++;
14                    }
15                }
16            }
17        }
18        
19        return count;
20    }
21}