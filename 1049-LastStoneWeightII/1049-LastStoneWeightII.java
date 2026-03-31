// Last updated: 31/3/2026, 11:36:42 pm
1class Solution {
2   public static int lastStoneWeightII(int[] arr) {
3		int sum = 0;
4		for(int x :arr) {
5			sum += x;
6		}
7		
8		int target = sum/2;
9		int n = arr.length;
10		
11		int[] onedp = new int[target+1];
12		for(int idx = n-1; idx>=0; idx--) {
13			int[] curr = new int[target+1];
14			for(int j = 1; j<=target; j++) {
15				
16				int a = 0;
17				if(arr[idx]<=j) {
18					a = arr[idx] + onedp[j-arr[idx]];
19				}
20				int b = onedp[j];
21				
22				curr[j] = Math.max(a, b);
23			}
24			onedp = curr;
25		}
26		
27		int ans = onedp[target];
28		return sum-(2*ans);
29
30	}
31}