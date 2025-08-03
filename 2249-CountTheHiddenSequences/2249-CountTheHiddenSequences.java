// Last updated: 3/8/2025, 11:54:03 pm
class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        return hiddenSequence(differences,lower,upper);
    }
    public static int hiddenSequence(int[] arr,int lower,int upper) {
		long min=1, max = 1;
		long start = 1;
		int change = 0;
		for (int i = 0; i < arr.length; i++) {
			start+=arr[i];
			min = Math.min(min, start);
			max = Math.max(max, start);
			
		}
		if(min<lower) {
			change = (int)(lower-min);
			min+=change;
			max+=change;
		}else if(min>lower) {
			change = (int)(min-lower);
			min-=change;
			max-=change;
		}
        if(min<Integer.MIN_VALUE || max>Integer.MAX_VALUE)return 0;
		if(max>upper) {
			return 0;
		}else {
			return (int)(upper-max+1);
		}
		
	}
}