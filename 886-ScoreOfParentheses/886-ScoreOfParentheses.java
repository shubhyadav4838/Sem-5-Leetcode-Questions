// Last updated: 3/8/2025, 11:56:27 pm
import java.util.Stack;

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Character> st = new Stack<>();
        int sum = 0; 

        for(char c : s.toCharArray()) {
            if(!st.isEmpty() && c == ')' && st.peek() == '(') {
                st.pop();
                st.push('1'); 
            } else if(c == ')') {
                int val = solve(st);
                st.push((char)(val + '0')); 
            } else {
                st.push(c);
            }
        }

        while(!st.isEmpty()) {
            sum += st.pop() - '0';
        }

        return sum;
    }

    public int solve(Stack<Character> st) {
        int tempSum = 0;
        while(!st.isEmpty() && st.peek() != '(') {
            tempSum += st.pop() - '0'; 
        }
        st.pop(); 
        return 2 * tempSum;
    }
}
