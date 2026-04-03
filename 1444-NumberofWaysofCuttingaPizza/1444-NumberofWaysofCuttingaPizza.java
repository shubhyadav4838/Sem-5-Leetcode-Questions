// Last updated: 4/4/2026, 12:02:42 am
1import java.util.*;
2
3class Solution {
4    int MOD = 1000000007;
5
6    public int ways(String[] pizza, int k) {
7        int rows = pizza.length;
8        int cols = pizza[0].length();
9        
10        int[][] apples = new int[rows + 1][cols + 1];
11        
12        for (int r = rows - 1; r >= 0; r--) {
13            for (int c = cols - 1; c >= 0; c--) {
14                apples[r][c] = (pizza[r].charAt(c) == 'A' ? 1 : 0) 
15                             + apples[r + 1][c] 
16                             + apples[r][c + 1] 
17                             - apples[r + 1][c + 1];
18            }
19        }
20        
21        Integer[][][] dp = new Integer[rows][cols][k];
22        
23        return solve(0, 0, k - 1, rows, cols, apples, dp);
24    }
25
26    private int solve(int r, int c, int k, int rows, int cols, int[][] apples, Integer[][][] dp) {
27        if (apples[r][c] == 0) {
28            return 0;
29        }
30        
31        if (k == 0) {
32            return 1;
33        }
34        
35        if (dp[r][c][k] != null) {
36            return dp[r][c][k];
37        }
38        
39        int ans = 0;
40        
41        for (int i = r + 1; i < rows; i++) {
42            if (apples[r][c] - apples[i][c] > 0) {
43                ans = (ans + solve(i, c, k - 1, rows, cols, apples, dp)) % MOD;
44            }
45        }
46        
47        for (int j = c + 1; j < cols; j++) {
48           
49            if (apples[r][c] - apples[r][j] > 0) {
50                ans = (ans + solve(r, j, k - 1, rows, cols, apples, dp)) % MOD;
51            }
52        }
53        
54        return dp[r][c][k] = ans;
55    }
56}