// Last updated: 27/7/2026, 11:45:57 am
class Solution {
   public static int maximumSum(int[] arr) {
		int n = arr.length;
		
		int ans = Integer.MIN_VALUE;
		int[][]dp = new int[n+1][2];
		for(int[] x:dp) {
			Arrays.fill(x, -999999);
		}
		
	
		for(int i = n-1;i>=0;i--) {
			for(int delete = 0; delete<2; delete++) {
				
				int old = arr[i] + dp[i+1][delete];
				int ifdel = -999999;
				if(arr[i]<0 && delete==0) {
					ifdel = dp[i+1][1];
				}
				dp[i][delete] = Math.max(arr[i], Math.max(old, ifdel));
				ans = Math.max(ans, dp[i][delete]);
			}
		}
		return ans;
		

	}
}