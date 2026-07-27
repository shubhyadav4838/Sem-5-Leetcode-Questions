// Last updated: 27/7/2026, 11:42:37 am
class Solution {
    public int longestSubarray(int[] nums) {
        return fibo(nums);
    }
    public static int fibo(int[] arr) {
		int ans = 2;
		int len = 2;
		for(int i=0;i<arr.length-2;i++) {
			if(arr[i]+arr[i+1]==arr[i+2])len++;
			else {
				len = 2;
			}
			ans = Math.max(ans, len);
		}
		return ans;
	}

}