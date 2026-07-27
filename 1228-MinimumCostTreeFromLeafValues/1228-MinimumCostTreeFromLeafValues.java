// Last updated: 27/7/2026, 11:46:05 am
class Solution {
    static class Pair{
		int max = 0;
		int sum=0;
	}

	public static int mctFromLeafValues(int[] arr) {
        try{

        
        int n = arr.length;
        Pair[][] dp = new Pair[n][n];
		return solve(0,arr.length-1,arr,dp).sum;
        }catch (Throwable t) { // <--- CHANGED FROM Exception e
			System.out.println("CRITICAL DEBUG -> " + t.toString());
			if (t.getStackTrace().length > 0) {
				System.out.println("FAILED AT LINE: " + t.getStackTrace()[0].getLineNumber());
			}
            return 0;
		}
	}
	
	public static Pair solve(int i, int j, int[] arr,Pair[][] dp) {
		if(i>j) {
			return new Pair();
		}
		if(i==j) {
			Pair curr = new Pair();
			curr.max = arr[i];
			return curr;
			
		}
        if(dp[i][j]!=null){
            return dp[i][j];
        }
		
		Pair self = new Pair();
		int ans = Integer.MAX_VALUE;
		int max = 0;
		
		for(int k = i; k<j;k++) {
			Pair left = solve(i,k,arr,dp);
			Pair right = solve(k+1,j,arr,dp);
			
			int prod = left.max * right.max;
			int sum = left.sum+right.sum+prod;
			if(sum<ans) {
				ans = sum;
				max = Math.max(left.max, right.max);	
			}
		}
		self.sum = ans;
		self.max = max;
		return dp[i][j] = self;
	}
}