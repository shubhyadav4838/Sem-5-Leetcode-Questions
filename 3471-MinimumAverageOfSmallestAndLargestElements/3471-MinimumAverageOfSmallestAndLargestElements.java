// Last updated: 3/8/2025, 11:53:26 pm
class Solution {
    public double minimumAverage(int[] nums) {
        return CalculateAverage(nums);
    }
    public double CalculateAverage(int[]nums){
        // double [] arr = new double[nums.length/2];
        double ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        while(i<j){
            double avg = (double)(nums[i]+nums[j])/2;
            ans = Math.min(ans,avg);
            i++;
            j--;
           

        }
        return ans;
    }
}