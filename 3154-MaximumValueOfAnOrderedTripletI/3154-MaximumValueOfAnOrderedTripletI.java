// Last updated: 3/8/2025, 11:53:39 pm
class Solution {
    public long maximumTripletValue(int[] nums) {
       return findTriplet(nums); 
    }
    public static long findTriplet(int[]arr) {
		long maxTriplet = 0;
		long dif = 0;
		long leftMax = 0;
		for (int i = 0; i < arr.length; i++) {
			maxTriplet=Math.max(maxTriplet, dif*arr[i]);
			dif = Math.max(dif, leftMax-arr[i]);
			leftMax = Math.max(leftMax, arr[i]);
		}
		return maxTriplet;
	}
}