// Last updated: 3/8/2025, 11:57:48 pm
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        return MaxCount(nums);
    }
    public int MaxCount(int[]arr){
        int count = 0;
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 1){
                count++;
                ans = Math.max(count,ans);
            }else{
                count = 0;
            }

        }
        return ans;
    }
}