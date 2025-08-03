// Last updated: 4/8/2025, 12:02:32 am
class Solution {
    public int[] twoSum(int[] nums, int target) {
        return FindIdx(nums, target);
    }
    public int[] FindIdx(int[] nums, int target){
        int[]arr = new int[nums.length];
        for(int i=0; i<nums.length;i++){
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        int []ans = new int[2];
        while(i<j){
            int sum= arr[i]+arr[j];
            if(sum==target){
                i=arr[i];
                j=arr[j];
                break;
            }
            else if(sum>target){
                j--;
            }else{
                i++;
            }
        }
        // System.out.print(i+" "+j);
        int count=0;
        for(int k=0; k<nums.length; k++){
            if(i==nums[k]){
                ans[0] = k;
                break;
            }
        }
        for(int k=nums.length-1;k>=0;k--){
            if(j==nums[k]){
                ans[1]=k;
                break;
            }
        }
        return ans;
    }
}