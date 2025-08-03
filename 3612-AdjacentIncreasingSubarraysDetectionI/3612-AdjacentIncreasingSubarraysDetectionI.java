// Last updated: 3/8/2025, 11:53:24 pm
import java.util.List;
class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if (nums.size() < 2 * k) {
            return false;
        }
        for (int i = 0; i <= nums.size() - 2 * k; i++) {
            boolean firstSubarrayIncreasing = true;
            for (int j = i; j < i + k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    firstSubarrayIncreasing = false;
                    break;
                }
            }
            boolean secondSubarrayIncreasing = true;
            for (int j = i + k; j < i + 2 * k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    secondSubarrayIncreasing = false;
                    break;
                }
            }
            if (firstSubarrayIncreasing && secondSubarrayIncreasing) {
                return true;
            }
        }
        return false;
    }
}