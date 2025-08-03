// Last updated: 3/8/2025, 11:57:26 pm
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int start = nums.length;
        int end = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
        }

        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] > min) {
                start = i;
            } else {
                min = nums[i];
            }
        }

        return end - start >= 0 ? end - start + 1 : 0;
    }
}