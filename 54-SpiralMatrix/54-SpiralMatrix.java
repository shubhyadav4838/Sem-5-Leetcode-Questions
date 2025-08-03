// Last updated: 4/8/2025, 12:01:17 am
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    return Print(matrix);
        
    }public static List<Integer> Print(int[][]arr) {
		int minc = 0;
		int minr = 0;
		int maxc = arr[0].length-1;
		int maxr = arr.length-1;
		int te = arr.length*arr[0].length;
		int[] ans = new int[arr.length*arr[0].length];
		int c = 0;
		int n = 0;
		
		while(c<te) {
		for(int i = minc; i<=maxc &&c<te; i++) {
//			System.out.print(arr[minr][i]+" ");
			ans[n] = arr[minr][i];
			n++;
			c++;
		}
		minr++;
		for(int i = minr; i<=maxr &&c<te; i++) {
//			System.out.print(arr[i][maxc]+" ");
			ans[n] = arr[i][maxc];
			n++;
			c++;
		}
		maxc--;
		for(int i = maxc; i>=minc &&c<te; i--) {
//			System.out.print(arr[maxr][i]+" ");
			ans[n] = arr[maxr][i];
			n++;
			c++;
		}
		maxr--;
		for(int i= maxr; i>=minr &&c<te; i--) {
//			System.out.print(arr[i][minc]+" ");
			ans[n] = arr[i][minc];
			n++;
			c++;
		}
		minc++;
	}
//		System.out.println();
		List<Integer> list=  IntStream.of(ans).boxed().collect(Collectors.toList());
        return list;
	}

}