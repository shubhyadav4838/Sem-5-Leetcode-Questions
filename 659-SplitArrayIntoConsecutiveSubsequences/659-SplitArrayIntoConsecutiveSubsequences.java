// Last updated: 3/8/2025, 11:57:10 pm
class Solution {
    public static boolean isPossible(int[] arr) {
        
		if(arr.length<3)return false;
		int[] ans = new int[arr.length/2];
		int[] count = new int[ans.length];
		ans[0] = arr[0]+1;
		count[0]++;
		int idx = 0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==ans[idx]) {
				ans[idx]++;
				count[idx]++;
			}else {
				int k = idx-1;
				while(k>=0 && ans[k]!=arr[i] && ans[k]>arr[i]) k--;
				if(k<0 || ans[k]!=arr[i]) {
					idx++;
					if(idx==ans.length)return false;
					ans[idx]=arr[i]+1;
					count[idx]++;
				}else {
					ans[k]++;
					count[k]++;
				}
			}
		}
//		for(int i=0;i<ans.length;i++) {
//			System.out.println(ans[i]+" "+count[i]);
//		}
		for(int i=0;i<count.length;i++) {
			if(count[i]==1 || count[i]==2)return false;
		}
		return true;
		
		

	}
}