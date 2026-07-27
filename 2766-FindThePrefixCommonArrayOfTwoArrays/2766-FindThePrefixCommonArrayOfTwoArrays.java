// Last updated: 27/7/2026, 11:43:46 am
class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        int n = a.length;
        int[] pre = new int[n];
        int[] freq = new int[n+1];

        for(int i = 0;i<n; i++){
            int left = (i==0 ? 0:pre[i-1]);
            if(a[i]==b[i]){
                pre[i] = left+1;
            }else{
                freq[a[i]]++;
                freq[b[i]]++;

                if(freq[a[i]]>1)left++;
                if(freq[b[i]]>1)left++;
                pre[i] = left;
            }
        } 
        return pre; 
    }
}