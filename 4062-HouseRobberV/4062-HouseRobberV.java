// Last updated: 27/7/2026, 11:42:27 am
class Solution {
    public static long rob(int[] arr, int[] colors) {
        long ans = 0;

        long pre = 0;
        for (int i = 0; i < arr.length; i++) {
            long temp = 0;
            if (i > 0 && colors[i] == colors[i - 1]) {
                temp = pre + arr[i];
            } else {
                temp = Math.max(pre + arr[i], ans + arr[i]);
            }
            pre = Math.max(pre, ans);
            ans = Math.max(ans, temp);
        }
        return ans;

    }
}