// Last updated: 2/4/2026, 1:03:43 pm
1class Solution {
2    public int maximalRectangle(char[][] matrix) {
3        int[][] arr = new int[matrix.length][matrix[0].length];
4        for(int i = 0;i<arr.length;i++){
5            for(int j = 0; j<arr[0].length; j++){
6                if(matrix[i][j] =='1')arr[i][j] = 1;
7            }
8        }
9        for(int i = 1; i<arr.length; i++){
10            for(int j = 0; j<arr[0].length; j++){
11                if(arr[i][j]!=0){
12                    arr[i][j] += arr[i-1][j];
13                }
14            }
15        }
16        int ans = 0;
17        for(int [] x: arr){
18            int res = largestRectangleArea(x);
19            ans = Math.max(ans,res);
20        }
21        return ans;
22        
23    }
24    public static int largestRectangleArea(int[] arr) {
25		Stack<Integer> st = new Stack<>();
26		int n = arr.length;
27		int ans = 0;
28		
29		for(int i = 0;i<n; i++) {
30			while(!st.isEmpty() && arr[st.peek()]>arr[i]) {
31				int idx = st.pop();
32				int h = arr[idx];
33				
34				int res = 0;
35				if(st.isEmpty()) {
36					res = h*i;
37				}else {
38					res = (h*(i-st.peek()-1));
39				}
40				ans = Math.max(ans, res);
41				
42			}
43			st.push(i);
44		}
45		
46		int r = arr.length;
47		while(!st.isEmpty()) {
48			int idx = st.pop();
49			int h = arr[idx];
50			
51			int res = 0;
52			if(st.isEmpty()) {
53				res = h*r;
54			}else {
55				res = (h*(r-st.peek()-1));
56			}
57			ans = Math.max(ans, res);
58		}
59		return ans;
60	}
61}