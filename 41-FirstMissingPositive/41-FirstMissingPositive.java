// Last updated: 4/8/2025, 12:01:33 am
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n+1];
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0&&nums[i]<=n)
            ans[nums[i]]=1;
        }
        for(int i=1;i<=n;i++)
        {
            if(ans[i]==0)
            return i;
        }
        if(n==1&&(nums[0]==1||nums[0]==0))
        return nums[0]+1;
        return n+1;
    }
}