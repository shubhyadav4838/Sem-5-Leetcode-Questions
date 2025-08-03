// Last updated: 3/8/2025, 11:53:15 pm
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        
        int n = nums.size();
        int ans= Integer.MAX_VALUE;

        for(int len=l;len<=r;len++) {
            int sum = 0;
            for(int i=0;i<n;i++) {
                sum += nums.get(i);
                if(i+1 >= len) {
                    if(sum > 0) {
                        ans = Math.min(ans, sum);
                    }
                    sum -= nums.get(i-len+1);
                }
            }
        }

        if(ans == Integer.MAX_VALUE) {
            return -1;
        }

        return ans;
    }
}