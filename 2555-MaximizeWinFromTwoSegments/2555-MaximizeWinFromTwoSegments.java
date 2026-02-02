// Last updated: 2/2/2026, 7:50:16 pm
1class Solution {
2    public static int maximizeWin(int[] arr, int k) {
3		int n = arr.length;
4		int[] dp = new int[n+1];
5		int ans = 0;
6		int si = 0;
7		for(int ei = 0;ei<n;ei++) {
8			while(si<n && arr[si]<arr[ei]-k) {
9				si++;
10			}
11			int sec = ei-si+1;
12			int first = si-1>=0? dp[si-1]:0;
13			ans = Math.max(ans, first+sec);
14			int pre = ei-1>=0 ?dp[ei-1]:0;
15			dp[ei] = Math.max(pre,sec); 
16		}
17		
18		return ans;
19
20	}
21}