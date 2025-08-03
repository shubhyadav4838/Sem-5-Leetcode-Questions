// Last updated: 3/8/2025, 11:58:08 pm
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for(int[] p : points){
            Map<Integer,Integer> dist = new HashMap<>();
            for(int [] q : points){
                int dx = p[0]-q[0];
                int dy = p[1]-q[1];
                int sqdist = dx*dx+dy*dy;

                dist.put(sqdist,dist.getOrDefault(sqdist,0)+1);
            }
            for(int i : dist.values()){
                ans+=i*(i-1);
            }
        }
        return ans;
    }
}