// Last updated: 11/10/2025, 12:30:44 am
class Solution {
    public int wiggleMaxLength(int[] arr) {
        if(arr.length==1)return 1;
    	int[] dp = new int[arr.length];
    	Arrays.fill(dp,-1);
        int i=0;
        while(i<arr.length-1 && arr[i]==arr[i+1])i++;
    	
        return wiggle(0,i,1,arr,dp);
        
    }
   public static int wiggle(int diff, int i, int len, int[] arr, int[] dp) {
		while (i < arr.length - 1 && arr[i] == arr[i + 1])
			i++;
		if (i >= arr.length - 1) {
			return dp[i] = len;

		}
		int a = 0;
		int b = 0;

		if (dp[i] != -1) {
			return dp[i];
		}

		if (diff <= 0 && arr[i + 1] > arr[i]) {
			a = wiggle(arr[i + 1] - arr[i], i + 1, len + 1, arr, dp);
		}
		
		if (diff >= 0 && arr[i + 1] < arr[i]) {
			a = Math.max(a, wiggle(arr[i + 1] - arr[i], i + 1, len + 1, arr, dp));
		}
		b = wiggle(diff, i + 1, len, arr, dp);

		return dp[i] = Math.max(a, b);
	}
}