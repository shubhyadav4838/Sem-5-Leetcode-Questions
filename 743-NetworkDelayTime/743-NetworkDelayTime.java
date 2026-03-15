// Last updated: 15/3/2026, 11:27:16 pm
1class Solution {
2    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
3		Integer[][] dp = new Integer[piles.size()+1][k+1];
4		int ans = solve(piles, k,dp, 0 );
5		return ans;
6    }
7
8	private static int solve(List<List<Integer>> piles, int k, Integer[][] dp, int idx) {
9		// TODO Auto-generated method stub
10		if(k==0)return 0;
11		if(idx>=piles.size()) {
12			return -9999999;
13		}
14		if(dp[idx][k]!=null) {
15			return dp[idx][k];
16		}
17		int ans = solve(piles,k,dp,idx+1);
18		int curr = 0;
19		int limit = Math.min(k, piles.get(idx).size());
20		for(int i = 0; i<limit;i++) {
21			curr += piles.get(idx).get(i);
22			int req = solve(piles,k-i-1,dp,idx+1);
23
24				ans = Math.max(ans, req+curr);
25
26		}
27		return dp[idx][k]=ans;
28		
29	}
30}