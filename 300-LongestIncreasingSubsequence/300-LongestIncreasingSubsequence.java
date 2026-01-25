// Last updated: 25/1/2026, 3:04:36 pm
1class Solution {
2    public static int lengthOfLIS(int[] arr) {
3		int n = arr.length;
4		int[] dp = new int[n+1];
5		dp[0] = arr[0];
6		int len = 1;
7		for(int i = 1;i<n;i++) {
8			if(dp[len-1]<arr[i]) {
9				dp[len] = arr[i];
10				len++;
11			}else {
12				int idx = search(dp,0,len-1,arr[i]);
13				dp[idx] = arr[i];
14			}
15		}
16		return len;
17		
18	}
19
20	private static int search(int[] dp, int lo, int hi, int target) {
21		// TODO Auto-generated method stub
22		int ans = 0;
23		while(lo<=hi) {
24			int mid = (lo+hi)/2;
25			if(dp[mid]>=target) {
26				ans = mid;
27				hi = mid-1;
28			}else {
29				lo = mid+1;
30			}
31		}
32		return ans;
33	}
34}