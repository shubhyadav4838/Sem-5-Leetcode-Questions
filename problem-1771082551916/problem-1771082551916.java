// Last updated: 14/2/2026, 8:52:31 pm
1class Solution {
2    public static long rob(int[] arr, int[] colors) {
3		 long ans = 0;
4		 
5		 long pre = 0;
6		 for(int i = 0;i<arr.length;i++) {
7			 long temp = 0;
8			 if(i>0 && colors[i]==colors[i-1]) {
9				 temp = pre+arr[i];
10			 }else {
11				 temp = Math.max(pre+arr[i], ans+arr[i]);
12			 }
13			  pre = Math.max(pre, ans);
14			 ans = Math.max(ans, temp);
15		 }
16		 return ans;
17	        
18	 }
19}