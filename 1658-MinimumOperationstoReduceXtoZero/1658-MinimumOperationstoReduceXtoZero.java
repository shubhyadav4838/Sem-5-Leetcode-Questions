// Last updated: 15/2/2026, 11:58:51 pm
1class Solution {
2    public static int minOperations(int[] arr, int x) {
3		int n = arr.length;
4		int[] pre = new int[n];
5		int ans = Integer.MAX_VALUE;
6		pre[0] = arr[0];
7		if(pre[0]==x) {
8			ans = 1;
9		}
10		for(int i = 1;i<arr.length;i++) {
11			pre[i] = arr[i]+pre[i-1];
12			if(pre[i]==x) {
13				ans = Math.min(ans, i+1);
14			}
15		}
16		long sum = 0;
17		for(int i = n-1; i>=0 && sum<=x ;i--) {
18			sum += arr[i];
19			if(sum==x) {
20				ans = Math.min(ans, n-i);
21				
22			}
23			int req = (int)(x-sum);
24			int idx = getIdx(pre,i-1,0,req);
25			if(idx==-1)continue;
26			
27			if(pre[idx] == req) {
28				int val = n-i + idx+1;
29				ans = Math.min(ans, val);
30			}
31			
32		}
33		return ans==Integer.MAX_VALUE ? -1:ans;
34		
35		
36	}
37	public static int getIdx(int[] arr, int hi, int lo, int target) {
38		int ans = -1;
39		while(lo<=hi) {
40			int mid = lo+((hi-lo)/2);
41			if(arr[mid]>=target) {
42				ans = mid;
43				hi = mid-1;
44			}else {
45				lo = mid +1;
46			}
47		}
48		return ans;
49	}
50}