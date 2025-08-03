// Last updated: 3/8/2025, 11:53:32 pm
class Solution {
    public String triangleType(int[] nums) {
        // Arrays.sort(nums);
        if(nums[0]+nums[1]<=nums[2] || nums[1]+nums[2]<=nums[0] || nums[0]+nums[2]<=nums[1]) return "none";
        if(nums[0]==nums[1] && nums[0]==nums[2]){
            return "equilateral";
        }else if(nums[0]==nums[1] || nums[0]==nums[2] || nums[1]==nums[2]){
            return "isosceles";
        }else{
            return "scalene";

        }
    }
}