// Last updated: 13/1/2026, 5:45:28 pm
1class Solution {
2    Integer[][] memo;
3
4    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
5        int n = piles.size();
6        memo = new Integer[n][k + 1];
7        
8        return solve(0, k, piles);
9    }
10
11    private int solve(int pileIndex, int k, List<List<Integer>> piles) {
12        if (k == 0) return 0;
13        
14        if (pileIndex == piles.size()) return 0;
15        if (memo[pileIndex][k] != null) {
16            return memo[pileIndex][k];
17        }
18
19        int maxVal = solve(pileIndex + 1, k, piles);
20        int currentPileSum = 0;        
21        int limit = Math.min(k, piles.get(pileIndex).size());
22        
23        for (int j = 0; j < limit; j++) {
24       
25            currentPileSum += piles.get(pileIndex).get(j);
26            int result = solve(pileIndex + 1, k - (j + 1), piles);
27            maxVal = Math.max(maxVal, currentPileSum + result);
28        }
29
30        return memo[pileIndex][k] = maxVal;
31    }
32}