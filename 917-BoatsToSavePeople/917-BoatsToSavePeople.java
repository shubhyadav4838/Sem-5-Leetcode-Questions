// Last updated: 3/8/2025, 11:56:19 pm
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        return SavePeople(people, limit);
        
    }
    public static int SavePeople(int [] arr, int limit) {
		Arrays.sort(arr);
		int min = 0;
		int max = arr.length-1;
		int count = 0;
		while(min<=max) {
			int sum = arr[min]+arr[max];
			if(sum>limit) {
				count++;
				max--;
			}else {
				max--;
				min++;
				count++;
			}
		}
		return count;
	}
}