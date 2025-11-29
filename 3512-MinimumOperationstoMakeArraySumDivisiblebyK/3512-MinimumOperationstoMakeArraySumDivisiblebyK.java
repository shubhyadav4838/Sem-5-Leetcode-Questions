// Last updated: 30/11/2025, 12:05:40 am
1class Solution {
2    public int minOperations(int[] nums, int k) {
3        return operation(nums,k);
4    }
5    public static int operation(int[] arr, int k){
6        int sum = 0;
7        for(int i=0;i<arr.length;i++){
8            sum+=arr[i];
9        }
10        return sum%k;
11    }
12}