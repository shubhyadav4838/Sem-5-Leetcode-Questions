// Last updated: 3/8/2025, 11:57:08 pm
class Solution {
    public int maximumSwap(int num) {
        return Swap(num);
    }
    public static int Swap(int n) {
		ArrayList<Integer> ll = new ArrayList<>();
		if(alreadyGreater(n)) {
            return n;
		}
		int temp_n = n;
		while(temp_n>0) {
			ll.add(temp_n%10);
			temp_n/=10;
		}
		// System.out.println(ll);
		for(int i=ll.size()-2;i>=0;i--) {
			int max = LargestElement(ll,ll.get(i+1),i);
			if(max!=-1 && ll.get(max)>ll.get(i+1)) {
				int temp = ll.get(max);
				ll.set(max, ll.get(i+1));
				ll.set(i+1, temp);
				break;
			}
		}
		int ans = 0;
		for(int i=ll.size()-1;i>=0;i--) {
			ans+=ll.get(i)*Math.pow(10, i);
		}
        return ans;
		

	}
	public static int LargestElement(ArrayList<Integer> ll,int max, int i) {
		int idx = -1;
		for(int k=0;k<=i;k++) {
			if(ll.get(k)>max) {
				// System.out.println(k);
				max = ll.get(k);
				idx=k;
			}
		}
		return idx;
	}
	
 	public static boolean alreadyGreater(int n) {
		int pre = n%10;
		n = n/10;
		while(n>0) {
			int curr = n%10;
			n/=10;
			if(pre>curr) {
				return false;
			}
			pre=curr;
		}
		return true;
	}
}