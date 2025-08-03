// Last updated: 3/8/2025, 11:56:45 pm
class Solution {
    public int numRabbits(int[] answers) {
        return countRabbits(answers);
    }
    public static int countRabbits(int[]arr) {
		int[] ans = new int[1001];
		int count=0;
		for (int i = 0; i < arr.length; i++) {
			ans[arr[i]]++;
		}
		count+=ans[0];
		for (int i = 1; i < ans.length; i++) {
			if(ans[i]==0)continue;
			if(ans[i]<=i+1) {
				count+=i+1;
			}else {
			count+=((i+1)*(ans[i]/(i+1)));
			if(ans[i]%(i+1)!=0)count+=i+1;
				
			}
		}
		return count;
	}
}