// Last updated: 8/1/2026, 1:01:51 am
1class Solution {
2    public static int maxProfit(int[] arr) {
3		Stack<Integer> st = new Stack<>();
4		int ans = 0;
5		for(int i = 0;i<arr.length;i++) {
6			if(!st.isEmpty() && st.peek()>=arr[i]) {
7				while(!st.isEmpty() && st.peek()>arr[i])st.pop();
8			}else if(!st.isEmpty() && st.peek()<arr[i]){
9				ans += arr[i]-st.pop();
10			}
11			st.push(arr[i]);
12		}
13		return ans;
14		
15
16	}
17}