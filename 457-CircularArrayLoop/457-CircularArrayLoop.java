// Last updated: 3/8/2025, 11:57:57 pm
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;

            int slow = i, fast = nextIndex(nums, i);
            
            while (nums[i] * nums[fast] > 0 && nums[i] * nums[nextIndex(nums, fast)] > 0) {
                if (slow == fast) {
                 
                    if (slow == nextIndex(nums, slow)) break;
                    return true;
                }
                slow = nextIndex(nums, slow);
                fast = nextIndex(nums, nextIndex(nums, fast));
            }

            int val = nums[i];
            int idx = i;
            while (val * nums[idx] > 0) {
                int next = nextIndex(nums, idx);
                nums[idx] = 0;
                idx = next;
            }
        }

        return false;
    }

    private int nextIndex(int[] nums, int i) {
        int n = nums.length;
        return ((i + nums[i]) % n + n) % n;
    }
}
