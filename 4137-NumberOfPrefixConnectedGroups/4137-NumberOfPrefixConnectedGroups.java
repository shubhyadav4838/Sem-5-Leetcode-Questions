// Last updated: 27/7/2026, 11:42:06 am
class Solution {
    public static int prefixConnected(String[] words, int k) {
	     Arrays.sort(words);
	     int n = words.length;
	     int ans = 0;
	     String pre = "";
	     int count = 1;
	     for(int i  = 0;i<n;i++) {
	    	 String s = words[i];
	    	 if(s.length()<k)continue;
	    	 if(pre.equals(s.subSequence(0, k))) {
	    		 count++;
	    	 }else {
	    		 if(count>1)ans++;
	    		 pre = s.substring(0,k);
	    		 count = 1;
	    	 }
	     }
	     if(count>1) {
	    	 ans++;
	     }
	     return ans;
		 
	 }
}