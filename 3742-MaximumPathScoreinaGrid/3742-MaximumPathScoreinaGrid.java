// Last updated: 30/4/2026, 9:58:40 pm
1class Solution {
2    public int maxPathScore(int[][] grid, int k) {
3        return totalScore(grid,k);
4    }
5    public static int totalScore(int[][] arr, int k) {
6	    int m = arr.length, n = arr[0].length;
7	    Integer[][][] dp = new Integer[m][n][k + 1];
8
9	    int ans = getScore(0, 0, 0, k, arr, dp);
10	    return Math.max(-1, ans);
11	}
12
13	public static int getScore(int i, int j, int money, int k, int[][] arr, Integer[][][] dp) {
14	    if (money > k) return Integer.MIN_VALUE;
15
16	    if (dp[i][j][money] != null) return dp[i][j][money];
17
18	    int num = arr[i][j];
19	    int score = (num == 2 ? 2 : num);
20	    int newcost = money + (num == 0 ? 0 : 1);
21
22	    int m = arr.length;
23	    boolean flag = true; // un used
24	    int n = arr[0].length;
25
26	    if (i == m - 1 && j == n - 1) {
27	    	int res;
28	    	if (newcost <= k) {
29	    	    res = score;
30	    	} else {
31	    	    res = Integer.MIN_VALUE;
32	    	}
33	        dp[i][j][money] = res;
34	        flag = false;
35	        return res;
36	    }
37
38	    int result = Integer.MIN_VALUE;
39
40	    if (i + 1 < m) {
41	    	flag = true;
42	    	result = Math.max(result, getScore(i + 1, j, newcost, k, arr, dp));
43	    }
44	    if (j + 1 < n) {
45	    	flag = true;
46	    	result = Math.max(result, getScore(i, j + 1, newcost, k, arr, dp));
47	    }
48
49	    int current;
50	    if (result == Integer.MIN_VALUE) {
51	        current = Integer.MIN_VALUE;
52	    } else {
53	        current = result + score;
54	    }
55
56	    dp[i][j][money] = current;
57	    return current;
58	}
59}