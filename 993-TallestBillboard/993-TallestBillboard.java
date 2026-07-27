// Last updated: 27/7/2026, 11:46:49 am
class Solution {
   public static int tallestBillboard(int[] arr) {
		int sum = 0;
		for(int x:arr) {
			sum += x;
		}
		int offset = sum;
		int[][] dp = new int[arr.length][2*offset + 1];
		for(int [] x:dp) {
			Arrays.fill(x,-1);
		}
		
		int ans = solve(arr,0,0,dp,offset);
		return (ans<0) ? 0 :ans;
	}
	
	public static int solve(int[] arr, int i, int diff, int[][] dp, int offset) {
		if(i==arr.length) {
			if(diff ==0 ) {
				return 0;
			}
			return -999999;
		}
		
		if(dp[i][offset+diff]!=-1) {
			return dp[i][offset+diff];
		}
		// skip the curr pillar
		int a = solve(arr,i+1,diff, dp, offset);
		
		// add curr to pillar a
		int b = arr[i] + solve(arr,i+1,diff+arr[i], dp, offset);
		
		// add curr to pillar b
		int c = solve(arr,i+1, diff-arr[i], dp, offset);
		
		return dp[i][offset+diff] = Math.max(a, Math.max(b, c));
	}
}