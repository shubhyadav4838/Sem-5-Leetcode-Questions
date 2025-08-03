// Last updated: 4/8/2025, 12:01:42 am
class Solution {
    public int searchInsert(int[] nums, int target) {
        return SearchPosition(nums, target);
    }
    public int SearchPosition(int[]arr, int target){
        int lo = 0;
        int hi = arr.length-1;
        int ans = 0;
        boolean val = true;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(arr[mid]==target){
                return mid;
            
            }else if(arr[mid]>target){
                hi= mid-1;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }
}