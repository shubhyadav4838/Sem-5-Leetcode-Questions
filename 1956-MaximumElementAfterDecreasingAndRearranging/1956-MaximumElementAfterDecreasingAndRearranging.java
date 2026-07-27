// Last updated: 27/7/2026, 11:44:47 am
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int curr = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<curr){
                curr=arr[i];
            }else if(arr[i]>curr){
                curr++;
            }
        }
        return curr;
    }
}