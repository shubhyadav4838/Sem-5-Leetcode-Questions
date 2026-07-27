// Last updated: 27/7/2026, 11:44:46 am
class Solution {
   public static int getXORSum(int[] arr1, int[] arr2) {
		int xor1 = bitwiseXor(arr1);
		int xor2 = bitwiseXor(arr2);
		return xor1&xor2;
	}
	public static int bitwiseXor(int[] derived) {
		int xor = 0;
		for(int v:derived) {
			xor^=v;
		}
		return xor;
	}
}