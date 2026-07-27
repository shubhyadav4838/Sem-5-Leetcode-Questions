// Last updated: 27/7/2026, 11:45:50 am
class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		int[] up = new int[colsum.length];
		int[] lo = new int[colsum.length];
		
		for(int i = 0;i<colsum.length;i++) {
			int val = colsum[i];
			if(val==1)continue;
			if(val==2) {
				up[i] = 1;
				lo[i] = 1;
				upper--;
				lower--;
			}
		}
		
		for(int i = 0;i<colsum.length;i++) {
			int val = colsum[i];
			if(val!=1)continue;
			if(upper>0) {
				up[i] = 1;
				upper--;
			}else {
				lo[i] = 1;
				lower--;
			}
		}
		if(upper ==0 && lower==0) {
			for(int i = 0;i<up.length;i++) {
				a.add(up[i]);
				b.add(lo[i]);
			}
			res.add(a);
			res.add(b);
		}
		return res;
    }
}