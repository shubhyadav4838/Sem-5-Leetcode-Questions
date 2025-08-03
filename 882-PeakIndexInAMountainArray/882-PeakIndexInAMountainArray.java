// Last updated: 3/8/2025, 11:56:28 pm
class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int left=0;
	    int right=nums.length-1;

        while(left<right) {
            int mid=(left+right)/2;
            if (nums[mid]>nums[mid+1]) {
                right=mid;
            } 
	    else {
                left=mid+1;
            }
        }

        return left;
        
    }
}