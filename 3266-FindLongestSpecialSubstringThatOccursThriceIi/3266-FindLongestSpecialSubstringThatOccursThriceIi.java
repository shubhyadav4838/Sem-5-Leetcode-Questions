// Last updated: 27/7/2026, 11:43:32 am
class Solution {
    public static int maximumLength(String s) {
		HashMap<Character,ArrayList<Integer>> map = new HashMap<>();
		for(int i = 0;i<26;i++) {
			map.put((char)(i+97), new ArrayList<>());
		}
		char pre = s.charAt(0);
		int len = 1;
		for(int i = 1; i< s.length(); i++) {
			if(s.charAt(i)==pre) {
				len++;
			}else {
				map.get(pre).add(len);
				pre = s.charAt(i);
				len = 1;
			}
		}
		map.get(pre).add(len);
		
		int ans = -1;
		for(char ch:map.keySet()) {
			ArrayList<Integer> ll = map.get(ch);
			if(ll.size()==0)continue;
			int n = ll.size();
			
			Collections.sort(ll);
			System.out.println(ll);
			
			int val = ll.get(ll.size()-1)-2;
			if(ll.size()>=3) {
				val = Math.max(val, ll.get(ll.size()-3));
			}
			if(ll.size()>=2) {
				int num = ll.get(ll.size()-2);
				if(ll.get(n-1)==ll.get(n-2))num--;
				val = Math.max(val, num);
			}
			if(val<=0) {
				int sum= 0;
				for(int x:ll) {
					sum+=x;
				}
				if(sum>=3)val = 1;
			}
			if(val>0) {
				ans = Math.max(val, ans);
				
			}
			
		}
		
		
		
		return ans;

	}
}