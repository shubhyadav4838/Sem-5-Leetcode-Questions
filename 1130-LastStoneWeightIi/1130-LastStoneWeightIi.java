// Last updated: 27/7/2026, 11:46:16 am
class Solution {
   public static int lastStoneWeightII(int[] arr) {
		int sum = 0;
		for(int x :arr) {
			sum += x;
		}
		
		int target = sum/2;
		int n = arr.length;
		
		int[] onedp = new int[target+1];
		for(int idx = n-1; idx>=0; idx--) {
			int[] curr = new int[target+1];
			for(int j = 1; j<=target; j++) {
				
				int a = 0;
				if(arr[idx]<=j) {
					a = arr[idx] + onedp[j-arr[idx]];
				}
				int b = onedp[j];
				
				curr[j] = Math.max(a, b);
			}
			onedp = curr;
		}
		
		int ans = onedp[target];
		return sum-(2*ans);

	}
}