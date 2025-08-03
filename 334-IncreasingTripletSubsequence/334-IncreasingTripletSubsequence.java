// Last updated: 3/8/2025, 11:58:52 pm
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int i=Integer.MAX_VALUE;
        int j=Integer.MAX_VALUE;
        for(int idx=0;idx<nums.length;idx++){
           int cur = nums[idx];
           if(cur>j)return true;
           else if(cur<i)i=cur;
           else if(cur>i && cur<j)j=cur;
        }
        return false;
    }
}