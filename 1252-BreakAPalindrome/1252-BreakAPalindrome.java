// Last updated: 3/8/2025, 11:55:15 pm
class Solution {
    public String breakPalindrome(String palindrome) {
        return removePalindrome(palindrome);
    }
    public static String removePalindrome(String s) {
		String ans = "";
		for(int i=0;i<s.length();i++) {
			if(s.length()%2!=0 && i==s.length()/2)continue;
			char ch = s.charAt(i);
			if(ch>'a') {
				ans = s.substring(0,i)+"a"+s.substring(i+1);
				break;
			}
		}
		if(ans.length()==0) {
			if(s.length()==2) {
				return "ab";
			}else if(s.length()==3) {
				return s.substring(0,2)+"b";
			}else if(s.length()>3){
				return s.substring(0,s.length()-1)+"b";
			}
		}
		return  ans;
	}
}