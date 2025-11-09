// Last updated: 9/11/2025, 8:32:13 am
class Solution {
public static int minimumDistance(int[] arr) {
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			map.putIfAbsent(arr[i], new ArrayList<>());
			map.get(arr[i]).add(i);
		}
		int ans = Integer.MAX_VALUE;
		for(int x:map.keySet()) {
			ArrayList<Integer> ll = map.get(x);
			
			Collections.sort(ll);
			if(ll.size()>2) {
				for(int i=0;i<ll.size()-2;i++) {
					int a = ll.get(i);
					int b = ll.get(i+1);
					int c = ll.get(i+2);
					int res = Math.abs(a-b)+Math.abs(b-c)+Math.abs(c-a);
					ans = Math.min(ans, res);
					
				}
			}
			
		}
        if(ans==Integer.MAX_VALUE)return -1;
		return ans;

	}
}