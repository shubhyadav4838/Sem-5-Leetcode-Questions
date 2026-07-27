// Last updated: 27/7/2026, 11:42:47 am
class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if('a'<=ch && ch<='z'){
                sb.append(ch);
            }else if(ch=='*' && !sb.isEmpty()){
                sb.deleteCharAt(sb.length()-1);
            }else if(ch=='#'){
                sb.append(sb.toString());
            }else if(ch=='%'){
                // StringBuilder temp = String.reverse(sb.toString());
                sb = sb.reverse();
            }

        }
        return sb.toString();

        
    }
}