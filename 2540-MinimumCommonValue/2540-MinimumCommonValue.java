// Last updated: 19/5/2026, 10:02:43 am
1class Solution {
2    public int getCommon(int[] nums1, int[] nums2) {
3        HashSet<Integer> set = new HashSet<>();
4        for(int x:nums1){
5            set.add(x);
6        }
7
8        int res = Integer.MAX_VALUE;
9        for(int i = 0; i<nums2.length; i++){
10            if(set.contains(nums2[i]))res = Math.min(res,nums2[i]);
11        }
12
13        return (res==Integer.MAX_VALUE ? -1:res);
14        
15    }
16}