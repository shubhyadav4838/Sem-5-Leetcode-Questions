// Last updated: 3/8/2025, 11:59:44 pm
class Solution {
    public int rob(int[] nums) {
        int prev = 0;
        int ans = 0;
        for (int i : nums) {
            int temp = Math.max(ans, prev + i);
            prev = ans;
            ans = temp;
        }
        return ans;        
    }
}