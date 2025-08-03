// Last updated: 3/8/2025, 11:56:14 pm
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        return maxSum(nums);
    }
    public int maxSum(int[]arr){
        int tsum=0;
        int max_sum=Integer.MIN_VALUE, temp_max_sum=0;
        int min_sum = Integer.MAX_VALUE ,temp_min_sum=0;
        for(int i=0; i<arr.length; i++){
            tsum+=arr[i];

            temp_max_sum+=arr[i];
            max_sum=Math.max(max_sum,temp_max_sum);
            if(temp_max_sum<0){
                temp_max_sum=0;
            }

            temp_min_sum+=arr[i];
            min_sum=Math.min(min_sum,temp_min_sum);
            if(temp_min_sum>0){
                temp_min_sum=0;
            }

        }
        if(tsum==min_sum){
            return max_sum;
        }
        return Math.max(max_sum,tsum-min_sum);

    }
}