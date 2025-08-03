// Last updated: 3/8/2025, 11:55:02 pm
class Solution {
    public int countLargestGroup(int n) {
        return countGroup(n);
    }
    public static int countGroup(int n) {
		int[] arr = new int[101];
		int max = 0;
		for (int i = 1; i <= n; i++) {
			int sum = getSum(i);
			arr[sum]++;
			max = Math.max(arr[sum], max);
			
		}
		int count = 0;
		for(int x:arr) {
			if(x==max)count++;
		}
		return count;

	}
	public static int getSum(int n) {
		String num = ""+n;
		int sum = 0;
		for(int i=0;i<num.length();i++) {
			sum+=num.charAt(i)-'0';
		}
		return sum;
	}
}