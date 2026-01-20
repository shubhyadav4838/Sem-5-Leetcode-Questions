// Last updated: 20/1/2026, 7:44:28 pm
class Solution {
    public long minMaxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k <= 0) return 0L;

        int[] LMax = new int[n];
        int[] RMax = new int[n];
        int[] LMin = new int[n];
        int[] RMin = new int[n];

        int[] st1 = new int[n];
        int[] st2 = new int[n];
        int top1 = -1, top2 = -1;

        // Left spans
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            while (top1 >= 0 && nums[st1[top1]] <= v) top1--;
            LMax[i] = i - (top1 >= 0 ? st1[top1] : -1);
            st1[++top1] = i;

            while (top2 >= 0 && nums[st2[top2]] >= v) top2--;
            LMin[i] = i - (top2 >= 0 ? st2[top2] : -1);
            st2[++top2] = i;
        }

        // Right spans
        top1 = top2 = -1;
        for (int i = n - 1; i >= 0; i--) {
            int v = nums[i];
            while (top1 >= 0 && nums[st1[top1]] < v) top1--;
            RMax[i] = (top1 >= 0 ? st1[top1] : n) - i;
            st1[++top1] = i;

            while (top2 >= 0 && nums[st2[top2]] > v) top2--;
            RMin[i] = (top2 >= 0 ? st2[top2] : n) - i;
            st2[++top2] = i;
        }

        long ans = 0L;
        for (int i = 0; i < n; i++) {
            long val = nums[i];
            long cntMax = qwe(LMax[i], RMax[i], k);
            long cntMin = qwe(LMin[i], RMin[i], k);
            ans += val * (cntMax + cntMin);
        }
        return ans;
    }

    public long qwe(long L, long R, int k) {
        if (L <= 0 || R <= 0 || k <= 0) return 0L;

        long t = k;
        long maxAll = L + R - 1;
        if (t >= maxAll) return L * R;

        long A = t + 1 - R;
        if (A < 0) A = 0;
        if (A > L) A = L;

        long L2 = (L < t) ? L : t;
        long count = L2 - A;

        long total = R * A;
        if (count > 0) {
            total += count * (2 * t + 1 - A - L2) / 2;
        }
        return total;
    }
}