// Last updated: 27/7/2026, 11:45:49 am
class Solution {
    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
		int[][] dp = new int[piles.size()+1][k+1];
		int total = 0;
		for(int idx = piles.size() - 1; idx >= 0; idx--){
			for(int j = k; j>=0; j--) {
				int ans = dp[idx+1][j];
				int curr = 0;
				int limit = Math.min(j, piles.get(idx).size());
				for(int i = 0; i<limit;i++) {
					curr += piles.get(idx).get(i);
					int req = dp[idx+1][j - i - 1];
					
					ans = Math.max(ans, req+curr);
				}
				dp[idx][j] = ans;
				total = Math.max(ans, total);
				
				
				
			}
		}
		
		return total;
    }

	private static int solve(List<List<Integer>> piles, int k, Integer[][] dp, int idx) {
		// TODO Auto-generated method stub
		if(k==0)return 0;
		if(idx>=piles.size()) {
			return -9999999;
		}
		if(dp[idx][k]!=null) {
			return dp[idx][k];
		}
		int ans = solve(piles,k,dp,idx+1);
		int curr = 0;
		int limit = Math.min(k, piles.get(idx).size());
		for(int i = 0; i<limit;i++) {
			curr += piles.get(idx).get(i);
			int req = solve(piles,k-i-1,dp,idx+1);

				ans = Math.max(ans, req+curr);

		}
		return dp[idx][k]=ans;
		
	}
}