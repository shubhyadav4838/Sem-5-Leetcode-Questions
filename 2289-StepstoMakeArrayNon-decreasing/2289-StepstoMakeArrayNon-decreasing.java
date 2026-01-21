// Last updated: 21/1/2026, 12:46:45 pm
1class Solution {
2    public int totalSteps(int[] nums) {
3        Stack<Integer> st = new Stack<>();
4        int n = nums.length;
5        int[] dp = new int[n]; 
6        int ans = 0;
7
8        for (int i = 0; i < n; i++) {
9            int curMax = 0;
10            
11            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
12                curMax = Math.max(curMax, dp[st.pop()]);
13            }
14            if (!st.isEmpty()) {
15                dp[i] = curMax + 1;
16                ans = Math.max(ans, dp[i]);
17            } else {
18                dp[i] = 0;
19            }
20            
21            st.push(i);
22        }
23        
24        return ans;
25    }
26}