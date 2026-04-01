// Last updated: 1/4/2026, 12:24:51 pm
1class Solution {
2    public int findTargetSumWays(int[] nums, int target) {
3        return sum(nums,0,target,0,0);
4    }
5    public static int sum(int[] arr,int sum,int target,int idx,int count){
6        if(target ==sum && idx==arr.length){
7            return 1;
8        }
9        if(idx==arr.length)return 0;
10            int x = sum(arr,sum+arr[idx],target,idx+1,count);
11            int y = sum(arr,sum-arr[idx],target,idx+1,count);
12            return x+y;
13
14        
15      
16    }
17
18}