// Last updated: 27/7/2026, 11:42:36 am
class Solution {
    public long maxTotalValue(int[] arr, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length;i++){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }

        long ans = (long) k* (max-min);
        return ans;
        
    }
}