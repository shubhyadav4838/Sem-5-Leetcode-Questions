// Last updated: 3/8/2025, 11:57:06 pm
class Solution {
    public boolean validPalindrome(String s) {
        return isPalindrome(s);
    }
    public static boolean isPalindrome(String s){
        int lo=0, hi=s.length()-1;
        while(hi>lo){
            if(s.charAt(lo)!=s.charAt(hi)){
                if(checkPalindrome(lo+1,hi,s) || checkPalindrome(lo,hi-1,s))return true;
                return false;

            }
            lo++;
            hi--;
        }
        return true;
    }
    // public static boolean checkPalindrome(int lo, int hi, String s){
    //     Stack<Character> st = new Stack<>();
    //     for(int i=lo;i<=hi;i++){
    //         st.push(s.charAt(i));
    //     }
    //     for(int i=lo;i<=hi;i++){
    //         if(st.pop()!=s.charAt(i)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    public static boolean checkPalindrome(int lo, int hi, String s){
       while(hi>lo){
        if(s.charAt(hi)!=s.charAt(lo))return false;
        hi--;
        lo++;
       }
        return true;
    }
}