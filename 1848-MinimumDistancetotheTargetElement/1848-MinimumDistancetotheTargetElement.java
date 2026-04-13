// Last updated: 13/4/2026, 3:30:01 pm
1class Solution {
2    public int getMinDistance(int[] nums, int target, int start) {
3        int ans = nums.length;
4        for(int i = 0; i<nums.length; i++){
5            if(nums[i] == target){
6                ans = Math.min(Math.abs(i-start),ans);
7            }
8        }
9        return ans;
10        
11    }
12}