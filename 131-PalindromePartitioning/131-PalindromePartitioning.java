// Last updated: 4/8/2025, 12:00:18 am
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
		List<String> ll = new ArrayList<>();
		Part(s,ans,ll);
        return ans;
    }
    public static void Part(String ques,List<List<String>> ans,List<String> ll) {
		if(ques.length()==0) {
			ans.add(new ArrayList<String>(ll));
			return;
		}
		for(int cut=1;cut<=ques.length();cut++) {
			String s = ques.substring(0,cut);
			if(isPalindrome(s)) {
				ll.add(s);
				Part(ques.substring(cut),ans,ll);
				ll.remove(ll.size()-1);
			
			}
		}
	}
	public static boolean isPalindrome(String s) {
		int i= 0;
		int j = s.length()-1;
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}