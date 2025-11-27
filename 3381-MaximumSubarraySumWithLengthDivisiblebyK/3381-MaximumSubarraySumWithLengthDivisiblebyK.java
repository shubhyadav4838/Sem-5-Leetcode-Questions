// Last updated: 28/11/2025, 12:26:57 am
1class Solution {
2    public long maxSubarraySum(int[] nums, int k) {
3        return maxSum(nums,k);
4        
5    }
6    public static long maxSum(int[] arr, int k) {
7        long[] pre = new long[arr.length];
8        long[] sub = new long[k];
9        pre[0] = arr[0];
10        for(int i=1;i<arr.length;i++) {
11        	pre[i] = arr[i]+pre[i-1];
12        }
13        long ans = Long.MIN_VALUE;
14        for(int i=0;i<arr.length;i++) {
15        	long val = pre[i]- sub[(i+1)%k];
16            if(i+1>=k){
17        	    ans = Math.max(ans, val);
18
19        	    sub[(i+1)%k] = Math.min(sub[(i+1)%k],pre[i]);
20            }else {
21            	sub[(i+1)%k] = pre[i];
22            }
23            
24        }
25        return ans;
26        
27        
28    }
29}