// Last updated: 29/3/2026, 12:38:51 pm
1class Solution {
2    public static boolean canPartition(int[] arr) {
3		int sum = 0;
4		for(int x:arr) {
5			sum += x;
6		}
7		if(sum%2!=0) {
8			return false;
9		}
10		
11		sum = sum/2;
12		
13		boolean[] onedp = new boolean[sum+1];
14		onedp[0] = true;
15		
16		
17		for(int idx = arr.length-1;  idx>=0; idx--) {
18			boolean [] curr = new boolean[sum+1];
19			for(int j = 0; j<=sum; j++) {
20				
21				boolean exc = onedp[j];
22				boolean inc = false;
23				if(arr[idx]<=j) {
24					inc = onedp[j-arr[idx]];
25				}
26				curr[j] = exc | inc;
27			}
28			onedp = curr;
29			
30		}
31		
32		return onedp[sum];
33	}
34}