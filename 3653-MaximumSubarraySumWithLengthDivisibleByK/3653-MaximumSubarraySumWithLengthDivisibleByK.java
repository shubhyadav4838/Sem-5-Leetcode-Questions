// Last updated: 27/7/2026, 11:43:11 am
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        return maxSum(nums,k);
        
    }
    public static long maxSum(int[] arr, int k) {
        long[] pre = new long[arr.length];
        long[] sub = new long[k];
        pre[0] = arr[0];
        for(int i=1;i<arr.length;i++) {
        	pre[i] = arr[i]+pre[i-1];
        }
        long ans = Long.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
        	long val = pre[i]- sub[(i+1)%k];
            if(i+1>=k){
        	    ans = Math.max(ans, val);

        	    sub[(i+1)%k] = Math.min(sub[(i+1)%k],pre[i]);
            }else {
            	sub[(i+1)%k] = pre[i];
            }
            
        }
        return ans;
        
        
    }
}