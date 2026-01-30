// Last updated: 30/1/2026, 10:24:26 pm
1class Solution {
2    public int[] maxSlidingWindow(int[] nums, int k) {
3        int n = nums.length;
4        if (n == 0 || k == 0) return new int[0];
5
6        int[] result = new int[n - k + 1];
7        Deque<Integer> dq = new ArrayDeque<>();
8        
9        for (int i = 0; i < n; i++) {
10            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
11                dq.pollFirst();
12            }
13
14            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
15                dq.pollLast();
16            }
17
18            dq.offerLast(i);
19
20            if (i >= k - 1) {
21                result[i - k + 1] = nums[dq.peekFirst()];
22            }
23        }
24
25        return result;
26    }
27}
28