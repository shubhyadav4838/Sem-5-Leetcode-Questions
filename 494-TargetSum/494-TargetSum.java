// Last updated: 3/8/2025, 11:57:47 pm
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return sum(nums,0,target,0,0);
    }
    public static int sum(int[] arr,int sum,int target,int idx,int count){
        if(target ==sum && idx==arr.length){
            return 1;
        }
        if(idx==arr.length)return 0;
            int x = sum(arr,sum+arr[idx],target,idx+1,count);
            int y = sum(arr,sum-arr[idx],target,idx+1,count);
            return x+y;

        
      
    }

}