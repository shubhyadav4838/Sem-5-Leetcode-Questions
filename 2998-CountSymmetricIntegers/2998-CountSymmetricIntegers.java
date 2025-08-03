// Last updated: 3/8/2025, 11:53:42 pm
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        return symmetricInteger(low,high);
    }
    public static int symmetricInteger(int lo, int hi) {
		int count = 0;
		for (int i = lo; i <=hi; i++) {
			if(isSymmetric(i))count++;
		}
		return count;
	}
	private static boolean isSymmetric(int num) {
		// TODO Auto-generated method stub
		String s = ""+num;
		int lo=0,hi=0;
		if(s.length()%2!=0)return false;
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(i<s.length()/2) {
				lo+=ch-'0';
			}else {
				hi+=ch-'0';
			}
		}
		return lo==hi;
		
	}
}