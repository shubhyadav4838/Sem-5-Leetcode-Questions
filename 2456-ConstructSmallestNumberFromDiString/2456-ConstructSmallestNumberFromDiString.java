// Last updated: 3/8/2025, 11:53:57 pm
class Solution {
    public String smallestNumber(String pattern) {
        return ConstructSmallestNumber(pattern);
    }
    public static String ConstructSmallestNumber(String str) {
		int[] ans = new int[str.length()+1];
		Stack<Integer> st = new Stack<>();
        StringBuilder s = new StringBuilder();
		int c = 1;
		for(int i=0;i<=str.length();i++) {
			if(i==str.length() || str.charAt(i)=='I') {
				ans[i]=c;
				c++;
				while(!st.isEmpty()) {
					ans[st.pop()]=c;
					c++;
				}
			}else {
				st.push(i);
			}
		}
		for(int v:ans) {
			s.append(v);
		}
		return s.toString();
	}
}