// Last updated: 23/2/2026, 3:49:03 pm
1class Solution {
2    public int climbStairs(int n) {
3        if(n<=2){
4            return n;
5        }
6        int[] dp = new int[n];
7        dp[0] = 1;
8        dp[1] = 2;
9        for(int i = 2; i<dp.length; i++){
10            dp[i] = dp[i-1]+dp[i-2];
11        }
12        return dp[n-1];
13    }
14}