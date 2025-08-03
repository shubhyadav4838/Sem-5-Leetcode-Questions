// Last updated: 4/8/2025, 12:00:44 am
class Solution {
    public boolean exist(char[][] arr, String word) {
        for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				boolean ans = wordSearch(arr,word,i,j);
				if(ans) {
					return true;
				}
			}
		}
        return false;
    }
    public static boolean wordSearch(char[][]arr,String word,int cr,int cc) {
		if(word.length()==0) {
			return true;
		}
		if(cr>=arr.length || cc>=arr[0].length || cr<0 || cc<0 || arr[cr][cc]=='-') {
			return false;
		}
		char ch = word.charAt(0);
		if(ch==arr[cr][cc]) {
			arr[cr][cc]='-';
			boolean  a = wordSearch(arr,word.substring(1),cr+1,cc);
			boolean  b =wordSearch(arr,word.substring(1),cr-1,cc);
			boolean  c =wordSearch(arr,word.substring(1),cr,cc+1);
			boolean  d =wordSearch(arr,word.substring(1),cr,cc-1);
			if(a|| b|| c|| d)return true;
			arr[cr][cc]=ch;
		}
		return false;
		
	}
}