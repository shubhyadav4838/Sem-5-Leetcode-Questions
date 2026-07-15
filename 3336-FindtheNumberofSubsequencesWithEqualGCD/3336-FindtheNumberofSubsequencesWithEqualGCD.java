// Last updated: 15/7/2026, 10:02:19 am
1class Solution {
2    public static int subsequencePairCount(int[] arr) {
3		return bottomUp(arr);
4
5	}
6	static int MOD = (int)1e9 + 7;
7	
8	public static int bottomUp(int[] arr) {
9		
10        int maxVal = 0;
11
12        int n = arr.length;
13        for(int x:arr){
14            maxVal = Math.max(x,maxVal);
15        }
16
17        int[][][] dp = new int[arr.length + 1][maxVal+1][maxVal+1];
18		
19		
20		// Base case
21		for(int seqa = 0; seqa<=maxVal;seqa++) {
22			for(int seqb = 0; seqb<=maxVal; seqb++) {
23				boolean notNull = (seqa!=0 && seqb!=0);
24				boolean equal = (seqa==seqb);
25				if(notNull && equal) {
26					dp[n][seqa][seqb] = 1;
27				}else {
28					dp[n][seqa][seqb] = 0;
29				}
30			}
31			
32		}
33
34		for (int idx = arr.length - 1; idx >= 0; idx--) {
35			
36			for (int seqa = maxVal; seqa >= 0; seqa--) {
37				for (int seqb = maxVal; seqb >=0; seqb--) {
38					
39					int skip = dp[idx+1][seqa][seqb];
40					int takea = dp[idx+1][gcd(seqa,arr[idx])][seqb];
41					int takeb = dp[idx+1][seqa][gcd(seqb,arr[idx])];
42					
43					long ans = (long) skip + takea + takeb;
44					
45					dp[idx][seqa][seqb] = (int)(ans%MOD);
46					
47				}
48			}
49		}
50		
51		return dp[0][0][0];
52	}
53	
54	private static int gcd(int a, int b) {
55        while (b != 0) {
56            int t = a % b;
57            a = b;
58            b = t;
59        }
60        return a;
61    }
62}