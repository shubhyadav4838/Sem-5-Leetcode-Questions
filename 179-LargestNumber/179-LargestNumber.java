// Last updated: 3/8/2025, 11:59:47 pm
class Solution {
    public String largestNumber(int[] nums) {
        return largest(nums);
    }
    public static String largest(int[] arr) {
		String[] ans = new String[arr.length];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ans.length; i++) {
			ans[i] = arr[i]+"";
			
		}
		for (int i = 0; i < ans.length; i++) {
			for(int j=1;j<ans.length-i;j++) {
				if((ans[j-1]+ans[j]).compareTo(ans[j]+ans[j-1])>0) {
					String temp = ans[j];
					ans[j] = ans[j-1];
					ans[j-1]=temp;
				}
			}
		}
        if(ans[ans.length-1].compareTo("0")==0)return "0";
		for (int i = ans.length-1; i >=0; i--) {
			sb.append(ans[i]);
		}
       
		return sb.toString();
	}
}