// Last updated: 3/8/2025, 11:54:28 pm
class Solution {
    public int[] minOperations(String s) {
        int n = s.length();
        int [] arr = new int[n];
        int [] l = new int[n];
        int [] r = new int[n];
        int count = 0;
        if(s.charAt(0)=='1')count++;
        for(int i=1;i<n;i++){
            l[i]=l[i-1]+count;
            if(s.charAt(i)=='1')count++;
        }
        if(s.charAt(n-1)=='1')count=1;
        else count=0;
        for(int i = n-2;i>=0;i--){
            r[i]=r[i+1]+count;
            if(s.charAt(i)=='1')count++;
        }
        for(int i=0;i<n;i++){
            arr[i]=l[i]+r[i];
        }
        return arr;
    }
}