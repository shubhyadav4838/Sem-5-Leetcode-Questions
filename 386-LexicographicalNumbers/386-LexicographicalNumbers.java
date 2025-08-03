// Last updated: 3/8/2025, 11:58:38 pm
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> l = new ArrayList<Integer>();
        print(n,0,l);
        return l;

    }
    public static void print(int n, int curr, List<Integer> l) {
		if(curr>n) {
			return;
		}
		// System.out.println(curr);
        
		int i=0;
		if(curr==0) {
			i = 1;
		}else{
            l.add(curr);
        }
		for(; i<=9; i++) {
			print(n, curr*10+i,l);	
		}
	}
}