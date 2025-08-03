// Last updated: 4/8/2025, 12:00:03 am
class Solution {
    public String reverseWords(String s) {
        s =s.trim();
		// System.out.println(s);
		String [] arr = s.split("\s+");
		// System.out.println(Arrays.toString(arr));
		String ans = "";
		for(int i=arr.length-1; i>=0; i--) {
			ans = ans+arr[i]+" ";
		}
        return ans.trim();
        
    }
}