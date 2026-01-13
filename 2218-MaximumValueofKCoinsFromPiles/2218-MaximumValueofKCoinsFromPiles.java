// Last updated: 13/1/2026, 6:13:58 pm
1class Solution {
2    static Integer[][] dp;
3
4    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
5        int n = piles.size();
6        dp = new Integer[n][k + 1];
7        
8        return solve(0, k, piles);
9    }
10
11    private static int solve(int pileidx, int k, List<List<Integer>> piles) {
12        if (k == 0) return 0;
13        
14        if (pileidx == piles.size()) return 0;
15        if (dp[pileidx][k] != null) {
16            return dp[pileidx][k];
17        }
18
19        int maxVal = solve(pileidx + 1, k, piles);
20        int currentPileSum = 0;        
21        int limit = Math.min(k, piles.get(pileidx).size());
22        
23        for (int j = 0; j < limit; j++) {
24       
25            currentPileSum += piles.get(pileidx).get(j);
26            int result = solve(pileidx + 1, k - (j + 1), piles);
27            maxVal = Math.max(maxVal, currentPileSum + result);
28        }
29
30        return dp[pileidx][k] = maxVal;
31    }
32}