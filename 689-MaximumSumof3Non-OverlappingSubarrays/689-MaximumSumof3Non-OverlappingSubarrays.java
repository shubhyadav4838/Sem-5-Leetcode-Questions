// Last updated: 9/1/2026, 12:40:17 pm
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
16		for(long x:pre) {
17			System.out.print(x+" ");
18		}
19		System.out.println();
20		
21		int first = 0;
22		int[] second = {0,0};
23		int[] third = {0,0,0};
24		
25		long firstarr = 0;
26		long secarr = 0;
27		long thirdarr = 0;
28		
29		
30		for(int i = k*3-1; i<pre.length;i++) {
31			int a = i-2*k;
32			int b = i-k;
33			int c = i;
34			
35			if(pre[a]>firstarr) {
36				firstarr = pre[a];
37				first = a-k+1;
38			}
39			
40			if(firstarr+pre[b]>secarr) {
41				secarr = firstarr+pre[b];
42				second = new int[] {first,b-k+1};
43			}
44			
45			if(secarr+pre[c]>thirdarr) {
46				thirdarr = secarr+pre[c];
47				third = new int[] {second[0],second[1],c-k+1};
48			}
49		}
50		return third;
51		
52	}
53}