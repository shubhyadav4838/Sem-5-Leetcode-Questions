// Last updated: 14/1/2026, 11:54:33 pm
1class Solution {
2    public int waysToReachTarget(int target, int[][] types) {
3        int n = types.length;
4        int MOD = 1_000_000_007;
5        
6        int[][] dp = new int[n + 1][target + 1];
7        
8        for (int i = 0; i <= n; i++) dp[i][0] = 1;
9
10        for (int i = 1; i <= n; i++) {
11            int count = types[i-1][0];
12            int marks = types[i-1][1];
13
14            for (int j = 0; j <= target; j++) {
15                
16                dp[i][j] = dp[i-1][j];
17                
18                for (int k = 1; k <= count; k++) {
19                    int cost = k * marks;
20                    
21                    if (j >= cost) {
22                        dp[i][j] = (dp[i][j] + dp[i-1][j - cost]) % MOD;
23                    } else {
24                        break; 
25                    }
26                }
27            }
28        }
29        
30        return dp[n][target];
31    }
32}