// Last updated: 17/2/2026, 7:51:06 pm
1class Solution {
2    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
3        Long[][] dp = new Long[piles.size() + 1][k + 1];
4        return (int) (solve(piles, k, 0, dp));
5    }
6
7    public static long solve(List<List<Integer>> piles, int k, int p, Long[][] dp) {
8        if (k <= 0) {
9            return 0;
10        }
11        if (p >= piles.size()) {
12            return 0;
13        }
14
15        if (dp[p][k] != null) {
16            return dp[p][k];
17        }
18        long maxval = solve(piles,k,p+1,dp);
19        int limit = Math.min(k,piles.get(p).size());
20        long curr = 0;
21        for(int i = 0; i< limit; i++){
22            curr += piles.get(p).get(i);
23            long res = solve(piles,k-(i+1),p+1,dp);
24            maxval = Math.max(maxval,curr+res);
25        }
26        
27
28        return dp[p][k] = maxval;
29    }
30}