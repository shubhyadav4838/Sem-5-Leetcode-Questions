// Last updated: 9/6/2026, 11:04:11 pm
1class Solution {
2    public long maxTotalValue(int[] arr, int k) {
3        int min = Integer.MAX_VALUE;
4        int max = Integer.MIN_VALUE;
5        for(int i=0; i<arr.length;i++){
6            min = Math.min(min,arr[i]);
7            max = Math.max(max,arr[i]);
8        }
9
10        long ans = (long) k* (max-min);
11        return ans;
12        
13    }
14}