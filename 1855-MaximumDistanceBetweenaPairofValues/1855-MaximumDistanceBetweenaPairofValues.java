// Last updated: 19/4/2026, 8:55:47 pm
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        
        int maxDist = 0;

        int i = 0 ;
        int j = 0;

//if nums1 become greater than nums2 then need to increase i, if less need to increase j
        while(i<nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                maxDist = Math.max(maxDist , j-i);
                j++;
            }
            else{
                i++;
            }
        }

        return maxDist;
    }
}