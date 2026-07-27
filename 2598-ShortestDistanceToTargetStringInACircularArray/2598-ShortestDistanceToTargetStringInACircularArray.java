// Last updated: 27/7/2026, 11:43:56 am
class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int ans = Integer.MAX_VALUE;

        for(int i = 0;i<words.length; i++){
            if(words[i].equals(target)){
                int front = Math.abs(startIndex-i);
                int back = words.length-Math.max(startIndex,i)+Math.min(startIndex,i);
                int min = Math.min(front,back);
                ans = Math.min(ans,min);
            }
        }
        return (ans==Integer.MAX_VALUE ? -1:ans);
    }
}