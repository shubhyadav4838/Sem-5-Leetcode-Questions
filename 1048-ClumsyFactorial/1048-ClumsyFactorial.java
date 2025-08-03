// Last updated: 3/8/2025, 11:55:45 pm
class Solution {
    public int clumsy(int n) {
        Stack<Integer> st = new Stack<>();
        st.push(n--);
        int turn = 0;
        while (n > 0) {
            switch (turn) {
                case 0:
                    st.push(st.pop()*n--);
                    break;
                case 1:
                    st.push(st.pop()/n--);
                    break;
                case 2:
                    st.push(n--);
                    break;
                case 3:
                    st.push((-1)*n--);
                    break;
            }
            turn = (turn + 1) % 4;
        }
        int fact = 0;
        while(!st.isEmpty())fact+=st.pop();
        return fact;
    }
}
