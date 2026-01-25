// Last updated: 25/1/2026, 4:03:25 pm
1class Solution {
2    public int maxEnvelopes(int[][] arr) {
3       Arrays.sort(arr,(a,b)->{
4			if(a[0]==b[0]) {
5				return b[1]-a[1];
6			}
7			return a[0]-b[0];
8		});
9		
10		
11		int n = arr.length;
12		int[] dp = new int[n];
13		dp[0] = arr[0][1];
14		int len = 0;
15		for(int i = 1;i<n;i++) {
16			int height = arr[i][1];
17			if( dp[len]<height )  {
18				len++;
19				dp[len] = height;
20			}else {
21				int idx = search(dp,0,len,height);
22                dp[idx] = height;
23				
24			}
25		}
26		return len+1;
27        
28    }
29   private static int search(int[] dp, int lo, int hi,int height) {
30		// TODO Auto-generated method stub
31		while(lo<hi) {
32			int mid = (lo+hi)/2;
33			if(dp[mid]<height) {
34				lo = mid+1;
35			}else {
36				hi = mid;
37				
38			}
39		}
40		return lo;
41	}
42}