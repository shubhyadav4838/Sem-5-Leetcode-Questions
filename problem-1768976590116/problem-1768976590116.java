// Last updated: 21/1/2026, 11:53:10 am
1class Solution {
2   public static int xorAllNums(int[] nums1, int[] nums2) {
3		int n = nums1.length;
4		int m = nums2.length;
5		if(n%2==0 && m%2==0)return 0;
6		
7		int xor1 = bitwiseXor(nums1);
8		int xor2 = bitwiseXor(nums2);
9		
10		if(n%2==1 && m%2==1) {
11			return xor1^xor2;
12		}else if(n%2==1) { 
13//			odd wale array ka even pair hoga inka xor 0 h isliye yaha se even wala
14//			return kra hai 
15			return xor2;
16		}else {
17			return xor1;
18		}
19	}
20
21	public static int bitwiseXor(int[] arr) {
22		int xor = 0;
23		for(int v:arr) {
24			xor^=v;
25		}
26		return xor;
27		
28		
29	}
30
31}