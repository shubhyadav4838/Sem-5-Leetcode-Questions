// Last updated: 4/8/2025, 12:01:03 am
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int col = 1; col < n; col++) {
            grid[0][col] += grid[0][col - 1];
        }

        for (int row = 1; row < m; row++) {
            grid[row][0] += grid[row - 1][0];
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                grid[row][col] += Math.min(grid[row - 1][col], grid[row][col - 1]);
            }
        }

        return grid[m - 1][n - 1];
    }
}
