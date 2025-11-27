// Last updated: 27/11/2025, 11:22:55 pm
1class Solution {
2    public int longestOnes(int[] nums, int k) {
3        return consecutive(nums,k);
4    }
5    public static int consecutive(int[] arr, int k) {
6    	int one = 0, zero = 0,left = 0;
7    	int ans = 0;
8    	for(int right = 0;right<arr.length;right++) {
9    		if(arr[right]==1) {
10    			one++;
11    		}else {
12    			zero++;
13    		}
14    		if(zero>k) {
15    			while(zero>k && left <arr.length) {
16    				if( arr[left]==0)zero--;
17    				left++;
18    			}
19    		}
20    		ans = Math.max(ans, right-left+1);
21    	}
22    	return ans;
23    }
24
25}