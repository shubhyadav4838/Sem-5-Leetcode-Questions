// Last updated: 3/8/2025, 11:58:00 pm
class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++ ){
            if(min>nums[i]){
                min = nums[i];
            }
        }
        int steps = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>min){
                steps+=nums[i]-min;
                nums[i]=min;
            }
        }
        return steps;
        
    }
}