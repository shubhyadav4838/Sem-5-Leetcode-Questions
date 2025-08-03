// Last updated: 3/8/2025, 11:56:32 pm
class Solution {
    public int longestMountain(int[] arr) {
        return LongestSubarray(arr);
    }

    public static int LongestSubarray(int[] mount) {
        if (mount.length < 3) {
            return 0;
        }
        int i = 0, ans = 0;

        while (i < mount.length - 1) {
            if (i > 0 && mount[i - 1] < mount[i] && mount[i] > mount[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                while (left > 0 && mount[left - 1] < mount[left]) {
                    left--;
                }

                while (right < mount.length - 1 && mount[right] > mount[right + 1]) {
                    right++;
                }

                int currentLength = right - left + 1;
                ans = Math.max(ans, currentLength);

                i = right;
            } else {
                i++;
            }
        }

        return ans;
    }

}
