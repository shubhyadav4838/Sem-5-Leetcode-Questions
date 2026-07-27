// Last updated: 27/7/2026, 11:44:10 am
class Solution {
    public int totalSteps(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n;i++){
            int curr = 0;
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                curr = Math.max(curr,dp[st.pop()]);
            }

            if(!st.isEmpty()){
                dp[i] = curr+1;
                ans = Math.max(dp[i],ans);
            }
            st.push(i);
        }
        return ans;
    }
}