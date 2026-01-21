// Last updated: 21/1/2026, 11:33:20 am
1class Solution {
2    public static boolean doesValidArrayExist(int[] derived) {
3		int xor = 0;
4		for(int v:derived) {
5			xor^=v;
6		}
7		return xor==0;
8	}
9}