// Last updated: 4/8/2025, 12:02:05 am
class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0)return false;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }else{
                if(st.isEmpty())return false;
                char pre = st.pop();
                if((pre=='{' && ch!='}') || (pre=='(' && ch!=')') || (pre=='[' && ch!=']')){
                    return false;
                }
            }
        }
        if(st.size()!=0)return false;
        return true;
    }
}