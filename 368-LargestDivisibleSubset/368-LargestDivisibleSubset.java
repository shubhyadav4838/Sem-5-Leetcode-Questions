// Last updated: 6/1/2026, 4:48:27 pm
1class Solution {
2    public static List<Integer> largestDivisibleSubset(int[] arr) {
3		Arrays.sort(arr);
4		int n = arr.length;
5		int[] dp = new int[n];
6		int[] pre = new int[n];
7		List<Integer> ll = new ArrayList<>();
8		
9		Arrays.fill(pre, -1);
10		dp[0] = 1;
11		int max = 1;
12		for(int i = 1;i<n;i++) {
13			dp[i] = 1;
14			for(int j = i-1;j>=0;j--) {
15				if(arr[i]%arr[j]==0) {
16					if(dp[i]<dp[j]+1) {
17						dp[i] = dp[j]+1;
18						pre[i] = j;
19					}	
20				}	
21			}
22			max = Math.max(max, dp[i]);
23		}
24		
25		int idx = n-1;
26		while(idx>=0 && dp[idx]!=max) {
27			idx--;
28		}
29		while(idx>=0) {
30			ll.add(arr[idx]);
31			idx = pre[idx];
32		}
33		return ll;
34
35	}
36}