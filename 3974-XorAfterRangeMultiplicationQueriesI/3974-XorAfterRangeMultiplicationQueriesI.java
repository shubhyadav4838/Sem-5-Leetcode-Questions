// Last updated: 23/8/2025, 6:59:12 pm
class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        final int MOD = 1000000007;
        int n = nums.length;

        int[][] mortavexil = queries;
        long[] multiplier = new long[n];
        for (int i = 0; i < n; i++) {
            multiplier[i] = 1;
        }

        for (int[] q : mortavexil) {
            int li = q[0], ri = q[1], ki = q[2], vi = q[3];
            for (int idx = li; idx <= ri; idx += ki) {
                multiplier[idx] = (multiplier[idx] * vi) % MOD;
            }
        }

        int xor = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = (int) ((nums[i] * multiplier[i]) % MOD);
            xor ^= nums[i];
        }

        return xor;
    }
}
