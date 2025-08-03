// Last updated: 3/8/2025, 11:57:16 pm
class Solution {
    public boolean judgeSquareSum(int c) {
        return Square(c);
    }
    public static boolean Square(int c) {
		long max = (int)Math.sqrt(c);
		long min = 0;
		while(min<=max) {
			long val = (min*min)+(max*max);
			if(val==c) {
				return true;
			}else if(val<c) {
				min++;
			}else {
				max--;
			}
		}
		return false;
	}
}