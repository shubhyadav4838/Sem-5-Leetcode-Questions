// Last updated: 19/4/2026, 8:54:46 pm
1class Solution {
2    public static int maxDistance(int[] a, int[] b) {
3		int ans = 0;
4		for(int i = 0;i<b.length;i++) {
5			int val = search(i,b[i],a);
6			ans = Math.max(ans, val);
7			
8		}
9		return ans;
10
11	}
12
13	private static int search(int idx, int target, int[] a) {
14		// TODO Auto-generated method stub
15		int lo = 0;
16		int hi = Math.min(idx, a.length-1);
17		if(idx<=hi && a[idx]>target) {
18			return 0;
19		}
20		int ans = idx;
21		
22		while(lo<=hi) {
23			int mid = lo +(hi-lo)/2;
24			if(a[mid]<=target) {
25				ans = mid;
26				hi = mid-1;
27			}else {
28				lo = mid+1;
29			}
30			
31		}
32		
33		return idx-ans;
34	}
35
36}