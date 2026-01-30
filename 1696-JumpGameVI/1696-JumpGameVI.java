// Last updated: 30/1/2026, 10:40:24 pm
1import java.util.*;
2
3class Solution {
4    public int maxResult(int[] nums, int k) {
5        int n = nums.length;
6        int[] dp = new int[n];
7        dp[0] = nums[0];
8        
9        Deque<Integer> dq = new ArrayDeque<>();
10        dq.offerLast(0); 
11        
12        for (int i = 1; i < n; i++) {
13            if (dq.peekFirst() < i - k) {
14                dq.pollFirst();
15            }
16            
17            dp[i] = nums[i] + dp[dq.peekFirst()];
18
19            while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) {
20                dq.pollLast();
21            }
22            
23            dq.offerLast(i);
24        }
25        
26        return dp[n - 1];
27    }
28}