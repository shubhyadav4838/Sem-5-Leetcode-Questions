// Last updated: 22/11/2025, 8:17:38 pm
class Solution {
    public int totalWaviness(int num1, int num2) {
        return count(num1,num2);
    }
    public static int count(int a, int b) {
    	if(b<100) {
    		return 0;
    	}
    	int count = 0;
    	for(int i=a;i<=b;i++) {
            if(i<100)continue;
    		String s = i+"";
    		if(i<=999) {
    			if(s.charAt(1)>s.charAt(0) && s.charAt(1)>s.charAt(2)) {
    				count++;
    			}
    			else if(s.charAt(1)<s.charAt(0) && s.charAt(1)<s.charAt(2)) {
    				count++;
    			}
    		}else {
    			count+=pv(i);
    		}
    	}
    	return count;
    }
    public static int pv(int a) {
    	int count = 0;
    	String s = a+"";
    	for(int i=1;i<s.length()-1;i++ ) {
    		if(s.charAt(i)>s.charAt(i-1) && s.charAt(i)>s.charAt(i+1)) {
				count++;
			}
			else if(s.charAt(i)<s.charAt(i-1) && s.charAt(i)<s.charAt(i+1)) {
				count++;
			}	
    	}
    	return count;
    }
}