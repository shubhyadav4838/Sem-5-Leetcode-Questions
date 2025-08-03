// Last updated: 4/8/2025, 12:00:14 am
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i : nums) ans^=i;
        return ans;
    }
}