// Last updated: 13/10/2025, 12:35:44 am
class Solution {
    public int longestBalanced(String s) {
	        int ans = 1;
	        for(int i=0;i<s.length();i++){
	            int[] arr = new int[26];
	            arr[s.charAt(i)-'a']++;
	            for(int j=i+1;j<s.length();j++){
	            	arr[s.charAt(j)-'a']++;
	                if(isvalid(arr,arr[s.charAt(i)-'a'])){
	                    ans = Math.max(ans,j-i+1);
	                }
	            }
	            
	        }
	        return ans;
	        
	    }
	    public static boolean isvalid(int[] arr, int count){
	       for(int i=0;i<arr.length;i++) {
	    	   if(arr[i]==0)continue;
	    	   if(arr[i]!=count)return false;
	       }
	       return true;

	    }
}