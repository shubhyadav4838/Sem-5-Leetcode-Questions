// Last updated: 21/1/2026, 12:12:20 pm
1class Solution {
2   public static int getXORSum(int[] arr1, int[] arr2) {
3		int xor1 = bitwiseXor(arr1);
4		int xor2 = bitwiseXor(arr2);
5		return xor1&xor2;
6	}
7	public static int bitwiseXor(int[] derived) {
8		int xor = 0;
9		for(int v:derived) {
10			xor^=v;
11		}
12		return xor;
13	}
14}