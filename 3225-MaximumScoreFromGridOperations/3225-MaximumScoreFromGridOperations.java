// Last updated: 29/4/2026, 10:53:11 pm
1public class Solution {
2    public long maximumScore(int[][] grid) {
3        int n = grid.length;
4        
5        long[][] pref = new long[n][n + 1];
6        for (int j = 0; j < n; j++) {
7            for (int i = 0; i < n; i++) {
8                pref[j][i + 1] = pref[j][i] + grid[i][j];
9            }
10        }
11
12        long[][] next_dp = new long[n + 1][n + 1];
13        long[][] curr_dp = new long[n + 1][n + 1];
14        
15        long[] M1 = new long[n + 1];
16        long[][] M2 = new long[n + 1][n + 1];
17        long[][] M3 = new long[n + 1][n + 1];
18
19        long INF = (long) 1e15; 
20
21        for (int col = n - 1; col >= 0; col--) {
22            
23            for (int y = 0; y <= n; y++) { 
24                
25                long max1 = -INF;
26                for (int x = 0; x <= y; x++) {
27                    max1 = Math.max(max1, next_dp[x][y] - pref[col][x]);
28                }
29                M1[y] = max1;
30
31                long max2 = -INF;
32                for (int m = 0; m <= n; m++) {
33                    if (m > y) {
34                        max2 = Math.max(max2, next_dp[m][y]);
35                    }
36                    M2[y][m] = max2;
37                }
38
39                long max3 = -INF;
40                for (int m = n; m >= 0; m--) { 
41                    M3[y][m] = max3;
42                    max3 = Math.max(max3, next_dp[m][y] + (col > 0 ? pref[col - 1][m] : 0));
43                }
44            }
45
46            for (int y = 0; y <= n; y++) {
47                for (int z = 0; z <= n; z++) { 
48                    int M = Math.max(y, z);
49
50                    long ans1 = pref[col][y] + M1[y];
51                    long ans2 = M2[y][M];
52                    long ans3 = M3[y][M] - (col > 0 ? pref[col - 1][M] : 0);
53
54                    curr_dp[y][z] = Math.max(ans1, Math.max(ans2, ans3));
55                }
56            }
57
58            long[][] temp = next_dp;
59            next_dp = curr_dp;
60            curr_dp = temp;
61        }
62
63        return next_dp[0][0];
64    }
65}