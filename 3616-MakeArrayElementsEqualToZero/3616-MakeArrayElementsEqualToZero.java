// Last updated: 3/8/2025, 11:53:23 pm
class Solution {
    public int countValidSelections(int[] nums) {
        int count = 0;
        int sum = 0;
        int cursum = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        for(int i = 0; i<nums.length; i++){
            cursum+=nums[i];
            if(nums[i]==0){
                if(2*cursum-sum==0){
                    count+=2;
                }else if(2*cursum-sum==1 || 2*cursum-sum==-1 ){
                    count+=1;
                }
            }
        }
        return count;
        
    }
}