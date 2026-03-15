// Last updated: 15/3/2026, 10:14:34 pm
1class Solution {
2    public int findCircleNum(int[][] arr) {
3        int n = arr.length;
4        boolean[] visited = new boolean[n]; 
5        int compo = 0;
6
7        
8        for (int i = 0; i < n; i++) {
9           
10            if (!visited[i]) {
11                compo++;
12                bfs(i, arr, visited);
13            }
14        }
15        return compo;
16    }
17
18    private void bfs(int startNode, int[][] arr, boolean[] visited) {
19        Queue<Integer> q = new LinkedList<>();
20        q.add(startNode);
21        visited[startNode] = true;
22
23        while (!q.isEmpty()) {
24            int curr = q.poll();
25
26            for (int neighbor = 0; neighbor < arr.length; neighbor++) {
27                if (arr[curr][neighbor] == 1 && !visited[neighbor]) {
28                    visited[neighbor] = true; 
29                    q.add(neighbor);
30                }
31            }
32        }
33    }
34}