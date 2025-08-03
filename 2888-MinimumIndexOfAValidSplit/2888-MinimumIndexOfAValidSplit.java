// Last updated: 3/8/2025, 11:53:45 pm
class Solution {
    public int minimumIndex(List<Integer> nums) {
        if(nums.size()==2)return 0;
        else if(nums.size()==1)return -1;
        return validSplit(nums);
    }
    public static int validSplit(List<Integer> arr) {
		int element = 0;
		int vote = 1;
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i)==element) {
				vote++;
			}else {
				vote--;
				if(vote==0) {
					element=arr.get(i);
					vote=1;
				}
			}
		}
		int total = 0;
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i)==element)total++;
		}
       int count=0;
		int result = -1;
		for (int i = 0; i < arr.size()-1; i++) {
			if(arr.get(i)==element)count++;                    
			if(count==(i+1)/2+1 && total-count>(arr.size()-i-1)/2) {
				result=i;
				break;
			}
		}
		return result;
	}
}