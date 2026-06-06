// Last updated: 6/6/2026, 11:57:01 pm
1class Solution {
2    public int[] leftRightDifference(int[] nums) {
3        int rightSum = 0;
4
5        for (int num : nums) {
6            rightSum += num;
7        }
8
9        int leftSum = 0;
10        int[] result = new int[nums.length];
11
12        for (int i = 0; i < nums.length; i++) {
13            rightSum -= nums[i];
14            result[i] = Math.abs(leftSum - rightSum);
15            leftSum += nums[i];
16        }
17
18        return result;
19    }
20}