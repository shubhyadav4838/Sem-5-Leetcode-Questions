// Last updated: 27/7/2026, 11:46:23 am
class Solution {
    public static int minScoreTriangulation(int[] arr) {
		int[][] dp = new int[arr.length][arr.length];

		for(int i=arr.length-1; i>=0;i--) {
			for(int j = i+2;j<dp[0].length;j++) {
				int ans = Integer.MAX_VALUE;
				for(int k = i+1; k<j; k++) {
					int fs = dp[i][k];
					int ls = dp[k][j];
					int self = arr[i] * arr[j] * arr[k];
					ans = Math.min(ans, self + fs + ls);
				}
				dp[i][j] = ans;
			}
		}
		return dp[0][arr.length-1];
	}
}