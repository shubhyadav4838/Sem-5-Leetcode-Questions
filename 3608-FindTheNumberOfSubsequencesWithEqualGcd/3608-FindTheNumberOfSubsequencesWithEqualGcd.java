// Last updated: 27/7/2026, 11:43:16 am
class Solution {
    public static int subsequencePairCount(int[] arr) {
		return bottomUp(arr);

	}
	static int MOD = (int)1e9 + 7;
	
	public static int bottomUp(int[] arr) {
		
        int maxVal = 0;

        int n = arr.length;
        for(int x:arr){
            maxVal = Math.max(x,maxVal);
        }

        int[][][] dp = new int[arr.length + 1][maxVal+1][maxVal+1];
		
		
		// Base case
		for(int seqa = 0; seqa<=maxVal;seqa++) {
			for(int seqb = 0; seqb<=maxVal; seqb++) {
				boolean notNull = (seqa!=0 && seqb!=0);
				boolean equal = (seqa==seqb);
				if(notNull && equal) {
					dp[n][seqa][seqb] = 1;
				}else {
					dp[n][seqa][seqb] = 0;
				}
			}
			
		}

		for (int idx = arr.length - 1; idx >= 0; idx--) {
			
			for (int seqa = maxVal; seqa >= 0; seqa--) {
				for (int seqb = maxVal; seqb >=0; seqb--) {
					
					int skip = dp[idx+1][seqa][seqb];
					int takea = dp[idx+1][gcd(seqa,arr[idx])][seqb];
					int takeb = dp[idx+1][seqa][gcd(seqb,arr[idx])];
					
					long ans = (long) skip + takea + takeb;
					
					dp[idx][seqa][seqb] = (int)(ans%MOD);
					
				}
			}
		}
		
		return dp[0][0][0];
	}
	
	private static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}