// Last updated: 3/8/2025, 11:55:17 pm
class Solution {
    public int[] decompressRLElist(int[] nums) {
        // Step 1: Calculate total length of result array
        int count = 0;
        for (int i = 0; i < nums.length; i += 2) {
            count += nums[i]; // nums[i] is frequency
        }

        // Step 2: Initialize result array
        int[] arr = new int[count];
        int j = 0;

        // Step 3: Decompress using while loop
        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];

            while (freq != 0) {
                arr[j++] = val;
                freq--;
            }
        }

        return arr;
    }
}