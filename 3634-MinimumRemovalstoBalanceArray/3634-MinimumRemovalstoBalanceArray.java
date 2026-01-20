// Last updated: 20/1/2026, 2:44:33 pm
class Solution {
    public int minRemoval(int[] nums, int k) {

        if(nums.length == 1) return 0;

        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;

        int l = 0;
        for(int i = 1; i < nums.length; i++){
            while(1L * nums[l] * k < nums[i]){
                l++;
            }
            res = Math.min(res, nums.length - (i - l + 1));
        }

        return res;
    }
}