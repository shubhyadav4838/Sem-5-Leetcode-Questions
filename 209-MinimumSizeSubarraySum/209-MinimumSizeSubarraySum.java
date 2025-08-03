// Last updated: 3/8/2025, 11:59:38 pm
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        return minimalLen(nums,target);
    }
    public static int minimalLen(int[] arr, int target) {
		int len = Integer.MAX_VALUE;
		int i=0;
		int j=0;
		int sum=arr[0];
		while(j<arr.length && i<=j) {
			if(sum==target) {
				len=Math.min(len,j-i+1);
				j++;
				if(j<arr.length)sum+=arr[j];
			}else if(sum<target) {
				j++;
				if(j<arr.length)sum+=arr[j];
			}else {
				len=Math.min(len, j-i+1);
				sum-=arr[i];
				i++;
			}
		}
		if(len==Integer.MAX_VALUE) return 0;
		return len;
	}
}