// Last updated: 28/6/2026, 4:11:12 pm
1class Solution {
2    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
3        Arrays.sort(arr);
4        int n = arr.length;
5        int curr = 1;
6        for(int i=1;i<arr.length;i++){
7            if(arr[i]<curr){
8                curr=arr[i];
9            }else if(arr[i]>curr){
10                curr++;
11            }
12        }
13        return curr;
14    }
15}