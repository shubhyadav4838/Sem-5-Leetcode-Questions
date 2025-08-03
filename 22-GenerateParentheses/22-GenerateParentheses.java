// Last updated: 4/8/2025, 12:02:00 am
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ll = new ArrayList<>();
		Parantheses(n,0,0,"",ll);
        return ll;
    }
    public static void Parantheses(int n, int close, int open, String ans,List<String> ll ) {
		if(open ==n && close ==n) {
			ll.add(ans);
			return;
		}
		if(open>n || close>open) {
			return;
		}
		Parantheses(n,close,open+1,ans+"(",ll);
		Parantheses(n,close+1,open,ans+")",ll);
		
	}

}