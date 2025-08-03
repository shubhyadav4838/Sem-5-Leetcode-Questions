// Last updated: 4/8/2025, 12:00:42 am
class Solution {
    public boolean search(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            if(nums[i]==target){
                return true;
            }
        }
        return false;
        
    }
}