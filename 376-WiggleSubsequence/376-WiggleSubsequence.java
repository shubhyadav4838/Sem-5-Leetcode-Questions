// Last updated: 29/3/2026, 1:49:30 pm
1class Solution {
2    
3public static int wiggleMaxLength(int[] arr) {
4        if(arr.length==1)return 1;
5    	int[] dp = new int[arr.length];
6    	Arrays.fill(dp,-1);
7        int i=0;
8        while(i<arr.length-1 && arr[i]==arr[i+1])i++;
9    	
10        return wiggle(0,i,1,arr,dp);
11        
12    }
13
14	private static int wiggle(int diff, int i, int len, int[] arr, int[] dp) {
15		// TODO Auto-generated method stub
16		while(i<arr.length-1 && arr[i]==arr[i+1])i++;
17		if(i>=arr.length-1) {
18			return len;
19		}
20		
21		if(dp[i] != -1) {
22			return dp[i];
23		}
24		
25		int a = 0;
26		int b = 0;
27		
28		if(diff<=0 &&  arr[i]<arr[i+1]) {
29			a = wiggle(arr[i+1]-arr[i], i+1, len+1,arr,dp);
30		}
31		if(diff>=0 && arr[i]>arr[i+1]) {
32			int c = wiggle(arr[i+1]-arr[i], i+1,len+1,arr,dp);
33			a = Math.max(a, c);
34			
35		}
36		b = wiggle(diff,i+1, len, arr,dp);
37		return dp[i] = Math.max(a, b);
38		
39	}
40}