// Last updated: 4/8/2025, 12:01:09 am
class Solution {
    public int[][] generateMatrix(int n) {
        return Print(n);
        
    }
    public static int[][] Print(int num) {
		int [][] arr = new int[num][num];
		int minc = 0;
		int minr = 0;
		int maxc = arr[0].length-1;
		int maxr = arr.length-1;
		int te = arr.length*arr[0].length;
		
		int c = 0;
		int n = 1;
		
		while(c<te) {
		for(int i = minc; i<=maxc &&c<te; i++) {
//			System.out.print(arr[minr][i]+" ");
			arr[minr][i]=n;
			n++;
			c++;
		}
		minr++;
		for(int i = minr; i<=maxr &&c<te; i++) {
//			System.out.print(arr[i][maxc]+" ");
			arr[i][maxc]=n;
			n++;
			c++;
		}
		maxc--;
		for(int i = maxc; i>=minc &&c<te; i--) {
//			System.out.print(arr[maxr][i]+" ");
			arr[maxr][i]=n;
			n++;
			c++;
		}
		maxr--;
		for(int i= maxr; i>=minr &&c<te; i--) {
//			System.out.print(arr[i][minc]+" ");
			arr[i][minc]=n;
			n++;
			c++;
		}
		minc++;
	}
//		System.out.println();
		return arr;
	}
}