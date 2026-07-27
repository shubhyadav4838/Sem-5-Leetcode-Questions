// Last updated: 27/7/2026, 11:42:10 am
class Solution {
    public int minimumFlips(int n) {
    	String str = Integer.toBinaryString(n);
    	int right = str.length()-1;
    	int left = 0;
		int rseult = 0;
		while(left<right) {
			if(str.charAt(left++)!=str.charAt(right--)) {
				rseult+=2;
			}
		}
    	return rseult; 
    }
}