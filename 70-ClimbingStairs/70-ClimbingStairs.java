// Last updated: 4/8/2025, 12:00:56 am
class Solution {
    public int climbStairs(int n) {
       return count(n); 
    }
    public static int count( int n) {
		if(n==1) {
			return 1;
		}
		int a = 1;
		int b = 1;
		for(int i=1;i<n;i++) {
			int temp = b;
			b = a+b;
			a = temp;
		}
		return b;
	}
}