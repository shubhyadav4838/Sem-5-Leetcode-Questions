// Last updated: 13/1/2026, 1:02:17 pm
1class Solution {
2    public int change(int amount, int[] arr) {
3        int[] dp = new int[amount+1];
4		dp[0] = 1;
5		for(int i = 0;i<arr.length;i++) {
6			for(int j = arr[i];j<=amount;j++) {
7				dp[j] += dp[j-arr[i]];
8			}
9		}
10		return dp[amount];
11    }
12}