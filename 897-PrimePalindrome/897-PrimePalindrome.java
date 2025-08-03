// Last updated: 3/8/2025, 11:56:26 pm
class Solution {
    public static int primePalindrome(int n) {
    	if(n>=8 && n<=11)return 11;
    	if(n==1 || n==2)return 2;
    	if(n%2==0)n++;
    	while(true) {
    		if((""+n).length()%2==0) {
    			n = (int)Math.pow(10, (""+n).length());
    		}
    		if(isPalindrom(""+n) && isPrime(n)) return n;
    		n++;
    	}
    }
    private static boolean isPrime(int n) {
    	for(int i = 2 ;i*i<=n ; i++) {
    		if(n%i==0)return false;
    	}
		return true;
	}

	private static boolean isPalindrom(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}