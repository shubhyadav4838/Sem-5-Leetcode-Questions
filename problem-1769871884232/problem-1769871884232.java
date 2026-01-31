// Last updated: 31/1/2026, 8:34:44 pm
1class Solution {
2   public static int minimumK(int[] arr) {
3		long lo = 1;
4		long hi = 0;
5		
6		for(int x:arr) {
7			hi += x;
8
9		}
10		long ans = 0;
11		while(lo<=hi) {
12			long mid = lo+((hi-lo)/2);
13			if(ispossible(arr,mid)) {
14				ans = mid;
15				hi = mid-1;
16			}else {
17				lo = mid+1;
18			}
19		}
20		return (int)ans;
21
22	}
23
24	private static boolean ispossible(int[] arr, long mid) {
25		// TODO Auto-generated method stub
26		long count = 0;
27		for(int i = 0;i<arr.length;i++) {
28			long n = (long)((long)(arr[i])/mid);
29			if(arr[i]%mid!=0) {
30				n++;
31			}
32			count += n;
33			
34			
35			
36		}
37		
38		long sqr = (long)(mid*mid);
39		return count<=sqr;
40	}
41}