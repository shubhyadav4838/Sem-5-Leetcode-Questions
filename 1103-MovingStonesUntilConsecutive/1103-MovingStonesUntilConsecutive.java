// Last updated: 3/8/2025, 11:55:31 pm
class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int [] num={a,b,c};
        Arrays.sort(num);
        int min = (num[1]-num[0]<=2 || num[2]-num[1]<=2)?1:2;
        int max = num[2]-num[0]-2;
        return num[2]-num[0]==2?new int[] {0,0} : new int[]{min,max};
    }
}