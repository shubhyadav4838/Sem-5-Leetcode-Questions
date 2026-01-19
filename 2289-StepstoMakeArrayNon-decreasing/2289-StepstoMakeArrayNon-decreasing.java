// Last updated: 19/1/2026, 2:41:24 pm
1import java.util.*;
2
3class Solution {
4    public int totalSteps(int[] nums) {
5        Stack<Integer> st = new Stack<>();
6        int n = nums.length;
7        int[] dp = new int[n]; 
8        int ans = 0;
9
10        // for (int i = n - 1; i >= 0; i--) {
11        // }
12
13        st.clear();
14        for (int i = 0; i < n; i++) {
15            int curMax = 0;
16            
17            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
18                curMax = Math.max(curMax, dp[st.pop()]);
19            }
20            if (!st.isEmpty()) {
21                dp[i] = curMax + 1;
22                ans = Math.max(ans, dp[i]);
23            } else {
24                dp[i] = 0;
25            }
26            
27            st.push(i);
28        }
29        
30        return ans;
31    }
32}