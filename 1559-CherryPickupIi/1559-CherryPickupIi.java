// Last updated: 27/7/2026, 11:45:27 am
class Solution {
    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Integer[][][] dp = new Integer[n][m][m];
        return solve(0, 0, grid[0].length - 1, grid, dp);

    }

    public static int solve(int row, int c1, int c2, int[][] arr, Integer[][][] dp) {
        if (c1 < 0 || c2 < 0 || c1 >= arr[0].length || c2 >= arr[0].length) {
            return 0;
        }
        if (row == arr.length - 1) {
            if (c1 == c2) {
                return arr[row][c1];
            }
            return arr[row][c1] + arr[row][c2];
        }

        if (dp[row][c1][c2] != null) {
            return dp[row][c1][c2];
        }

        int val = arr[row][c1];
        if (c1 != c2) {
            val += arr[row][c2];
        }

        int maxCherries = 0;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                maxCherries = Math.max(maxCherries, solve(row + 1, c1 + d1, c2 + d2, arr, dp));
            }
        }
        return dp[row][c1][c2] = val + maxCherries;

    }
}