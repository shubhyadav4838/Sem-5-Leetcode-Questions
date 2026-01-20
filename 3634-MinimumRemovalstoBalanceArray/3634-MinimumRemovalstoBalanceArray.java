// Last updated: 20/1/2026, 2:42:13 pm
1class Solution {
2   public static int minRemoval(int[] arr, int k) {
3		Arrays.sort(arr);
4		int n = arr.length;
5		int ans = 9999999;
6		
7		for(int si = 0;si<n;si++) {
8			long target = (long)arr[si]*k;
9			int idx = find(arr,target,si);
10			int numrem = n-(idx-si+1);
11			ans = Math.min(ans, numrem);
12			
13		}
14		return ans;
15	}
16
17	private static int find(int[] arr, long target, int si) {
18		// TODO Auto-generated method stub
19		int st = si;
20		int ed = arr.length-1;
21		int ans = 0;
22		while(st<=ed) {
23			int mid = (st+ed)/2;
24			if(arr[mid]<=target) {
25				ans = mid;
26				st = mid+1;
27			}else {
28				ed = mid-1;
29			}
30		}
31		return ans;
32	}
33	
34}