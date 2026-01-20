// Last updated: 20/1/2026, 3:27:45 pm
1class Solution {
2    public static int numTeams(int[] arr) {
3		int n = arr.length;
4		int ans = 0;
5		for(int i = 1;i<n-1;i++) {
6			int si = 0;
7			int ei = n-1;
8			int lsmall = 0;
9			int llarge = 0;
10			int rsmall = 0;
11			int rlarge = 0;
12			int val = arr[i];
13			while(si<i) {
14				if(arr[si]<val)lsmall++;
15				if(arr[si]>val)llarge++;
16				si++;
17			}
18			while(ei>i) {
19				if(arr[ei]<val)rsmall++;
20				if(arr[ei]>val)rlarge++;
21				ei--;
22			}
23			int total = (lsmall*rlarge)+(llarge*rsmall);
24			ans += total;
25		}
26		return ans;
27
28	}
29}