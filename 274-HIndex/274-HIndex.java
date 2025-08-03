// Last updated: 3/8/2025, 11:59:07 pm
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int st=0,end=n-1;
        int res=0;
        while(st<=end){
            int mid=st+(end-st)/2;
            int idx= n-mid;
            if(citations[mid]>=idx){
                res = idx;
                end = mid-1;
            } else {
                st = mid+1;
            }
        }
        return res;
        
    }
}