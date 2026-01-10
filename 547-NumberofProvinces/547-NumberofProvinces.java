// Last updated: 10/1/2026, 1:07:30 pm
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        boolean[] visited = new boolean[isConnected.length];
        int cities = isConnected.length;

        for(int ind = 0; ind < cities; ind ++){
            if(visited[ind] == false){
                provinces ++;
                dfs(ind, isConnected, visited);
            }
        }

        return provinces;
    }

    private void dfs(int node, int[][] isConnected, boolean[] visited){
        visited[node] = true;

        for(int neigh = 0; neigh < isConnected[node].length; neigh ++){
            if(isConnected[node][neigh] == 1 && visited[neigh] == false)
                dfs(neigh, isConnected, visited);
        }
    }
}