// Last updated: 11/10/2025, 8:17:38 pm
class Solution {
    public boolean scoreBalance(String s) {
        return balance(s);
        
    }
    public static boolean balance(String s) {
		int sum = 0;
		for(char ch: s.toCharArray()) {
			sum+= ch - 'a'+1;
		}
		int val = 0;
		int num = 0;
		for(char ch : s.toCharArray()) {
			val+=ch-'a'+1;
			if(2*val==sum) return true;
			else num++;
		}
		
		return false;
	}
}