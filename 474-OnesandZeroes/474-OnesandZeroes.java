// Last updated: 15/1/2026, 11:09:44 pm
1class Solution {
2    static Integer[][][] dp;
3    static int[][] counts;
4
5    public static int findMaxForm(String[] strs, int m, int n) {
6        dp = new Integer[strs.length][m + 1][n + 1];
7        
8        counts = new int[strs.length][2];
9        for(int i=0; i<strs.length; i++) {
10            counts[i] = count(strs[i]);
11        }
12        
13        return solve(strs, m, n, 0);
14    }
15    
16    public static int solve(String[] arr, int m, int n, int idx) {
17        if(idx == arr.length) {
18            return 0;
19        }
20        
21        if(dp[idx][m][n] != null) {
22            return dp[idx][m][n];
23        }
24        
25        int zeros = counts[idx][0];
26        int ones = counts[idx][1];
27        
28        int exc = solve(arr, m, n, idx + 1);
29        
30        int inc = -1; 
31        if(m - zeros >= 0 && n - ones >= 0) {
32            inc = 1 + solve(arr, m - zeros, n - ones, idx + 1);
33        }
34        
35        return dp[idx][m][n] = Math.max(exc, inc);
36    }
37    
38    public static int[] count(String s) {
39        int z = 0;
40        for(char c : s.toCharArray()) {
41            if(c == '0') z++;
42        }
43        return new int[]{z, s.length() - z};
44    }
45}