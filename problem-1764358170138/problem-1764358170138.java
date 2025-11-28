// Last updated: 29/11/2025, 12:59:30 am
1class Solution {
2    public int numSubarraysWithSum(int[] nums, int goal) {
3        return maxSumSubarray(nums,goal);
4    }
5    public static int maxSumSubarray(int[] arr, int k){
6        HashMap<Integer,Integer> map = new HashMap<>();
7        map.put(0,1);
8        int prefix = 0;
9        int count = 0;
10        for(int i=0;i<arr.length;i++){
11            prefix += arr[i];
12            if(map.containsKey(prefix-k)){
13                count+=map.get(prefix-k);
14            }
15            map.put(prefix,map.getOrDefault(prefix,0)+1);
16        }
17        return count;
18    }
19}