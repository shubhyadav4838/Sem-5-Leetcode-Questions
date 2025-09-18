// Last updated: 19/9/2025, 12:03:39 am
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 0;
        }

        return recursiveSearch(nums, 0);
    }

    // search, at track the index
    

    // [4,1,1,3,1,1,1]
    // 
    public int recursiveSearch(int[] nums, int currentIndex) {
        // find the max step possible
        if (nums[currentIndex] == 0) {
            return Integer.MIN_VALUE;
        }

        if (currentIndex == nums.length - 1) {
            return 0;
        }

        // exit case
        if (currentIndex + nums[currentIndex] >= nums.length - 1) {
            return 1; // 1 more jump
        }

        // case where current index = 0
        int maxIndex = currentIndex;
        int maxJump = 0;
        for (int index = currentIndex + 1; index <= currentIndex + nums[currentIndex]; index++) {

            // store next
            if (index + nums[index] >= maxJump) {
                maxIndex = index;
                maxJump = index + nums[index];
            }
        }

        // jumping
        return 1 + recursiveSearch(nums, maxIndex);
    }
}
