// Last updated: 15/4/2026, 11:18:27 am
1class Solution {
2    public int closestTarget(String[] words, String target, int startIndex) {
3        int ans = Integer.MAX_VALUE;
4
5        for(int i = 0;i<words.length; i++){
6            if(words[i].equals(target)){
7                int front = Math.abs(startIndex-i);
8                int back = words.length-Math.max(startIndex,i)+Math.min(startIndex,i);
9                int min = Math.min(front,back);
10                ans = Math.min(ans,min);
11            }
12        }
13        return (ans==Integer.MAX_VALUE ? -1:ans);
14    }
15}