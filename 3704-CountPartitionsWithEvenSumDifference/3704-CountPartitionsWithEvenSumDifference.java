// Last updated: 3/8/2025, 11:53:09 pm
class Solution {
    public int countPartitions(int[] nums) {
        int s=0;
        int lsum=0;
        int c=0;
        for(int k:nums){
            s+=k;
        }
        for(int i=0;i<nums.length-1;i++){
            lsum+=nums[i];
            int rsum=s-lsum;
            if((lsum-rsum)%2==0){
                c++;
            }
        }
        return c;
    }
}