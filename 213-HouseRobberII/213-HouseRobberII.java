// Last updated: 6/1/2026, 2:11:23 pm
1class Solution {
2    public int rob(int[] nums) {
3        if(nums.length==1){
4            return nums[0];
5        }
6        int a = robHouse(nums,0,nums.length-2);
7        int b = robHouse(nums,1,nums.length-1);
8        return Math.max(a,b);
9        
10    }
11    public static int robHouse(int[] nums, int si, int ei){
12        int ans = 0;
13        int pre = 0;
14        for(int i = si;i<=ei;i++){
15            int temp = Math.max(ans,pre+nums[i]);
16            pre = ans;
17            ans = temp;
18        }
19        return ans;
20    }
21}