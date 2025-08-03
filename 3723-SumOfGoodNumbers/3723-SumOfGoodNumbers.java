// Last updated: 3/8/2025, 11:53:03 pm
class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        return sum(nums, k);
    }
    public static int sum(int[] arr, int k){
        int ans = 0;
        for(int i=0;i<arr.length;i++){
           
            if(i-k>= 0 && arr[i]<=arr[i-k]){
                continue;
            }else if(i+k<arr.length && arr[i]<=arr[i+k]){
                continue;
            }
            ans+=arr[i];
        }
        return ans;
    }
}