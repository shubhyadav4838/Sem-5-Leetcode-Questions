// Last updated: 15/3/2026, 11:47:48 pm
1class Solution {
2    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
3		int[][] dp = new int[piles.size()+1][k+1];
4		int total = 0;
5		for(int idx = piles.size() - 1; idx >= 0; idx--){
6			for(int j = k; j>=0; j--) {
7				int ans = dp[idx+1][j];
8				int curr = 0;
9				int limit = Math.min(j, piles.get(idx).size());
10				for(int i = 0; i<limit;i++) {
11					curr += piles.get(idx).get(i);
12					int req = dp[idx+1][j - i - 1];
13					
14					ans = Math.max(ans, req+curr);
15				}
16				dp[idx][j] = ans;
17				total = Math.max(ans, total);
18				
19				
20				
21			}
22		}
23		
24		return total;
25    }
26
27	private static int solve(List<List<Integer>> piles, int k, Integer[][] dp, int idx) {
28		// TODO Auto-generated method stub
29		if(k==0)return 0;
30		if(idx>=piles.size()) {
31			return -9999999;
32		}
33		if(dp[idx][k]!=null) {
34			return dp[idx][k];
35		}
36		int ans = solve(piles,k,dp,idx+1);
37		int curr = 0;
38		int limit = Math.min(k, piles.get(idx).size());
39		for(int i = 0; i<limit;i++) {
40			curr += piles.get(idx).get(i);
41			int req = solve(piles,k-i-1,dp,idx+1);
42
43				ans = Math.max(ans, req+curr);
44
45		}
46		return dp[idx][k]=ans;
47		
48	}
49}