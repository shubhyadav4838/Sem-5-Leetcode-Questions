// Last updated: 3/8/2025, 11:52:54 pm
class Solution {
    public int maxAdjacentDistance(int[] nums) {
        return max(nums);
    }
    public int max(int[]arr){
        int a = Math.abs(arr[arr.length-1]-arr[0]);
        int b = 0;
        for(int i=1;i<arr.length;i++){
            int t = Math.abs(arr[i]-arr[i-1]);
            b = Math.max(b,t);
        }
        return Math.max(a,b);
    }
}