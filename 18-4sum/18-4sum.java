// Last updated: 4/8/2025, 12:02:08 am
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return Triplets(nums,target);
    }
    public static List<List<Integer>> Triplets(int[]arr, int target){ 
        Arrays.sort(arr);
        List<List<Integer>> ll = new ArrayList<>();
        
        for(int l = 0;l<arr.length-3;l++ ) {
        	if(l>0 && arr[l]==arr[l-1]) {
        		continue;
        	}
        
        for(int i=l+1; i<arr.length-2; i++) {
        	if(i>l+1 && arr[i]==arr[i-1]) {
        		continue;
        	}
        	int j = i+1, k = arr.length-1;
        	while(j<k) {
        		long sum =(long) arr[l]+arr[i]+arr[j]+arr[k];
        		if(sum==target) {
        			ll.add(Arrays.asList(arr[l],arr[i],arr[j], arr[k]));
        			while(j<k && arr[j]==arr[j+1])j++;
        			while(j<k && arr[k]==arr[k-1])k--;
        			j++;
        			k--;
        		}else if(sum>target) {
        			k--;
        		}
        		else {
        			j++;
        		}
        	}
        }
	}
        return ll;
       
	}
}