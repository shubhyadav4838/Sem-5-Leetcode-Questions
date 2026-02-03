// Last updated: 3/2/2026, 5:49:01 pm
1class Solution {
2    public static int[] maxSumOfThreeSubarrays(int[] arr, int k) {
3		int n = arr.length;
4		int[] pre = new int[n];
5		pre[0] = arr[0];
6		for (int i = 1; i < n; i++) {
7			pre[i] = pre[i - 1] + arr[i];
8
9			if (i - k >= 0) {
10				pre[i] -= arr[i-k];
11			}
12		}
13		
14		int first = 0;
15		int sec = 0;
16		int third = 0;
17		int idxa = 0;
18		int[] idxb = {0,0};
19		int[] idxc = {0,0,0};
20
21		for (int i = 3 * k - 1; i < n; i++) {
22			int c = i;
23			int b = i-k;
24			int a = i-(2*k);
25			
26			if(pre[a]>first) {
27				first = pre[a];
28				idxa = a-k+1;
29			}
30			if(pre[b]+first > sec) {
31				sec = pre[b]+first;
32				idxb = new int[] {idxa,b-k+1};
33			}
34			if(pre[c]+sec > third) {
35				third = pre[c]+sec;
36				idxc = new int[] {idxb[0], idxb[1],c-k+1};
37			}
38		}
39		;
40		return idxc;
41	}
42}