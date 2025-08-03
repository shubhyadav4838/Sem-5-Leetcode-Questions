// Last updated: 3/8/2025, 11:53:10 pm
class Solution {
    public int countSubarrays(int[] nums) {
        return CountArray(nums);
    }
    public int CountArray(int[]arr){
        int i=0;
        int j=2;
        int count = 0;
        while(j<arr.length){
            int sum = arr[i]+arr[j];
            int mid = arr[i+1];
            if(2*sum==mid){
                count++;
            }
            i++;
            j++;
        }
        return count;
    }
}