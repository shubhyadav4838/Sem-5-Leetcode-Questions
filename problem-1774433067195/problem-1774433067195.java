// Last updated: 25/3/2026, 3:34:27 pm
1class Solution {
2    public int minMoves2(int[] nums) {
3        Arrays.sort(nums);
4        int n=nums[(nums.length)/2];
5        int sum = 0;
6        for(int i=0;i<nums.length;i++){
7            if(nums[i]<n)sum+=n-nums[i];
8            else sum+= nums[i]-n;
9        }
10        return sum;
11
12        
13    }
14}