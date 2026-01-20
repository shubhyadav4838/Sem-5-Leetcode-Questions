// Last updated: 20/1/2026, 2:53:36 pm
class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int i=0;
        int j=0;
        int maxSize = 0;
        while(j<n){
            while((long)nums[i]*k < (long)nums[j]){
                i++;
            }
            maxSize = Math.max(maxSize,j-i+1);
            j++;
        }
        return n-maxSize;
    }
}