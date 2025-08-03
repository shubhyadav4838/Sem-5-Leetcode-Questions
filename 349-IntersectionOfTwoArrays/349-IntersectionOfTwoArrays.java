// Last updated: 3/8/2025, 11:58:48 pm
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        return count(nums1,nums2);
    }
    public static int[] count(int[] arr1 , int[] arr2){
        int[] freq = new int[1001];
        ArrayList<Integer> ll = new ArrayList();
        for(int i=0;i<arr1.length;i++){
            freq[arr1[i]]+=1;
        }
        for(int i=0;i<arr2.length;i++){
            if(freq[arr2[i]]!=0){
                ll.add(arr2[i]);
                freq[arr2[i]]=0;
            }
        }
        int[] result = new int[ll.size()];
        for(int i=0;i<ll.size();i++){
            result[i]=ll.get(i);
        }
        return result;

    }
}