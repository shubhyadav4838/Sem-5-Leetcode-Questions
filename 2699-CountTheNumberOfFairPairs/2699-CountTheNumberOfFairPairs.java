// Last updated: 3/8/2025, 11:53:49 pm
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        return fairGap(nums,lower,upper);
    }
    public static long fairGap(int[] arr, int lower, int upper) {
		Arrays.sort(arr);
		long count=0;
		int left = 0;
		int right = arr.length-1;
		while(left<arr.length-1 && arr[left]<lower-arr[0])left++;
		for (int i = 0; i < arr.length; i++) {
			int lo = lower-arr[i];
			int hi= upper-arr[i];
			while(left>=0 && arr[left]>=lo) {
				left--;
			}
			while(right>=0 && arr[right]>hi) {
				right--;
			}
			if(left>right)break;
			if(right<i)break;
			if(left<i) {
				count+=right-i;
			}
			else {
				count+=right-left;
			}
		}
		return count;
		
	}
}