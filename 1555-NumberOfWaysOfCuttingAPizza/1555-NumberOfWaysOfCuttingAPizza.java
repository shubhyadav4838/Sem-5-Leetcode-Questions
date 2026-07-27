// Last updated: 27/7/2026, 11:45:28 am
import java.util.*;

class Solution {
    int MOD = 1000000007;

    public int ways(String[] pizza, int k) {
        int rows = pizza.length;
        int cols = pizza[0].length();
        
        int[][] apples = new int[rows + 1][cols + 1];
        
        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                apples[r][c] = (pizza[r].charAt(c) == 'A' ? 1 : 0) 
                             + apples[r + 1][c] 
                             + apples[r][c + 1] 
                             - apples[r + 1][c + 1];
            }
        }
        
        Integer[][][] dp = new Integer[rows][cols][k];
        
        return solve(0, 0, k - 1, rows, cols, apples, dp);
    }

    private int solve(int r, int c, int k, int rows, int cols, int[][] apples, Integer[][][] dp) {
        if (apples[r][c] == 0) {
            return 0;
        }
        
        if (k == 0) {
            return 1;
        }
        
        if (dp[r][c][k] != null) {
            return dp[r][c][k];
        }
        
        int ans = 0;
        
        for (int i = r + 1; i < rows; i++) {
            if (apples[r][c] - apples[i][c] > 0) {
                ans = (ans + solve(i, c, k - 1, rows, cols, apples, dp)) % MOD;
            }
        }
        
        for (int j = c + 1; j < cols; j++) {
           
            if (apples[r][c] - apples[r][j] > 0) {
                ans = (ans + solve(r, j, k - 1, rows, cols, apples, dp)) % MOD;
            }
        }
        
        return dp[r][c][k] = ans;
    }
}