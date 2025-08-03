// Last updated: 3/8/2025, 11:54:56 pm
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr=new int[nums.length];
        int j=0;
        for(int i=0;i<n;i++){
            arr[j++]=nums[i];
            arr[j++]=nums[i+n];
        }
        return arr;
    }

}

