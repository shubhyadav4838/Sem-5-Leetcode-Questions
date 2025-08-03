// Last updated: 3/8/2025, 11:57:56 pm
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n=nums[(nums.length)/2];
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<n)sum+=n-nums[i];
            else sum+= nums[i]-n;
        }
        return sum;

        
    }
}