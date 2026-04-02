// Last updated: 2/4/2026, 11:53:30 am
1class Solution {
2   public static int tallestBillboard(int[] arr) {
3		int sum = 0;
4		for(int x:arr) {
5			sum += x;
6		}
7		int offset = sum;
8		int[][] dp = new int[arr.length][2*offset + 1];
9		for(int [] x:dp) {
10			Arrays.fill(x,-1);
11		}
12		
13		int ans = solve(arr,0,0,dp,offset);
14		return (ans<0) ? 0 :ans;
15	}
16	
17	public static int solve(int[] arr, int i, int diff, int[][] dp, int offset) {
18		if(i==arr.length) {
19			if(diff ==0 ) {
20				return 0;
21			}
22			return -999999;
23		}
24		
25		if(dp[i][offset+diff]!=-1) {
26			return dp[i][offset+diff];
27		}
28		// skip the curr pillar
29		int a = solve(arr,i+1,diff, dp, offset);
30		
31		// add curr to pillar a
32		int b = arr[i] + solve(arr,i+1,diff+arr[i], dp, offset);
33		
34		// add curr to pillar b
35		int c = solve(arr,i+1, diff-arr[i], dp, offset);
36		
37		return dp[i][offset+diff] = Math.max(a, Math.max(b, c));
38	}
39}