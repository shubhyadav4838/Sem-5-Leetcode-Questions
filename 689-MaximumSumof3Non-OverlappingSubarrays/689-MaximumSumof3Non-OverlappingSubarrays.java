// Last updated: 9/1/2026, 12:40:44 pm
1class Solution {
2   public static int[] maxSumOfThreeSubarrays(int[] arr, int k) {
3		long[] pre = new long[arr.length];
4		long sum = 0;
5		for(int i = 0;i<pre.length;i++) {
6			sum+=(long)arr[i];
7			if(i==k-1) {
8				pre[i] = sum;
9			}
10			else if(i>=k) {
11				sum-= (long)arr[i-k];
12				pre[i] = sum;
13			}
14		}
15		
16		int first = 0;
17		int[] second = {0,0};
18		int[] third = {0,0,0};
19		
20		long firstarr = 0;
21		long secarr = 0;
22		long thirdarr = 0;
23		
24		
25		for(int i = k*3-1; i<pre.length;i++) {
26			int a = i-2*k;
27			int b = i-k;
28			int c = i;
29			
30			if(pre[a]>firstarr) {
31				firstarr = pre[a];
32				first = a-k+1;
33			}
34			
35			if(firstarr+pre[b]>secarr) {
36				secarr = firstarr+pre[b];
37				second = new int[] {first,b-k+1};
38			}
39			
40			if(secarr+pre[c]>thirdarr) {
41				thirdarr = secarr+pre[c];
42				third = new int[] {second[0],second[1],c-k+1};
43			}
44		}
45		return third;
46		
47	}
48}