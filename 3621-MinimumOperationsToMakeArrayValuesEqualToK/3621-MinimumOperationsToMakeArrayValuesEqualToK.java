// Last updated: 3/8/2025, 11:53:21 pm
class Solution {
    public int minOperations(int[] nums, int k) {
        return Operation(nums,k);
    }
    public int Operation(int[]arr, int k){
        Arrays.sort(arr);
        if(k>arr[0]){
            return -1;
        }
        int p = arr[0];
        int count = 1;
        for(int i=1; i<arr.length;i++){
            if(p!=arr[i]){
                p=arr[i];
                count++;
            }
        }
        if(arr[0]==k){
            return count-1;     
        }
        return count;
    }
}