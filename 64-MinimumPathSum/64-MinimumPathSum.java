// Last updated: 23/1/2026, 10:43:39 pm
1class Solution {
2    public int minPathSum(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4
5        for (int col = 1; col < n; col++) {
6            grid[0][col] += grid[0][col - 1];
7        }
8
9        for (int row = 1; row < m; row++) {
10            grid[row][0] += grid[row - 1][0];
11        }
12
13        for (int row = 1; row < m; row++) {
14            for (int col = 1; col < n; col++) {
15                grid[row][col] += Math.min(grid[row - 1][col], grid[row][col - 1]);
16            }
17        }
18
19        return grid[m - 1][n - 1];
20    }
21}
22