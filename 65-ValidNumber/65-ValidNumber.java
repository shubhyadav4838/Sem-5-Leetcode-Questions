// Last updated: 4/8/2025, 12:01:01 am
class Solution {
    public static boolean isNumber(String s) {
    	boolean digit = false, e = false, dot = false;
    	int sign = 0;
    	
    	for (int i = 0; i < s.length(); i++) {
			char ch  = s.charAt(i);
			
			if(Character.isDigit(ch)) digit = true;
			
			else if(ch=='+'||ch=='-') {
				if(sign == 2) return false;
				if(i>0 && (s.charAt(i-1)!='e' && s.charAt(i-1)!='E')) return false;
				if(i==s.length()-1) return false;
				sign++;
			}else if(ch=='.') {
				if(dot || e) return false;
				if(i==s.length()-1 && !digit) return false;
				dot = true;
			}else if(ch=='e'|| ch=='E') {
				if(e || !digit || i== s.length()-1) return false;
				e = true;
			}else return false;
		}
    	return true;
    }
}