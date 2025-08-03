// Last updated: 3/8/2025, 11:52:57 pm
class Solution {
    public String findValidPair(String s) {
        return validPair(s);
    }
    public String validPair(String s){
       int []arr = new int[10];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'0']+=1;
        }
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)-'0'==arr[s.charAt(i)-'0'] && s.charAt(i+1)-'0'==arr[s.charAt(i+1)-'0'] && s.charAt(i)!=s.charAt(i+1)){
                return s.substring(i,i+2);
            }
        }
        return "";
        
    }
}