You are given an integer array nums and a positive integer k. Return the sum of the maximum and minimum elements of all subarrays with at most k elements.

 
Example 1:


Input: nums = [1,2,3], k = 2

Output: 20

Explanation:

The subarrays of nums with at most 2 elements are:

SubarrayMinimumMaximumSum[1]112[2]224[3]336[1, 2]123[2, 3]235Final Total  20

The output would be 20.


Example 2:


Input: nums = [1,-3,1], k = 2

Output: -6

Explanation:

The subarrays of nums with at most 2 elements are:

SubarrayMinimumMaximumSum[1]112[-3]-3-3-6[1]112[1, -3]-31-2[-3, 1]-31-2Final Total  -6

The output would be -6.


 
Constraints:


	1 <= nums.length <= 80000
	1 <= k <= nums.length
	-106 <= nums[i] <= 106

