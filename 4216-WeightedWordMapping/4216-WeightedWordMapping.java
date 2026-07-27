// Last updated: 27/7/2026, 11:42:01 am
class Solution {
   public static String mapWordWeights(String[] words, int[] weights) {
		StringBuilder sb = new StringBuilder();
		for(String s:words) {
			int sum = 0;
			for(char ch:s.toCharArray()){
				sum += weights[(ch-'a')];
			}
			char k  = (char)('a'+26-(sum%26)-1);
			sb.append(k);
		}
		return sb.toString();
	}
}