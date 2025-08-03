// Last updated: 3/8/2025, 11:57:59 pm
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n];
        int top = -1;
        int second = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {

            if (nums[i] < second) return true;

            while (top >= 0 && nums[i] > stack[top]) {
                second = stack[top--];
            }

            stack[++top] = nums[i];
        }

        return false;
    }
}