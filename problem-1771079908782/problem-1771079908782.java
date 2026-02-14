// Last updated: 14/2/2026, 8:08:28 pm
1class Solution {
2   public static String mapWordWeights(String[] words, int[] weights) {
3		StringBuilder sb = new StringBuilder();
4		for(String s:words) {
5			int sum = 0;
6			for(char ch:s.toCharArray()){
7				sum += weights[(ch-'a')];
8			}
9			char k  = (char)('a'+26-(sum%26)-1);
10			sb.append(k);
11		}
12		return sb.toString();
13	}
14}