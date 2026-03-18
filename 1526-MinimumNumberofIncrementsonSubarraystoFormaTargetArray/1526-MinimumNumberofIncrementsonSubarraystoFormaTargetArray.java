// Last updated: 18/3/2026, 11:38:59 pm
1class Solution {
2    public int totalSteps(int[] arr) {
3        int n = arr.length;
4        int[] dp = new int[n];
5        int ans = 0;
6        Stack<Integer> st = new Stack<>();
7        for(int i = 0; i<n;i++){
8            int curr = 0;
9            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
10                curr = Math.max(curr,dp[st.pop()]);
11            }
12
13            if(!st.isEmpty()){
14                dp[i] = curr+1;
15                ans = Math.max(dp[i],ans);
16            }
17            st.push(i);
18        }
19        return ans;
20    }
21}