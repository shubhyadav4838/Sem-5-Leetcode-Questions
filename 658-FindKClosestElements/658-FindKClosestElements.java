// Last updated: 3/8/2025, 11:57:12 pm
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length-k;

        while(low<high){
            int mid = low+(high-low)/2;

            if(x-arr[mid]>arr[mid+k]-x){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }

        List<Integer>list = new ArrayList<>();
        for(int i=low; i<low+k; i++){
            list.add(arr[i]);
        }

        return list;
    }
}
