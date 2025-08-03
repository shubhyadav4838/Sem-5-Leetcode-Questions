// Last updated: 3/8/2025, 11:58:30 pm
class Solution {
    public String decodeString(String sx) {
        Stack<String> st = new Stack<>();
        for(int i=0;i<sx.length();i++){
            if(sx.charAt(i)!=']')st.push(sx.charAt(i)+"");
            else{
                String s = "";
                while(!st.isEmpty()  &&  !st.peek().equals("[")){
                    s=st.pop()+s;
                }
                st.pop();
                String a ="";
                while(!st.isEmpty() && Character.isDigit(st.peek().charAt(0)))a=st.pop()+a;
                int t =  Integer.parseInt(a);
                String temp = s;
                for(int j = 1;j<t;j++)s=s+temp;
                st.push(s);
            }
        }
        String ans = "";
        while(!st.isEmpty())ans=st.pop()+ans;
        return ans;
    }
}