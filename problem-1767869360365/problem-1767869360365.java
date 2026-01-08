// Last updated: 8/1/2026, 4:19:20 pm
class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int left = 0;
        int result = 0;
        int[] dp = new int[prizePositions.length + 1];
        for (int right = 0; right < prizePositions.length; right++) {
            while (prizePositions[right] - prizePositions[left] > k) {
                left++;
            }
            int currentWindow = right - left + 1;
            dp[right + 1] = Math.max(dp[right], currentWindow);
            result = Math.max(result, dp[left] + currentWindow);
        }
        return result;
    }
}