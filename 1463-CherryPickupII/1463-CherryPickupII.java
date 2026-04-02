// Last updated: 2/4/2026, 4:07:56 pm
1class Solution {
2    public static int cherryPickup(int[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5        Integer[][][] dp = new Integer[n][m][m];
6        return solve(0, 0, grid[0].length - 1, grid, dp);
7
8    }
9
10    public static int solve(int row, int c1, int c2, int[][] arr, Integer[][][] dp) {
11        if (c1 < 0 || c2 < 0 || c1 >= arr[0].length || c2 >= arr[0].length) {
12            return 0;
13        }
14        if (row == arr.length - 1) {
15            if (c1 == c2) {
16                return arr[row][c1];
17            }
18            return arr[row][c1] + arr[row][c2];
19        }
20
21        if (dp[row][c1][c2] != null) {
22            return dp[row][c1][c2];
23        }
24
25        int val = arr[row][c1];
26        if (c1 != c2) {
27            val += arr[row][c2];
28        }
29
30        int maxCherries = 0;
31        for (int d1 = -1; d1 <= 1; d1++) {
32            for (int d2 = -1; d2 <= 1; d2++) {
33                maxCherries = Math.max(maxCherries, solve(row + 1, c1 + d1, c2 + d2, arr, dp));
34            }
35        }
36        return dp[row][c1][c2] = val + maxCherries;
37
38    }
39}