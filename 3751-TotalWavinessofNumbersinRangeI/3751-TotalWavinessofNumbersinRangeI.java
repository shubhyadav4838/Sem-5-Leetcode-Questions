// Last updated: 4/6/2026, 10:06:56 pm
1class Solution {
2    public int totalWaviness(int num1, int num2) {
3        return count(num1,num2);
4    }
5    public static int count(int a, int b) {
6    	if(b<100) {
7    		return 0;
8    	}
9    	int count = 0;
10    	for(int i=a;i<=b;i++) {
11            if(i<100)continue;
12    		String s = i+"";
13    		if(i<=999) {
14    			if(s.charAt(1)>s.charAt(0) && s.charAt(1)>s.charAt(2)) {
15    				count++;
16    			}
17    			else if(s.charAt(1)<s.charAt(0) && s.charAt(1)<s.charAt(2)) {
18    				count++;
19    			}
20    		}else {
21    			count+=pv(i);
22    		}
23    	}
24    	return count;
25    }
26    public static int pv(int a) {
27    	int count = 0;
28    	String s = a+"";
29    	for(int i=1;i<s.length()-1;i++ ) {
30    		if(s.charAt(i)>s.charAt(i-1) && s.charAt(i)>s.charAt(i+1)) {
31				count++;
32			}
33			else if(s.charAt(i)<s.charAt(i-1) && s.charAt(i)<s.charAt(i+1)) {
34				count++;
35			}	
36    	}
37    	return count;
38    }
39}