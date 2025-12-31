// Last updated: 31/12/2025, 8:26:44 pm
1class Solution {
2    public int numSubarrayProductLessThanK(int[] nums, int k) {
3        return countSubarray(nums,k);
4    }
5    public int countSubarray(int[] arr, int k){
6        long mul = 1;
7        int st = 0;
8        int ans = 0;
9        for(int ed = 0;ed<arr.length;ed++){
10            mul =(long)(mul*arr[ed]);
11            if(mul>=k){
12                while(mul>=k && st< ed){
13                    mul = mul/arr[st];
14                    st++;
15                }
16            }
17            if(mul<k){
18                ans += ed-st+1;
19
20            }
21
22        }
23        return ans;
24    }
25}