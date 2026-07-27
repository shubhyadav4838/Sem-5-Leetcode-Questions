// Last updated: 27/7/2026, 11:42:02 am
class Solution {
    public static String reverseByType(String s) {
		Stack<Character> ch = new Stack<>();
		Stack<Character> sp = new Stack<>();
		for(char x : s.toCharArray()) {
			if(x>='a' && x<='z') {
				ch.push(x);
			}else {
				sp.push(x);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char x : s.toCharArray()) {
			if(x>='a' && x<='z') {
				sb.append(ch.pop());
			}else {
				sb.append(sp.pop());
				
			}
		}
		return sb.toString();
		
	}
}