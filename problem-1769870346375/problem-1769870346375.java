// Last updated: 31/1/2026, 8:09:06 pm
1class Solution {
2    public static String reverseByType(String s) {
3		Stack<Character> ch = new Stack<>();
4		Stack<Character> sp = new Stack<>();
5		for(char x : s.toCharArray()) {
6			if(x>='a' && x<='z') {
7				ch.push(x);
8			}else {
9				sp.push(x);
10			}
11		}
12		StringBuilder sb = new StringBuilder();
13		for(char x : s.toCharArray()) {
14			if(x>='a' && x<='z') {
15				sb.append(ch.pop());
16			}else {
17				sb.append(sp.pop());
18				
19			}
20		}
21		return sb.toString();
22		
23	}
24}