// Last updated: 23/8/2025, 6:59:11 pm
class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        long[] absVals = new long[n];
        long[] original = new long[n];
        for (int i = 0; i < n; i++) {
            absVals[i] = Math.abs((long) nums[i]);
            original[i] = nums[i];
        }

        Arrays.sort(absVals);

        long ans = 0;
        int r = 0;
        for (int l = 0; l < n; l++) {
            if (r < l + 1) r = l + 1;
            while (r < n && absVals[r] <= 2 * absVals[l]) r++;
            ans += (r - l - 1);
        }

        return ans;
    }
}