// Last updated: 14/2/2026, 8:17:30 pm
1class Solution {
2    public static int prefixConnected(String[] words, int k) {
3	     Arrays.sort(words);
4	     int n = words.length;
5	     int ans = 0;
6	     String pre = "";
7	     int count = 1;
8	     for(int i  = 0;i<n;i++) {
9	    	 String s = words[i];
10	    	 if(s.length()<k)continue;
11	    	 if(pre.equals(s.subSequence(0, k))) {
12	    		 count++;
13	    	 }else {
14	    		 if(count>1)ans++;
15	    		 pre = s.substring(0,k);
16	    		 count = 1;
17	    	 }
18	     }
19	     if(count>1) {
20	    	 ans++;
21	     }
22	     return ans;
23		 
24	 }
25}