// Last updated: 27/7/2026, 11:42:00 am
class Solution {
   public static int minMirrorPairDistance(int[] arr) {
		HashMap<Integer,Integer> map = new HashMap<>();
		int ans = Integer.MAX_VALUE;
		for(int i = 0;i<arr.length; i++) {
			int rev = getReverse(arr[i]);
			if(map.containsKey(rev) && arr[i]%10!=0) {
				ans = Math.min(ans, i-map.get(rev));
			}
			while(arr[i]%10==0) {
				arr[i] = arr[i]/10;
			}
			map.put(arr[i], i);
		}
		return (ans==Integer.MAX_VALUE ? -1:ans);
	}

	private static int getReverse(int val) {
		// TODO Auto-generated method stub
		while(val%10==0) {
			val = val/10;
		}
		
		int sum = 0;
		while(val>0) {
			int rem = val%10;
			val = val/10;
			sum = sum*10+rem;
			
		}
		return sum;
	}

}