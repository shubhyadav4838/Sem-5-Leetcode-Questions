// Last updated: 12/1/2026, 12:09:24 am
1class Solution {
2    public static boolean canPartition(int[] arr) {
3		int sum = 0;
4		for(int x:arr) {
5			sum+=x;
6		}
7		if(sum%2!=0) {
8			return false;
9		}
10		int target = sum/2;
11		boolean[] dp = new boolean[target+1];
12		dp[0] = true;
13		
14		for(int i = 0;i<arr.length;i++) {
15			for(int j = target;j>=arr[i];j--) {
16				if(dp[j-arr[i]]==true) {
17					dp[j] = true;
18				}
19			}
20		}
21		return dp[target];
22		
23	}
24}