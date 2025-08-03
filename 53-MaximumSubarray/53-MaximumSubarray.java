// Last updated: 4/8/2025, 12:01:18 am
class Solution {
    public int maxSubArray(int[] nums) {
        return MaxSum(nums);
    }
    public int MaxSum(int[]arr){
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            ans = Math.max(ans,sum);
            if(sum<0){
                sum=0;
            }
        }
        return ans;
    }
}