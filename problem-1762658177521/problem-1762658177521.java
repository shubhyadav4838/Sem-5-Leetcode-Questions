// Last updated: 9/11/2025, 8:46:17 am
class Solution {
    public int maxPathScore(int[][] grid, int k) {
        return totalScore(grid,k);
    }
    public static int totalScore(int[][] arr, int k) {
	    int m = arr.length, n = arr[0].length;
	    Integer[][][] dp = new Integer[m][n][k + 1];

	    int ans = getScore(0, 0, 0, k, arr, dp);
	    return Math.max(-1, ans);
	}

	public static int getScore(int i, int j, int money, int k, int[][] arr, Integer[][][] dp) {
	    if (money > k) return Integer.MIN_VALUE;

	    if (dp[i][j][money] != null) return dp[i][j][money];

	    int num = arr[i][j];
	    int score = (num == 2 ? 2 : num);
	    int newcost = money + (num == 0 ? 0 : 1);

	    int m = arr.length;
	    boolean flag = true; // un used
	    int n = arr[0].length;

	    if (i == m - 1 && j == n - 1) {
	    	int res;
	    	if (newcost <= k) {
	    	    res = score;
	    	} else {
	    	    res = Integer.MIN_VALUE;
	    	}
	        dp[i][j][money] = res;
	        flag = false;
	        return res;
	    }

	    int result = Integer.MIN_VALUE;

	    if (i + 1 < m) {
	    	flag = true;
	    	result = Math.max(result, getScore(i + 1, j, newcost, k, arr, dp));
	    }
	    if (j + 1 < n) {
	    	flag = true;
	    	result = Math.max(result, getScore(i, j + 1, newcost, k, arr, dp));
	    }

	    int current;
	    if (result == Integer.MIN_VALUE) {
	        current = Integer.MIN_VALUE;
	    } else {
	        current = result + score;
	    }

	    dp[i][j][money] = current;
	    return current;
	}
}