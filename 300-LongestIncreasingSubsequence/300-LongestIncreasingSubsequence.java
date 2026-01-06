// Last updated: 6/1/2026, 6:31:08 pm
1class Solution {
2    public static int lengthOfLIS(int[] arr) {
3		int n = arr.length;
4		if(n==1)return 1;
5		int[] dp = new int[n];
6		
7		
8		dp[0] = arr[0];
9		int len = 1;
10		for(int i = 1;i<n;i++) {
11			if(arr[i]<dp[len-1]) {
12				int idx = binarySearch(arr[i],0,len-1,dp);
13				dp[idx] = arr[i];
14			}else if(arr[i]>dp[len-1]) {
15				dp[len] = arr[i];
16				len++;
17			}
18		}
19		return len;
20		
21		
22	}
23	
24	public static int binarySearch(int item,int si,int ei,int[] arr) {
25		int ans = 0;
26		while(si<=ei) {
27			int mid = (si+ei)/2;
28			if(arr[mid]>=item) {
29				ans = mid;
30				ei = mid-1;
31			}else {
32				si = mid+1;
33			}
34		}
35		return ans;
36	}
37}