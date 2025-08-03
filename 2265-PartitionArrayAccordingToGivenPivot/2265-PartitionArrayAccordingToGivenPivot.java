// Last updated: 3/8/2025, 11:54:01 pm
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int equal = 0;
        int max = 0;
        for(int x:nums){
            if(x==pivot)equal++;
            else if(x>pivot)max++;
        }
        int small = 0;
        equal = nums.length-equal-max;
        max = nums.length-max;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                res[small] = nums[i];
                small++;
            }else if(nums[i]==pivot){
                res[equal]=nums[i];
                equal++;
            }else{
                res[max] = nums[i];
                max++;
            }
        }
        return res;

        
    }
}