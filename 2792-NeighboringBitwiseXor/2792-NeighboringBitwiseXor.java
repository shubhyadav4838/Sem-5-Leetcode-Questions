// Last updated: 27/7/2026, 11:43:44 am
class Solution {
    public static boolean doesValidArrayExist(int[] derived) {
		int xor = 0;
		for(int v:derived) {
			xor^=v;
		}
		return xor==0;
	}
}