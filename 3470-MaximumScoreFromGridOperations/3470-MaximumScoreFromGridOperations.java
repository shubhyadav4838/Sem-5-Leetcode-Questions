// Last updated: 27/7/2026, 11:43:21 am
public class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        
        long[][] pref = new long[n][n + 1];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                pref[j][i + 1] = pref[j][i] + grid[i][j];
            }
        }

        long[][] next_dp = new long[n + 1][n + 1];
        long[][] curr_dp = new long[n + 1][n + 1];
        
        long[] M1 = new long[n + 1];
        long[][] M2 = new long[n + 1][n + 1];
        long[][] M3 = new long[n + 1][n + 1];

        long INF = (long) 1e15; 

        for (int col = n - 1; col >= 0; col--) {
            
            for (int y = 0; y <= n; y++) { 
                
                long max1 = -INF;
                for (int x = 0; x <= y; x++) {
                    max1 = Math.max(max1, next_dp[x][y] - pref[col][x]);
                }
                M1[y] = max1;

                long max2 = -INF;
                for (int m = 0; m <= n; m++) {
                    if (m > y) {
                        max2 = Math.max(max2, next_dp[m][y]);
                    }
                    M2[y][m] = max2;
                }

                long max3 = -INF;
                for (int m = n; m >= 0; m--) { 
                    M3[y][m] = max3;
                    max3 = Math.max(max3, next_dp[m][y] + (col > 0 ? pref[col - 1][m] : 0));
                }
            }

            for (int y = 0; y <= n; y++) {
                for (int z = 0; z <= n; z++) { 
                    int M = Math.max(y, z);

                    long ans1 = pref[col][y] + M1[y];
                    long ans2 = M2[y][M];
                    long ans3 = M3[y][M] - (col > 0 ? pref[col - 1][M] : 0);

                    curr_dp[y][z] = Math.max(ans1, Math.max(ans2, ans3));
                }
            }

            long[][] temp = next_dp;
            next_dp = curr_dp;
            curr_dp = temp;
        }

        return next_dp[0][0];
    }
}