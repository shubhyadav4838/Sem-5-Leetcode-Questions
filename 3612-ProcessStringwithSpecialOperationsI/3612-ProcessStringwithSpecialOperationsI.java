// Last updated: 16/6/2026, 2:08:46 pm
1class Solution {
2    public String processStr(String s) {
3        StringBuilder sb = new StringBuilder();
4        for(int i=0;i<s.length();i++){
5            char ch = s.charAt(i);
6            if('a'<=ch && ch<='z'){
7                sb.append(ch);
8            }else if(ch=='*' && !sb.isEmpty()){
9                sb.deleteCharAt(sb.length()-1);
10            }else if(ch=='#'){
11                sb.append(sb.toString());
12            }else if(ch=='%'){
13                // StringBuilder temp = String.reverse(sb.toString());
14                sb = sb.reverse();
15            }
16
17        }
18        return sb.toString();
19
20        
21    }
22}