// Last updated: 27/7/2026, 11:43:53 am
class Solution {
    static int MOD = (int)(1e9 + 7);
	public static int waysToReachTarget(int target, int[][] types) {
		int[][] dp = new int[target+1][types.length+1];
		for(int i = 0;i<dp[0].length;i++) {
			dp[0][i] = 1;
		}
		for(int remain = 1; remain<=target; remain++) {
			for(int idx = types.length-1; idx>=0; idx--) {
				int ans = 0;
				
				int count = types[idx][0];
				int marks = types[idx][1];
				for(int i = 0; i<= count; i++) {
					int curr = i*marks;
					if(curr>remain)break;
					int req = dp[remain-curr][idx+1];
					ans = (ans+req)%MOD;
				}
				dp[remain][idx] = ans;
			}
		}
		
		return dp[target][0];
		
	}
}