// Last updated: 3/8/2025, 11:58:57 pm
class Solution {
    public int lengthOfLIS(int[] nums) {
        return LongestSequence(nums);
    }
    public static int LongestSequence(int[]arr) {
		int []ans = new int[arr.length];
		int res = 0;
		for(int i=0; i<arr.length; i++) {
			ans[i] = 1;
		}
		for(int i=1; i<arr.length; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i]>arr[j]) {
					int to_store=ans[j]+1;;
					if(ans[i]<=to_store) {
						ans[i] = to_store;
					}
					
				}
				
			}
		}
		for(int x: ans) {
			if(res<x) {
				res = x;
			}
		}
		return res;
		
	}
}