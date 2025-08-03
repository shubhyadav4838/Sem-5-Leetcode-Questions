// Last updated: 3/8/2025, 11:59:36 pm
class Solution {
     public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n-k];
    }
}