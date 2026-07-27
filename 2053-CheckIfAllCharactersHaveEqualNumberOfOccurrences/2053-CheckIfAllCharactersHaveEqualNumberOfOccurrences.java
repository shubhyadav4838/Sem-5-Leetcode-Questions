// Last updated: 27/7/2026, 11:44:32 am
class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] arr = new int[26];
        for(char ch:s.toCharArray()){
            arr[ch-'a']++;
        }
        int pre = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0)continue;
            if(pre==-1)pre = arr[i];
            if(arr[i]!=pre)return false;
        }
        return true;
    }
}