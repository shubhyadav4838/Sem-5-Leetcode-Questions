// Last updated: 2/4/2026, 4:04:57 pm
1class Solution {
2    public static int cherryPickup(int[][] grid) {
3		int n = grid.length;
4		int m = grid[0].length;
5		Integer[][][] dp = new Integer[n][m][m];
6		return solve(0, 0, grid[0].length - 1, grid,dp);
7
8	}
9
10	public static int solve(int row, int c1, int c2, int[][] arr, Integer[][][] dp) {
11		if (c1 < 0 || c2 < 0 || c1 >= arr[0].length || c2 >= arr[0].length) {
12			return 0;
13		}
14		if (row == arr.length - 1) {
15			if (c1 == c2) {
16				return arr[row][c1];
17			}
18			return arr[row][c1] + arr[row][c2];
19		}
20		
21		if(dp[row][c1][c2]!=null) {
22			return dp[row][c1][c2];
23		}
24
25		int val = arr[row][c1];
26		if (c1 != c2) {
27			val += arr[row][c2];
28		}
29
30		int a = solve(row + 1, c1 + 1, c2 + 1, arr,dp);
31		int b = solve(row + 1, c1 + 1, c2 - 1, arr,dp);
32		int g = solve(row +1, c1+1, c2,arr,dp);
33
34		int c = solve(row + 1, c1 - 1, c2 + 1, arr,dp);
35		int d = solve(row + 1, c1 - 1, c2 - 1, arr,dp);
36		int h = solve(row+1,c1-1,c2,arr,dp);
37
38		int e = solve(row + 1, c1, c2 + 1, arr,dp);
39		int f = solve(row + 1, c1, c2 - 1, arr,dp);
40		int i = solve(row+1,c1,c2,arr,dp);
41		
42		int abg = Math.max(Math.max(a, g), b);
43		int cdh = Math.max(Math.max(c, d), h);
44		int efi = Math.max(Math.max(e, f), i);
45		
46		
47
48		return dp[row][c1][c2] = val + Math.max(Math.max(abg, cdh),efi);
49
50	}
51}