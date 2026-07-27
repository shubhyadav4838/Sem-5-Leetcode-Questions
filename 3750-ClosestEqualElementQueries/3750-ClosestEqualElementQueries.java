// Last updated: 27/7/2026, 11:42:59 am
class Solution {
    public static ArrayList<Integer> solveQueries(int[] arr, int[] query) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];
			map.putIfAbsent(arr[i], new ArrayList<>());
			map.get(val).add(i);
		}
		ArrayList<Integer> ll = new ArrayList<>();
		for (int i = 0; i < query.length; i++) {
			int idx = search(map, query[i], arr);
			ll.add(idx);
		}
		return ll;

	}

	private static int search(HashMap<Integer, ArrayList<Integer>> map, int i, int[] arr) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ll = map.get(arr[i]);
		int n = arr.length;
		if (ll.size() <= 1) {
			return -1;
		}
		int target = i;
		int lo = 0;
		int hi = ll.size()-1;
		int ans = -1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if(ll.get(mid) == target ) {
				ans = mid;
				break;
			}else if(ll.get(mid)>target) {
				hi = mid-1;
			}else {
				lo = mid+1;
			}
			
		}
		int size = ll.size();
		int pre = ll.get((size+ans-1)%size);
		int post = ll.get((ans+1)%size);
		
		int front = Math.min(Math.abs(pre-i), n-Math.abs(pre-i));
		int back = Math.min(Math.abs(post-i), n-Math.abs(post-i));
		return Math.min(front,back);
	}
}