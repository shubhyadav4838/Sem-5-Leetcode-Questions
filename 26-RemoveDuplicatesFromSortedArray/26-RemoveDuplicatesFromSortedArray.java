// Last updated: 4/8/2025, 12:01:56 am
class Solution {
    public int removeDuplicates(int[] nums) {
        return Findk(nums);
        
    }


    public static int[] Duplicate(int [] arr) {
		int check = arr[0];
		int vot = 1;
		int index = 1;
		for(int i = 1; i<arr.length; i++) {
			if(check==arr[i]) {
				vot++;
			}else {
				if(vot>1) {
					check = arr[i];
					arr[index] = arr[i];
					vot = 2;
					index++;
				}else {
                    check = arr[i];
					index++;
				}
			}
		}
		return arr;
	}
	public static int Findk(int [] arr) {
        if(arr.length==1){
            return 1;
        }
        arr=Duplicate(arr);
		int count = 1;
        for(int i = 0; i<arr.length-1; i++) {
        	if(arr[i]<arr[i+1]) {
        		count++;
        	}
        	else {
        		break;
        	}
        }
        return count;
	}
}
