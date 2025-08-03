// Last updated: 3/8/2025, 11:57:30 pm
class Solution {
    public int arrayPairSum(int[] nums) {
        int sum=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i+=2){
            sum+=nums[i];
        }
        
        return sum;
    }
}