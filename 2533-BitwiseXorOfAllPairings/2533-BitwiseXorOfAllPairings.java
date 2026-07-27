// Last updated: 27/7/2026, 11:44:01 am
class Solution {
   public static int xorAllNums(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		if(n%2==0 && m%2==0)return 0;
		
		int xor1 = bitwiseXor(nums1);
		int xor2 = bitwiseXor(nums2);
		
		if(n%2==1 && m%2==1) {
			return xor1^xor2;
		}else if(n%2==1) { 
//			odd wale array ka even pair hoga inka xor 0 h isliye yaha se even wala
//			return kra hai 
			return xor2;
		}else {
			return xor1;
		}
	}

	public static int bitwiseXor(int[] arr) {
		int xor = 0;
		for(int v:arr) {
			xor^=v;
		}
		return xor;
		
		
	}

}