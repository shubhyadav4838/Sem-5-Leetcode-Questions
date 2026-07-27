// Last updated: 27/7/2026, 11:44:36 am
class Solution {
   public static long maxAlternatingSum(int[] arr) {
		int n = arr.length;
		long[][] dp = new long[n+1][2];
		
		for(int i = n-1; i>=0; i--) {
			for(int j = 0; j<2; j++) {
				long skip = dp[i+1][j];
				long a = 0;
				long b = 0;
				if(j==0) {
					a = dp[i+1][1]+arr[i];
				}else {
					b = dp[i+1][0]-arr[i];
				}
				
				dp[i][j] = Math.max(skip, Math.max(a, b));
			}
		}
		return dp[0][0];
	}

}