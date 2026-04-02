// Last updated: 2/4/2026, 1:03:25 pm
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
18            int[] height = x.clone();
19            int res = largestRectangleArea(height);
20            ans = Math.max(ans,res);
21        }
22        return ans;
23        
24    }
25    public static int largestRectangleArea(int[] arr) {
26		Stack<Integer> st = new Stack<>();
27		int n = arr.length;
28		int ans = 0;
29		
30		for(int i = 0;i<n; i++) {
31			while(!st.isEmpty() && arr[st.peek()]>arr[i]) {
32				int idx = st.pop();
33				int h = arr[idx];
34				
35				int res = 0;
36				if(st.isEmpty()) {
37					res = h*i;
38				}else {
39					res = (h*(i-st.peek()-1));
40				}
41				ans = Math.max(ans, res);
42				
43			}
44			st.push(i);
45		}
46		
47		int r = arr.length;
48		while(!st.isEmpty()) {
49			int idx = st.pop();
50			int h = arr[idx];
51			
52			int res = 0;
53			if(st.isEmpty()) {
54				res = h*r;
55			}else {
56				res = (h*(r-st.peek()-1));
57			}
58			ans = Math.max(ans, res);
59		}
60		return ans;
61	}
62}