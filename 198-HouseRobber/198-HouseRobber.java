// Last updated: 23/2/2026, 3:51:44 pm
1class Solution {
2    public int rob(int[] nums) {
3        int ans = 0;
4        int pre = 0;
5        for(int x:nums){
6            int temp = Math.max(ans,pre+x);
7            pre = ans;
8            ans = temp;
9        }
10        return ans;
11
12        
13    }
14}