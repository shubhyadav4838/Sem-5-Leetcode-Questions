// Last updated: 4/8/2025, 12:02:12 am
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       return Triplets(nums); 
    }
    public static List<List<Integer>> Triplets(int[]arr){ 
        Arrays.sort(arr);
        List<List<Integer>> ll = new ArrayList<>();
        for(int i=0; i<arr.length-2; i++) {
        	if(i>0 && arr[i]==arr[i-1]) {
        		continue;
        	}
        	int j = i+1, k = arr.length-1;
        	while(j<k) {
        		int sum = arr[i]+arr[j]+arr[k];
        		if(sum==0) {
        			ll.add(Arrays.asList(arr[i],arr[j], arr[k]));
        			while(j<k && arr[j]==arr[j+1])j++;
        			while(j<k && arr[k]==arr[k-1])k--;
        			j++;
        			k--;
        		}else if(sum>0) {
        			k--;
        		}else {
        			j++;
        		}
        	}
        }
        return ll;
       
	}
}